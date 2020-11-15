package ooxml;

import freemarker.core.Environment;
import freemarker.ext.beans.StringModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static java.lang.String.format;

public class SharedStringDirective implements TemplateDirectiveModel {
    @Override
    public void execute(
            Environment env,
            Map params,
            TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
        if (!params.isEmpty()) {
            throw new TemplateModelException(
                    "This directive does not require parameters.");
        }

        StringModel model = ((StringModel) env.getDataModel().get("workbook"));
        Workbook workbook = (Workbook) model.getWrappedObject();

        // If there is non-empty nested content:
        if (body != null) {
            StringWriter writer = new StringWriter();
            // Executes the nested body. Same as <#nested> in FTL, except
            // that we use our own writer instead of the current output writer.
            body.render(writer);
            String node = writer.getBuffer().toString();
            int index = workbook.createSharedString(node);
            env.getOut().write(format("<v>%s</v>", index));
        } else {
            throw new RuntimeException("missing body");
        }
    }
}
