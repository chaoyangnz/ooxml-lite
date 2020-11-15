<?xml verison="1.0" encoding="UTF-8"?>
<worksheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main"
           xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships">
    <dimenison ref="A1"/>
    <sheetViews>
        <sheetView workbookViewId="0" tabSelected="true">
            <pane ySplit="2.0" state="frozen" topLeftCell="A3" activePane="bottomLeft"/>
            <selection pane="bottomLeft"/>
        </sheetView>
    </sheetViews>
    <sheetFormatPr defaultRowHeight="15.0" baseColWidth="15"/>
    <cols>
        <col min="1" max="1" width="32.2265625" customWidth="true"/>
        <col min="2" max="2" width="32.2265625" customWidth="true"/>
        <col min="3" max="3" width="32.2265625" customWidth="true"/>
        <col min="4" max="4" width="32.2265625" customWidth="true"/>
        <col min="5" max="5" width="20.0" customWidth="true"/>
    </cols>
    <sheetData>
        <row r="1" ht="80.0" customHeight="true">
            <c r="A1" s="1"/>
            <c r="B1" t="inlineStr" s="1">
                <is>
                    <r>
                        <rPr>
                            <b/>
                            <sz val="12"/>
                            <rFont val="Roboto"/>
                            <charset val="134"/>
                        </rPr>
                        <t>Worker Time Card</t>
                    </r>
                    <r>
                        <rPr>
                            <sz val="12"/>
                            <rFont val="Roboto"/>
                            <charset val="134"/>
                        </rPr>
                        <t xml:space="preserve"> Summary</t>
                    </r>
                    <r>
                        <rPr>
                            <sz val="8"/>
                            <color rgb="FF808080"/>
                            <rFont val="Roboto light"/>
                            <charset val="134"/>
                        </rPr>
                        <t xml:space="preserve">&#10;Downloaded</t>
                    </r>
                    <r>
                        <rPr>
                            <sz val="8"/>
                            <color rgb="FF808080"/>
                            <rFont val="Roboto light"/>
                            <charset val="134"/>
                        </rPr>
                        <t xml:space="preserve"> 11/12/20</t>
                    </r>
                </is>
            </c>
            <c r="C1" s="1"/>
            <c r="D1" s="1"/>
            <c r="E1" t="inlineStr" s="6">
                <is>
                    <t>VIEW DETAILED VIEW</t>
                </is>
            </c>
        </row>
        <row r="2" ht="30.0" customHeight="true">
            <c r="A2" t="inlineStr" s="2">
                <is>
                    <t>WORKER</t>
                </is>
            </c>
            <c r="B2" t="inlineStr" s="3">
                <is>
                    <t>REGULAR TIME</t>
                </is>

            </c>
            <c r="C2" t="inlineStr" s="3">
                <is>
                    <t>OVERTIME</t>
                </is>

            </c>
            <c r="D2" t="inlineStr" s="3">
                <is>
                    <t>DOUBLE TIME</t>
                </is>
            </c>
            <c r="E2" t="inlineStr" s="3">
                <is>
                    <r>
                        <rPr>
                            <b/>
                            <sz val="12"/>
                            <rFont val="Roboto"/>
                            <charset val="134"/>
                        </rPr>
                        <t>TOTAL HOURS</t>
                    </r>
                    <r>
                        <rPr>
                            <sz val="8"/>
                            <rFont val="Roboto light"/>
                            <charset val="134"/>
                        </rPr>
                        <t xml:space="preserve">&#10;11/01/20-11/14/20</t>
                    </r>
                </is>
            </c>
        </row>

        <#list data as row>
            <#assign i = row?index + 3>
            <row r="${i}" ht="45.0" customHeight="true">

                <@c t="s" s="4" r="${i}" c="1">
                    <r>
                        <t>${row.worker!}</t>
                    </r>
                    <r>
                        <rPr>
                            <sz val="7"/>
                            <rFont val="Roboto light"/>
                            <charset val="134"/>
                        </rPr>
                        <t xml:space="preserve">&#10;${row.title!}&#10;EID ${row.eid!}</t>
                    </r>
                </@c>

                <@c t="n" s="5" r="${i}" c="2">
                    ${row.regularTime}
                </@c>

                <@c t="n" s="5" r="${i}" c="3">
                    ${row.overTime}
                </@c>

                <@c t="n" s="5" r="${i}" c="4">
                    ${row.doubleTime}
                </@c>

                <@c t="str" s="5" r="${i}" c="5" f="SUM(B${i}:D${i})">
                    ${row.total}
                </@c>
            </row>
        </#list>

    </sheetData>
    <mergeCells>
        <mergeCell ref="B1:D1"/>
    </mergeCells>
    <hyperlinks>
        <hyperlink ref="E1" r:id="rId2"/>
    </hyperlinks>
    <pageMargins bottom="0.75" footer="0.3" header="0.3" left="0.7" right="0.7" top="0.75"/>
    <drawing r:id="rId1"/>
</worksheet>