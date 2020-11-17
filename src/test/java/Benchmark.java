import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.Data;
import ooxml.Worksheet;
import ooxml.Workbook;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Benchmark {
    public static void main(String[] args) throws IOException, TemplateException {
        List<WorkerTimeCardSummaryDto> data = getTimeCardData("timecards-data.json");

        Workbook workbook = new Workbook();
        Worksheet worksheet1 = workbook.createSheet("sheet1.xml.ftl", "Summary");
        worksheet1.setData(new SummaryDataTransformer().transform(workbook, data));

        Worksheet worksheet2 = workbook.createSheet("sheet2.xml.ftl", "Detailed");
        worksheet2.setData(new DetailedDataTransformer().transform(workbook, data));

        workbook.render();
    }


    private static List<WorkerTimeCardSummaryDto> getTimeCardData(String fileName) {
        final InputStream jsonStream = Benchmark.class.getResourceAsStream(fileName);
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(jsonStream, new TypeReference<List<WorkerTimeCardSummaryDto>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Data
    static class WorkerTimeCardSummaryDto {

        public String worker;
        public String eid;
        public String title;
        public Date date;
        public String projectUuid;
        public String projectName;
        public String projectNo;
        public List<CostCodeDetailedDto> costCodes;
        public Double regularTime;
        public Double overTime;
        public Double doubleTime;
        public LocalTime startTime;
        public LocalTime endTime;
        public Boolean hasLunch;
        public Boolean hasBreak;
        public LocalTime lunchStartTime;
        public LocalTime lunchEndTime;
        public LocalTime breakStartTime;
        public LocalTime breakEndTime;
        public List<String> notes;
        public List<String> attachmentUrls = new ArrayList<>();
    }

    @Data
    public static class CostCodeDetailedDto {
        public String division;
        public String code;
        public CostCodeKey key;
        public String description;
        public Double regularTime;
        public Double overTime;
        public Double doubleTime;
        public String notes;
        public List<String> notesList;
        public String classification;
    }

    public static class CostCodeKey {

        private String division;
        private String code;
        private String description;

        private CostCodeKey(){

        }

        public String getDescription() {
            return description;
        }

        public String getDivision() {
            return division;
        }

        public String getCode() {
            return code;
        }

        private static boolean isBlank(String str) {
            return str == null || str.length() == 0;
        }

        public static CostCodeKey of(String division, String code, String description) {
            if (isBlank(division) ||
                    isBlank(code)
            ) {
                throw new RuntimeException("division or code can not be null");
            }
            final CostCodeKey instance = new CostCodeKey();
            instance.division = division;
            instance.code = code;
            instance.description = description == null? "": description;
            return instance;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CostCodeKey)) {
                return false;
            }
            return ((CostCodeKey) obj).code.equalsIgnoreCase(this.code) &&
                    ((CostCodeKey) obj).description.equalsIgnoreCase(this.description) &&
                    ((CostCodeKey) obj).division.equalsIgnoreCase(this.division);
        }

        @Override
        public int hashCode() {
            return Objects.hash(division, code, description);
        }

        @Override
        public String toString() {
            return key();
        }

        public String key() {
            return String.format("%s-%s-%s", division, code, description);
        }

    }

}
