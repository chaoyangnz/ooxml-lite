<?xml version="1.0" encoding="UTF-8"?>
<worksheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main">
    <dimension ref="A1"/>
    <sheetViews>
        <sheetView workbookViewId="0">
            <pane xSplit="1.0" ySplit="1.0" state="frozen" topLeftCell="B2" activePane="bottomRight"/>
            <selection pane="bottomRight"/>
        </sheetView>
    </sheetViews>
    <sheetFormatPr defaultRowHeight="15.0"/>
    <cols>
        <col min="1" max="1" width="20.0" customWidth="true"/>
        <col min="2" max="2" width="20.0" customWidth="true"/>
        <col min="3" max="3" width="15.0" customWidth="true"/>
        <col min="4" max="4" width="15.0" customWidth="true"/>
        <col min="5" max="5" width="15.0" customWidth="true"/>
        <col min="6" max="6" width="15.0" customWidth="true"/>
        <col min="7" max="7" width="60.0" customWidth="true"/>
        <col min="8" max="8" width="20.0" customWidth="true"/>
        <col min="9" max="9" width="15.0" customWidth="true"/>
        <col min="10" max="10" width="21.0" customWidth="true"/>
        <col min="11" max="11" width="8.0" customWidth="true"/>
        <col min="12" max="12" width="8.0" customWidth="true"/>
        <col min="13" max="13" width="8.0" customWidth="true"/>
        <col min="14" max="14" width="15.0" customWidth="true"/>
        <col min="15" max="15" width="15.0" customWidth="true"/>
        <col min="16" max="16" width="8.0" customWidth="true"/>
        <col min="17" max="17" width="15.0" customWidth="true"/>
        <col min="18" max="18" width="15.0" customWidth="true"/>
        <col min="19" max="19" width="8.0" customWidth="true"/>
        <col min="20" max="20" width="15.0" customWidth="true"/>
        <col min="21" max="21" width="15.0" customWidth="true"/>
        <col min="22" max="22" width="20.0" customWidth="true"/>
        <col min="23" max="23" width="21.0" customWidth="true"/>
    </cols>


    <sheetData>
        <row r="1" ht="35.0" customHeight="true">
            <c r="A1" t="inlineStr" s="11">
                <is>
                    <t>LAST NAME</t>
                </is>
            </c>
            <c r="B1" t="inlineStr" s="11">
                <is>
                    <t>FIRST NAME</t>
                </is>
            </c>
            <c r="C1" t="inlineStr" s="11">
                <is>
                    <t>TITLE</t>
                </is>
            </c>
            <c r="D1" t="inlineStr" s="11">
                <is>
                    <t>EID</t>
                </is>
            </c>
            <c r="E1" t="inlineStr" s="11">
                <is>
                    <t>DAY</t>
                </is>
            </c>
            <c r="F1" t="inlineStr" s="11">
                <is>
                    <t>DATE</t>
                </is>
            </c>
            <c r="G1" t="inlineStr" s="11">
                <is>
                    <t>PROJECT NAME</t>
                </is>
            </c>
            <c r="H1" t="inlineStr" s="11">
                <is>
                    <t>JOB #</t>
                </is>
            </c>
            <c r="I1" t="inlineStr" s="11">
                <is>
                    <t>	COST CODE #	</t>
                </is>
            </c>
            <c r="J1" t="inlineStr" s="11">
                <is>
                    <t>COST CODE DESCRIPTION</t>
                </is>
            </c>
            <c r="K1" t="inlineStr" s="11">
                <is>
                    <t>RT</t>
                </is>
            </c>
            <c r="L1" t="inlineStr" s="11">
                <is>
                    <t>OT</t>
                </is>
            </c>
            <c r="M1" t="inlineStr" s="11">
                <is>
                    <t>DT</t>
                </is>
            </c>
            <c r="N1" t="inlineStr" s="11">
                <is>
                    <t>START</t>
                </is>
            </c>
            <c r="O1" t="inlineStr" s="11">
                <is>
                    <t>END</t>
                </is>
            </c>
            <c r="P1" t="inlineStr" s="11">
                <is>
                    <t>LUNCH</t>
                </is>
            </c>
            <c r="Q1" t="inlineStr" s="11">
                <is>
                    <t>LUNCH START</t>
                </is>
            </c>
            <c r="R1" t="inlineStr" s="11">
                <is>
                    <t>LUNCH END</t>
                </is>
            </c>
            <c r="S1" t="inlineStr" s="11">
                <is>
                    <t>BREAK</t>
                </is>
            </c>
            <c r="T1" t="inlineStr" s="11">
                <is>
                    <t>BREAK START</t>
                </is>
            </c>
            <c r="U1" t="inlineStr" s="11">
                <is>
                    <t>BREAK END</t>
                </is>
            </c>
            <c r="V1" t="inlineStr" s="11">
                <is>
                    <t>PAYROLL NOTES</t>
                </is>
            </c>
            <c r="W1" t="inlineStr" s="11">
                <is>
                    <t>PAYROLL ATTACHMENT(S)</t>
                </is>
            </c>
        </row>

        <#list data as row>
        <#assign i = row?index + 2>
        <row r="2" ht="35.0" customHeight="true">
            <c r="A${i}" t="inlineStr" s="12">
                <is><t>${row.lastName}</t></is>
            </c>
            <c r="B${i}" t="inlineStr" s="12">
                <is><t>${row.firstName}</t></is>
            </c>
            <c r="C${i}" t="inlineStr" s="12">
                <is><t>${row.title}</t></is>
            </c>
            <c r="D${i}" t="inlineStr" s="12">
                <is><t>${row.eid}</t></is>
            </c>
            <c r="E${i}" t="inlineStr" s="12">
                <is><t>${row.day}</t></is>
            </c>
            <c r="F${i}" t="inlineStr" s="12">
                <is><t>${row.date}</t></is>
            </c>
            <c r="G${i}" t="inlineStr" s="12">
                <is><t>${row.projectName}</t></is>
            </c>
            <c r="H${i}" t="inlineStr" s="12">
                <is><t>${row.projectNo}</t></is>
            </c>
            <c r="I${i}" t="inlineStr" s="12">
                <is><t>${row.costCode!}</t></is>
            </c>
            <c r="J${i}" t="inlineStr" s="12">
                <is><t>${row.costCodeDescription!}</t></is>
            </c>
            <c r="K${i}" t="inlineStr" s="12">
                <is><t>${row.regularTime}</t></is>
            </c>
            <c r="L${i}" t="inlineStr" s="12">
                <is><t>${row.overTime}</t></is>
            </c>
            <c r="M${i}" t="inlineStr" s="12">
                <is><t>${row.doubleTime}</t></is>
            </c>
            <c r="N${i}" t="inlineStr" s="12">
                <is><t>${row.start!}</t></is>
            </c>
            <c r="O${i}" t="inlineStr" s="12">
                <is><t>${row.end!}</t></is>
            </c>
            <c r="P${i}" t="inlineStr" s="12">
                <is><t>${row.hasLunch!}</t></is>
            </c>
            <c r="Q${i}" t="inlineStr" s="12">
                <is><t>${row.lunchStart!}</t></is>
            </c>
            <c r="R2" t="inlineStr" s="12">
                <is><t>${row.lunchEnd!}</t></is>
            </c>
            <c r="S${i}" t="inlineStr" s="12">
                <is><t>${row.hasBreak!}</t></is>
            </c>
            <c r="T2" t="inlineStr" s="12">
                <is><t>${row.breakStart!}</t></is>
            </c>
            <c r="U${i}" t="inlineStr" s="12">
                <is><t>${row.breakEnd!}</t></is>
            </c>
            <c r="V${i}" t="inlineStr" s="12">
                <is><t>${row.notes!}</t></is>
            </c>
            <c r="W${i}" t="inlineStr" s="12">
                <is><t>${row.attachments!}</t></is>
            </c>
            <c r="X${i}" t="inlineStr" s="12">
                <is><t></t></is>
            </c>
        </row>
        </#list>

    </sheetData>
    <autoFilter ref="A1:X1"/>
    <pageMargins bottom="0.75" footer="0.3" header="0.3" left="0.7" right="0.7" top="0.75"/>
    <ignoredErrors>
        <ignoredError sqref="A1:X2710" numberStoredAsText="true" twoDigitTextYear="true"/>
    </ignoredErrors>
</worksheet>