package th.co.sprint3r.mail.model;

import java.util.Date;

public class EmailGroup {

    private long emailGroupId;
    private String emailGroupName;
    private String emailAddr;
    private Date createDate;
    private Date changeDate;
    private String status;

    public EmailGroup() {
    }

    public EmailGroup(long emailGroupId, String emailGroupName, String emailAddr, Date createDate, Date changeDate, String status) {
        this.emailGroupId = emailGroupId;
        this.emailGroupName = emailGroupName;
        this.emailAddr = emailAddr;
        this.createDate = createDate;
        this.changeDate = changeDate;
        this.status = status;
    }

    public long getEmailGroupId() {
        return emailGroupId;
    }

    public void setEmailGroupId(long emailGroupId) {
        this.emailGroupId = emailGroupId;
    }

    public String getEmailGroupName() {
        return emailGroupName;
    }

    public void setEmailGroupName(String emailGroupName) {
        this.emailGroupName = emailGroupName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
