<?xml version="1.0" encoding="UTF-8"?>
<worksheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main"
           xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships">
    <dimension ref="A1"/>
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
            <c r="B1" t="s" s="1">
                <v>2</v>
            </c>
            <c r="C1" s="1"/>
            <c r="D1" s="1"/>
            <c r="E1" t="s" s="6">
                <v>3</v>
            </c>
        </row>
        <row r="2" ht="30.0" customHeight="true">
            <c r="A2" t="s" s="2">
                <v>4</v>
            </c>
            <c r="B2" t="s" s="3">
                <v>5</v>
            </c>
            <c r="C2" t="s" s="3">
                <v>6</v>
            </c>
            <c r="D2" t="s" s="3">
                <v>7</v>
            </c>
            <c r="E2" t="s" s="3">
                <v>8</v>
            </c>
        </row>

        <#list data as row>
            <#assign i = row?index + 3>
            <row r="${i}" ht="45.0" customHeight="true">
                <c r="A${i}" t="inlineStr" s="4">
                    <is>
                        <r>
                            <t>${row.worker}</t>
                        </r>
                        <r>
                            <rPr>
                                <sz val="7"/>
                                <rFont val="Roboto light"/>
                                <charset val="134"/>
                            </rPr>
                            <t xml:space="preserve">&#10;${row.classification}&#10;EID ${row.eid}</t>
                        </r>
                    </is>
                </c>
