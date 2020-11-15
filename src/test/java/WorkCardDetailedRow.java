import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class WorkCardDetailedRow {
    // 	LUNCH	LUNCH START	LUNCH END	BREAK	BREAK START	BREAK END	PAYROLL NOTES	PAYROLL ATTACHMENT(S)
    private String lastName;
    private String firstName;
    private String title;
    public String eid;
    public String day;
    private String date;
    private String projectName;
    private String projectNo;
    private String costCode;
    private String costCodeDescription;
    public Double regularTime;
    public Double overTime;
    public Double doubleTime;
    private String start;
    private String end;
    private String hasLunch;
    private String lunchStart;
    private String lunchEnd;
    private String hasBreak;
    private String breakStart;
    private String breakEnd;
    private String notes;
    private String attachments;
}
