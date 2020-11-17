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

public class StyleDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body == null) {
            throw new TemplateModelException("missing body");
        }

        StringModel model = ((StringModel) env.getDataModel().get("workbook"));
        Workbook workbook = (Workbook) model.getWrappedObject();

        StringWriter writer = new StringWriter();

        body.render(writer);
        String nested = writer.getBuffer().toString().trim();
    }
}
