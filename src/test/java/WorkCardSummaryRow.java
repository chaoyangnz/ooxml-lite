import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WorkCardSummaryRow {
    public final String worker;
    public final String classification;
    public final String eid;
    public final Double regularTime;
    public final Double overTime;
    public final Double doubleTime;
    @Getter
    public int workerCell;

    public String produceCell() {
        return String.format("<r>\n" +
                "                            <t>%s</t>\n" +
                "                        </r>\n" +
                "                        <r>\n" +
                "                            <rPr>\n" +
                "                                <sz val=\"7\"/>\n" +
                "                                <rFont val=\"Roboto light\"/>\n" +
                "                                <charset val=\"134\"/>\n" +
                "                            </rPr>\n" +
                "                            <t xml:space=\"preserve\">&#10;%s&#10;EID %s</t>\n" +
                "                        </r>", worker, classification, eid);
    }

    public Double getTotal() {
        return regularTime + overTime + doubleTime;
    }
}