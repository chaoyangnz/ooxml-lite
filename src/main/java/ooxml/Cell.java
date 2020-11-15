package ooxml;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Cell {
    public static final String NUMBER = "n";
    public static final String STRING = "inlineStr";
    public static final String SHARED_STRING = "s";
    public static final String FORMULA = "str";
    private static final char[] COLUMNS = " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private String type;
    private String value; // index when shared string
    private String formula; // only for formula
    private int style;

    public String render(int r, int c, String s) {
        String content = "";
        switch (type) {
            case NUMBER:
            case SHARED_STRING:
                content = "<v>" + value + "</v>"; break;
            case STRING: content = "<is>" + value + "</is>"; break;
            case FORMULA: content = "<f>" + formula + "</f><v>" + value + "</v>"; break;
        }
        return "<c r=\"" + COLUMNS[c] + r + "\" t=\"" + type + "\" s=\"" + s + "\">" + content + "</c>";
    }

    public static Cell newNumber(String number) {
        return new Cell(NUMBER, number, null, 0);
    }

    public static Cell newString(String str) {
        return new Cell(STRING, str, null, 0);
    }

    public static Cell newSharedString(int index) {
        return new Cell(SHARED_STRING, String.valueOf(index), null, 0);
    }

    public static Cell newFormula(String formula, String result) {
        return new Cell(FORMULA, String.valueOf(result), formula, 0);
    }

}
