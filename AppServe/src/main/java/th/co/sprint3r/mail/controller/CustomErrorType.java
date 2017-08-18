package th.co.sprint3r.mail.controller;

import th.co.sprint3r.mail.model.CampaignMaster;

public class CustomErrorType {

    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String campaignNotFound() {
        this.errorMessage = "campaignmaster is not found";
        return this.errorMessage;
    }

    public String campaignNotFound(long campaignId) {
        this.errorMessage = "campaignmaster campaignId \"" + campaignId + "\" is not found";
        return this.errorMessage;
    }

    public String campaignInsertDuplicate(CampaignMaster campaignMaster) {
        this.errorMessage = "Error insert campaignmaster campaignName \"" + campaignMaster.getCampaignName() + "\" is duplicated";
        return this.errorMessage;
    }

    public String campaignUpdateNotFound(CampaignMaster campaignMaster) {
        this.errorMessage = "Error update campaignmaster campaignId \"" + campaignMaster.getCampaignId() + "\" is not found";
        return this.errorMessage;
    }
}
