import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WorkCardSummaryRow {
    public final String worker;
    public final String title;
    public final String eid;
    public final Double regularTime;
    public final Double overTime;
    public final Double doubleTime;

    public Double getTotal() {
        return regularTime + overTime + doubleTime;
    }
}