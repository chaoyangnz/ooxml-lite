import freemarker.template.TemplateException;
import ooxml.Sheet;
import ooxml.Workbook;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, TemplateException {
        Workbook workbook = new Workbook();
        Sheet sheet = workbook.createSheet("sheet1.xml.ftl", "detailedView");
        WorkCardSummary rowData1 = new WorkCardSummary("worker1", "new", "1000", 6.0, 2.0, 0.0);
        rowData1.workerCell = workbook.createSharedString(rowData1.produceCell());
        WorkCardSummary rowData2 = new WorkCardSummary("worker2", "new", "2000", 4.0, 2.0, 2.0);
        rowData2.workerCell = workbook.createSharedString(rowData2.produceCell());
        sheet.getData().add(rowData1);
        sheet.getData().add(rowData2);

        workbook.render();
    }
}
