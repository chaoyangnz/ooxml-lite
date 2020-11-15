package ooxml;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Getter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.lang.String.format;

public class Workbook {
    private Configuration freemarker;

    private static final String BLUEPRINT = "blueprint";
    private static final File BLUEPRINT_DIR = new File(Workbook.class.getClassLoader().getResource(BLUEPRINT).getFile());

    public Workbook() {
        freemarker = new Configuration(Configuration.VERSION_2_3_20);
        freemarker.setClassLoaderForTemplateLoading(Workbook.class.getClassLoader(), "");
    }

    private List<Sheet> sheets = new ArrayList<>();
    @Getter
    private List<String> sharedStrings = new ArrayList<>();
    private Map<String, Integer> sharedStringIndexes = new HashMap<>();

    public Sheet createSheet(String template, String name) {
        Sheet sheet = new Sheet(template, this, name);
        sheets.add(sheet);
        return sheet;
    }

    public int createSharedString(String str) {
        if (sharedStringIndexes.containsKey(str)) {
            return sharedStringIndexes.get(str);
        }
        sharedStrings.add(str);
        int index = sharedStrings.size() - 1;
        sharedStringIndexes.put(str, index);
        return index;
    }

    private static boolean shouldExclude(File file) {
        return file.getName().endsWith(".ftl")
                || file.getName().equals(".DS_Store")
                || file.getName().matches("sheet\\d+\\.xml");
    }

    private static boolean shouldInclude(File file) {
        return !shouldExclude(file);
    }

    public File render() throws IOException, TemplateException {
        long start = System.nanoTime();

        Path tmp = Files.createTempDirectory(UUID.randomUUID().toString());
        FileUtils.copyDirectory(BLUEPRINT_DIR, tmp.toFile(), Workbook::shouldInclude);
        System.err.println("Temp files: " + tmp);

        sheets.forEach(sheet -> {
            Template template;
            try {
                template = freemarker.getTemplate(sheet.getTemplate());
                Map<String, List> context = new HashMap<>();
                context.put("data", sheet.getData());
                template.process(context, new FileWriter(tmp.toString() + "/xl/worksheets/sheet1.xml"));
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
            }
        });

        // shared strings
        Template templateSharedStrings = freemarker.getTemplate(BLUEPRINT + "/xl/sharedStrings.xml.ftl");
        Map<String, List<String>> contextSharedStrings = new HashMap<>();
        contextSharedStrings.put("sharedStrings", getSharedStrings());
        templateSharedStrings.process(contextSharedStrings, new FileWriter(tmp.toString() + "/xl/sharedStrings.xml"));

        // zip
        File excelFile = Files.createTempFile(UUID.randomUUID().toString(), ".xlsx").toFile();
        zipFile(tmp.toString(), excelFile.toString(), true);

        long end = System.nanoTime();
        System.err.println(format("Rendered Excel File in %dms: %s", (end - start) / 1_000_000, excelFile));

        return excelFile;
    }

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    private static void zipFile(String fileToZip, String zipFile, boolean excludeContainingFolder)
            throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        File srcFile = new File(fileToZip);
        if (excludeContainingFolder && srcFile.isDirectory()) {
            for (String fileName : srcFile.list()) {
                addToZip("", fileToZip + "/" + fileName, zipOut);
            }
        } else {
            addToZip("", fileToZip, zipOut);
        }

        zipOut.flush();
        zipOut.close();

        System.out.println("Successfully created " + zipFile);
    }

    private static void addToZip(String path, String srcFile, ZipOutputStream zipOut) throws IOException {
        File file = new File(srcFile);
        String filePath = "".equals(path) ? file.getName() : path + "/" + file.getName();
        System.out.println("zip entry = " + filePath);
        if (file.isDirectory()) {
            for (String fileName : file.list()) {
                addToZip(filePath, srcFile + "/" + fileName, zipOut);
            }
        } else {
            zipOut.putNextEntry(new ZipEntry(filePath));
            FileInputStream in = new FileInputStream(srcFile);

            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int len;
            while ((len = in.read(buffer)) != -1) {
                zipOut.write(buffer, 0, len);
            }
        }
    }

}
