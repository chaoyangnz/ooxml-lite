# ooxml-lite

Generate Spreadsheet (Microsoft Excel or any OOXML compatible Spreadsheet) with templating.

Without the need to build from the scatch, the processing is in milliseconds 🚀.

Excel is related to OOXML, so we build with it.


## Get started

### Install

Gradle

```gradle
compile 'ooxml:ooxml-lite:0.0.1'
```

### Templating your worksheets

```xml
<cols>
    <col min="1" max="1" width="32.2265625" customWidth="true"/>
    <col min="2" max="2" width="32.2265625" customWidth="true"/>
    <col min="3" max="3" width="32.2265625" customWidth="true"/>
    <col min="4" max="4" width="32.2265625" customWidth="true"/>
    <col min="5" max="5" width="20.0" customWidth="true"/>
</cols>
<sheetData>
    <#list data as row>
    <#assign i = row?index>
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
```

see more examples in [src/test/resources/](src/test/resources/).

### Start rendering

```java
Workbook workbook = new Workbook();
Worksheet worksheet1 = workbook.createSheet("sheet1.xml.ftl", "Summary");
worksheet1.setData(data1);

Worksheet worksheet2 = workbook.createSheet("sheet2.xml.ftl", "Detailed");
worksheet2.setData(data2);

File excel = workbook.render();
```

Open your Excel in temp directory. 

## Extensions of SpreadML syntax

### render column

We defined `@c` directive which has the similar attributes of OOXML `<c>..</c>` cell tag.

```xml
<@c t="str" s="5" r="${i}" c="5" f="SUM(B1:D1)">
    10
</@c>
```
which is useful when you want to write the same way of inline string but automatically make them to shared strings

### write styles

Styles are defined within sheet templates by a custom directive `<@style> ... </@style>`.
You can use the similar CSS style to define a named style then apply them to cells.

```xml
<@style>
header {
    font-size: 14;
    font-name: Robot;
    border-left-color: red;
    number-format-cod: '_ * #,##0_ ;_ * \-#,##0_ ;_ * &quot;-&quot;_ ;_ @_ ';
}
</@style>
```

### merge cells

```xml
<@c colspan=2></@c>
```

```xml
<@c rowspan=4></@c>
```

### Hyperlink

// TODO

### Drawings and Images

// TODO