<#--                <c r="A${i}" t="s" s="4">-->
<#--                    <v>${row.workerCell}</v>-->
<#--                </c>-->
                <c r="B${i}" s="5" t="n">
                    <v>${row.regularTime}</v>
                </c>
                <c r="C${i}" s="5" t="n">
                    <v>${row.overTime}</v>
                </c>
                <c r="D${i}" s="5" t="n">
                    <v>${row.doubleTime}</v>
                </c>
                <c r="E${i}" s="7" t="str">
                    <f>SUM(B${i}:D${i})</f>
                    <v>${row.total}</v>
                </c>
            </row>
        </#list>

        <#--        <row r="3" ht="45.0" customHeight="true">-->
        <#--            <c r="A3" t="s" s="9">-->
        <#--                <v>3</v>-->
        <#--            </c>-->
        <#--            <c r="B3" s="4" t="n">-->
        <#--                <v>1.0</v>-->
        <#--            </c>-->
        <#--            <c r="C3" s="4" t="n">-->
        <#--                <v>2.0</v>-->
        <#--            </c>-->
        <#--            <c r="D3" s="4" t="n">-->
        <#--                <v>3.0</v>-->
        <#--            </c>-->
        <#--            <c r="E3" s="2">-->
        <#--                <f>SUM(B3:D3)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="4" ht="45.0" customHeight="true">-->
        <#--            <c r="A4" t="s" s="9">-->
        <#--                <v>4</v>-->
        <#--            </c>-->
        <#--            <c r="B4" s="4" t="n">-->
        <#--                <v>1.0</v>-->
        <#--            </c>-->
        <#--            <c r="C4" s="4" t="n">-->
        <#--                <v>2.0</v>-->
        <#--            </c>-->
        <#--            <c r="D4" s="4" t="n">-->
        <#--                <v>3.0</v>-->
        <#--            </c>-->
        <#--            <c r="E4" s="2">-->
        <#--                <f>SUM(B4:D4)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="5" ht="45.0" customHeight="true">-->
        <#--            <c r="A5" t="s" s="9">-->
        <#--                <v>5</v>-->
        <#--            </c>-->
        <#--            <c r="B5" s="4" t="n">-->
        <#--                <v>1.0</v>-->
        <#--            </c>-->
        <#--            <c r="C5" s="4" t="n">-->
        <#--                <v>2.0</v>-->
        <#--            </c>-->
        <#--            <c r="D5" s="4" t="n">-->
        <#--                <v>3.0</v>-->
        <#--            </c>-->
        <#--            <c r="E5" s="2">-->
        <#--                <f>SUM(B5:D5)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="6" ht="45.0" customHeight="true">-->
        <#--            <c r="A6" t="s" s="9">-->
        <#--                <v>6</v>-->
        <#--            </c>-->
        <#--            <c r="B6" s="4" t="n">-->
        <#--                <v>1.0</v>-->
        <#--            </c>-->
        <#--            <c r="C6" s="4" t="n">-->
        <#--                <v>2.0</v>-->
        <#--            </c>-->
        <#--            <c r="D6" s="4" t="n">-->
        <#--                <v>3.0</v>-->
        <#--            </c>-->
        <#--            <c r="E6" s="2">-->
        <#--                <f>SUM(B6:D6)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="7" ht="45.0" customHeight="true">-->
        <#--            <c r="A7" t="s" s="9">-->
        <#--                <v>7</v>-->
        <#--            </c>-->
        <#--            <c r="B7" s="4" t="n">-->
        <#--                <v>5.0</v>-->
        <#--            </c>-->
        <#--            <c r="C7" s="4" t="n">-->
        <#--                <v>10.0</v>-->
        <#--            </c>-->
        <#--            <c r="D7" s="4" t="n">-->
        <#--                <v>15.0</v>-->
        <#--            </c>-->
        <#--            <c r="E7" s="2">-->
        <#--                <f>SUM(B7:D7)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="8" ht="45.0" customHeight="true">-->
        <#--            <c r="A8" t="s" s="9">-->
        <#--                <v>8</v>-->
        <#--            </c>-->
        <#--            <c r="B8" s="4" t="n">-->
        <#--                <v>5.0</v>-->
        <#--            </c>-->
        <#--            <c r="C8" s="4" t="n">-->
        <#--                <v>10.0</v>-->
        <#--            </c>-->
        <#--            <c r="D8" s="4" t="n">-->
        <#--                <v>15.0</v>-->
        <#--            </c>-->
        <#--            <c r="E8" s="2">-->
        <#--                <f>SUM(B8:D8)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="9" ht="45.0" customHeight="true">-->
        <#--            <c r="A9" t="s" s="9">-->
        <#--                <v>9</v>-->
        <#--            </c>-->
        <#--            <c r="B9" s="4" t="n">-->
        <#--                <v>1.0</v>-->
        <#--            </c>-->
        <#--            <c r="C9" s="4" t="n">-->
        <#--                <v>2.0</v>-->
        <#--            </c>-->
        <#--            <c r="D9" s="4" t="n">-->
        <#--                <v>3.0</v>-->
        <#--            </c>-->
        <#--            <c r="E9" s="2">-->
        <#--                <f>SUM(B9:D9)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="10" ht="45.0" customHeight="true">-->
        <#--            <c r="A10" t="s" s="9">-->
        <#--                <v>10</v>-->
        <#--            </c>-->
        <#--            <c r="B10" s="4" t="n">-->
        <#--                <v>1.0</v>-->
        <#--            </c>-->
        <#--            <c r="C10" s="4" t="n">-->
        <#--                <v>2.0</v>-->
        <#--            </c>-->
        <#--            <c r="D10" s="4" t="n">-->
        <#--                <v>3.0</v>-->
        <#--            </c>-->
        <#--            <c r="E10" s="2">-->
        <#--                <f>SUM(B10:D10)</f>-->
        <#--            </c>-->
        <#--        </row>-->
        <#--        <row r="11" ht="45.0" customHeight="true">-->
        <#--            <c r="A11" t="s" s="9">-->
        <#--                <v>11</v>-->
        <#--            </c>-->
        <#--            <c r="B11" s="4" t="n">-->
        <#--                <v>1.0</v>-->
        <#--            </c>-->
        <#--            <c r="C11" s="4" t="n">-->
        <#--                <v>2.0</v>-->
        <#--            </c>-->
        <#--            <c r="D11" s="4" t="n">-->
        <#--                <v>3.0</v>-->
        <#--            </c>-->
        <#--            <c r="E11" s="2">-->
        <#--                <f>SUM(B11:D11)</f>-->
        <#--            </c>-->
        <#--        </row>-->
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