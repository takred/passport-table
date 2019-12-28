package takred.passporttable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Passport {
    @Id
    private Long numberPass;
    private UUID groupId;
    private Integer dateIssue;

    public Long getNumberPass() {
        return numberPass;
    }

    public void setNumberPass(Long numberPass) {
        this.numberPass = numberPass;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public Integer getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Integer dateIssue) {
        this.dateIssue = dateIssue;
    }
}
