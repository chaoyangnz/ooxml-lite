package ooxml;

import freemarker.core.Environment;
import freemarker.ext.beans.StringModel;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static ooxml.Cell.FORMULA;
import static ooxml.Cell.NUMBER;
import static ooxml.Cell.SHARED_STRING;
import static ooxml.Cell.STRING;

public class CellDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (params.isEmpty()) {
            throw new TemplateModelException(
                    "This directive requires parameters.");
        }
        if (body == null) {
            throw new TemplateModelException("missing body");
        }

        String type = ((SimpleScalar) params.get("t")).getAsString();
        String style = ((SimpleScalar) params.get("s")).getAsString();
        int row = Integer.parseInt(((SimpleScalar) params.get("r")).getAsString());
        int column = Integer.parseInt(((SimpleScalar) params.get("c")).getAsString());

        StringModel model = ((StringModel) env.getDataModel().get("workbook"));
        Workbook workbook = (Workbook) model.getWrappedObject();


        StringWriter writer = new StringWriter();

        body.render(writer);
        String nested = writer.getBuffer().toString().trim();

        Cell cell;
        switch (type) {
            case NUMBER: cell = Cell.newNumber(nested); break;
            case STRING: cell = Cell.newString(nested); break;
            case SHARED_STRING:
                int index = workbook.createSharedString(nested);
                cell = Cell.newSharedString(index);
                break;
            case FORMULA:
                SimpleScalar formulaParam = (SimpleScalar) params.get("f");
                if(formulaParam == null) {
                    throw new TemplateModelException("formula is required");
                }
                String formula = formulaParam.getAsString();
                cell = Cell.newFormula(formula, nested);
                break;
            default:
                throw new TemplateModelException("Unknown cell type: " + type);
        }


        env.getOut().write(cell.render(row, column, style));
    }
}
