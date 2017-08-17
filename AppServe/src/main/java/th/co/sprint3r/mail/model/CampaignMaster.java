package th.co.sprint3r.mail.model;

import java.util.Date;

public class CampaignMaster {

    private int campaignId;
    private String campaignName;
    private int emailGroup;
    private String emailSubject;
    private String fromName;
    private String fromEmail;
    private Date createDate;
    private Date changeDate;

    public CampaignMaster() {
    }

    public CampaignMaster(int campaignId,
                          String campaignName,
                          int emailGroup,
                          String emailSubject,
                          String fromName,
                          String fromEmail,
                          Date createDate,
                          Date changeDate) {

        this.campaignId = campaignId;
        this.campaignName = campaignName;
        this.emailGroup = emailGroup;
        this.emailSubject = emailSubject;
        this.fromName = fromName;
        this.fromEmail = fromEmail;
        this.createDate = createDate;
        this.changeDate = changeDate;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public int getEmailGroup() {
        return emailGroup;
    }

    public void setEmailGroup(int emailGroup) {
        this.emailGroup = emailGroup;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
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
}
