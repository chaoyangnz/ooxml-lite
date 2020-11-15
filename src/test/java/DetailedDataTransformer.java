import ooxml.Workbook;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DetailedDataTransformer {

    public List<WorkCardDetailedRow> transform(Workbook workbook, List<Benchmark.WorkerTimeCardSummaryDto> data) {
        return data.stream().flatMap(
                summaryDto -> {
                    String[] names = summaryDto.getWorker().split("\\s+");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");

                    if(summaryDto.costCodes.size() > 0) {
                        return summaryDto.costCodes.stream().map(costCodeDto ->
                                new WorkCardDetailedRow()
                                        .setLastName(names.length > 0 ? names[1]: "")
                                        .setFirstName(names[0])
                                        .setTitle(summaryDto.title)
                                        .setEid(summaryDto.eid)
                                        .setDate(dateFormat.format(summaryDto.getDate())) //
                                        .setDay(dayFormat.format(summaryDto.getDate())) //
                                        .setRegularTime(costCodeDto.regularTime)
                                        .setOverTime(costCodeDto.overTime)
                                        .setDoubleTime(costCodeDto.doubleTime)
                                        .setCostCode(costCodeDto.getCode())
                                        .setCostCodeDescription(costCodeDto.getDescription())
                                        .setProjectName(summaryDto.projectName)
                                        .setProjectNo(summaryDto.projectNo)
                                        .setStart(str(summaryDto.startTime))
                                        .setEnd(str(summaryDto.endTime))
                                        .setHasLunch(summaryDto.hasLunch != null && summaryDto.hasLunch ? "Yes": "No")
                                        .setLunchStart(str(summaryDto.lunchStartTime))
                                        .setLunchEnd(str(summaryDto.lunchEndTime))
                                        .setHasBreak(summaryDto.hasBreak != null && summaryDto.hasBreak ? "Yes": "No")
                                        .setBreakStart(str(summaryDto.breakStartTime))
                                        .setBreakEnd(str(summaryDto.breakEndTime))
                                        .setNotes(summaryDto.notes.stream().collect(Collectors.joining(",")))
                                        .setAttachments(summaryDto.attachmentUrls.stream().collect(Collectors.joining(",")))
                        );
                    }
                    return Stream.of(new WorkCardDetailedRow()
                            .setLastName(names.length > 0 ? names[1]: "")
                            .setFirstName(names[0])
                            .setTitle(summaryDto.title)
                            .setEid(summaryDto.eid)
                            .setDate(dateFormat.format(summaryDto.getDate())) //
                            .setDay(dayFormat.format(summaryDto.getDate())) //
                            .setRegularTime(summaryDto.regularTime)
                            .setOverTime(summaryDto.overTime)
                            .setDoubleTime(summaryDto.doubleTime)
                            .setProjectName(summaryDto.projectName)
                            .setProjectNo(summaryDto.projectNo)
                            .setStart(str(summaryDto.startTime))
                            .setEnd(str(summaryDto.endTime))
                            .setHasLunch(summaryDto.hasLunch != null && summaryDto.hasLunch ? "Yes": "No")
                            .setLunchStart(str(summaryDto.lunchStartTime))
                            .setLunchEnd(str(summaryDto.lunchEndTime))
                            .setHasBreak(summaryDto.hasBreak != null && summaryDto.hasBreak ? "Yes": "No")
                            .setBreakStart(str(summaryDto.breakStartTime))
                            .setBreakEnd(str(summaryDto.breakEndTime))
                            .setNotes(summaryDto.notes.stream().collect(Collectors.joining(",")))
                            .setAttachments(summaryDto.attachmentUrls.stream().collect(Collectors.joining(",")))
                    );
                }
        ).filter(
                detailed -> detailed.getRegularTime() != 0 || detailed.getOverTime() != 0 || detailed.getDoubleTime() != 0
        ).collect(Collectors.toList());
    }

    private static <T> String str(T obj) {
        return obj != null ? String.valueOf(obj) : "";
    }


}
