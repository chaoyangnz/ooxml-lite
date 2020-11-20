package ooxml;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;
import static ooxml.Cell.FORMULA;
import static ooxml.Cell.NUMBER;
import static ooxml.Cell.SHARED_STRING;
import static ooxml.Cell.STRING;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Worksheet<T> {
    private final String template;
    private final Workbook workbook;
    private final String name;
    @Setter
    private List<T> data = new ArrayList<>();

    private List<String> mergeCells = new ArrayList<>();

    void createColSpan(int row, int col, int colSpan) {
        createColSpan(row, String.valueOf(CHARS.charAt(col-1)), colSpan);
    }

    void createColSpan(int row, String col, int colSpan) {
        mergeCells.add(format("%s%d:%s%d", col, row, nextCol(col, colSpan - 1), row));
    }

    void createRowSpan(int row, int col, int rowSpan) {
        createRowSpan(row, String.valueOf(CHARS.charAt(col-1)), rowSpan);
    }

    void createRowSpan(int row, String col, int rowSpan) {
        mergeCells.add(format("%s%d:%s%d", col, row, col, row + rowSpan - 1));
    }

    private final static String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final static String nextCol(String col, int delta) {
        for(int i = 0; i < delta; ++i) {
            col = nextCol(col);
        }
        return col;
    }

    private final static String nextCol(String col) {
        String reverse = new StringBuilder(col).reverse().toString();
        char[] chars = reverse.toCharArray();
        int remaining = 1;
        for(int i = 0; i < chars.length;  ++i) {
            char ch = chars[i];
            int index = CHARS.indexOf(ch);
            if(remaining == 1) {
                if(ch != 'Z') {
                    chars[i] = CHARS.charAt(index + 1);
                    return new StringBuilder(String.valueOf(chars)).reverse().toString();
                }
                chars[i] = 'A';
                remaining = 1;
            }
        }
        return "A" + new StringBuilder(String.valueOf(chars)).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(nextCol("B"));
        System.out.println(nextCol("Z"));
        System.out.println(nextCol("AB"));
        System.out.println(nextCol("AZ"));
        System.out.println(nextCol("BB"));
        System.out.println(nextCol("BZ"));
        System.out.println(nextCol("ABD"));
        System.out.println(nextCol("ABZ"));
    }
}
