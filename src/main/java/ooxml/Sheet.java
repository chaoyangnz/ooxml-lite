package ooxml;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

import static ooxml.Cell.FORMULA;
import static ooxml.Cell.NUMBER;
import static ooxml.Cell.SHARED_STRING;
import static ooxml.Cell.STRING;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Sheet<T> {
    private final String template;
    private final Workbook workbook;
    private final String name;
    private List<T> data = new LinkedList<>();

    public Cell newNumber(Number number) {
        return new Cell(NUMBER, String.valueOf(number), null, 0);
    }

    public Cell newString(String str) {
        return new Cell(STRING, str, null, 0);
    }

    public Cell newSharedString(String str) {
        return new Cell(SHARED_STRING, String.valueOf(workbook.createSharedString(str)), null, 0);
    }

    public Cell newFormula(String formula, String result) {
        return new Cell(FORMULA, String.valueOf(result), formula, 0);
    }
}
