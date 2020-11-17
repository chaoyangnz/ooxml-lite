package ooxml;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

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
    private List<T> data = new LinkedList<>();


}
