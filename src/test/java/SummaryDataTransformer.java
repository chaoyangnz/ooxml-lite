import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ooxml.Workbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummaryDataTransformer {
    @RequiredArgsConstructor
    @Data
    public static class WorkerKey {
        public final String worker;
        public final String classification;
        public final String eid;
    }

    @AllArgsConstructor
    public static class WorkTime {
        public Double regularTime;
        public Double overTime;
        public Double doubleTime;
    }

    List<WorkCardSummaryRow> transform(Workbook workbook, List<Benchmark.WorkerTimeCardSummaryDto> data) {
        Map<WorkerKey, WorkTime> map = new HashMap<>();
        data.stream().forEach(summaryDto -> {
            WorkerKey workerKey = new WorkerKey(summaryDto.worker, "", summaryDto.eid);
            WorkTime workTime;
            if(map.containsKey(workerKey)) {
                workTime = map.get(workerKey);
            } else {
                workTime = new WorkTime(0.0, 0.0, 0.0);
                map.put(workerKey, workTime);
            }
            workTime.regularTime += summaryDto.regularTime;
            workTime.overTime += summaryDto.overTime;
            workTime.doubleTime += summaryDto.doubleTime;
        });

        return map.entrySet().stream().map(entry -> {
            WorkerKey workerKey = entry.getKey();
            WorkTime workTime = entry.getValue();
            WorkCardSummaryRow summaryRow = new WorkCardSummaryRow(
                    workerKey.worker, workerKey.classification, workerKey.eid,
                    workTime.regularTime, workTime.overTime, workTime.doubleTime);
            return summaryRow;
        }).collect(Collectors.toList());
    }
}
