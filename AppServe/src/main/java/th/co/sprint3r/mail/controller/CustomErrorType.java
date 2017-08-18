package th.co.sprint3r.mail.controller;

import th.co.sprint3r.mail.model.CampaignMaster;

public class CustomErrorType {

    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    static CustomErrorType campaignNotFoundAll() {
        return new CustomErrorType("Error campaignmaster is not found");
    }

    static CustomErrorType campaignNotFound(long campaignId) {
        return new CustomErrorType("Error campaignmaster campaignId \"" + campaignId + "\" is not found");
    }

    static CustomErrorType campaignInsertDuplicate(CampaignMaster campaignMaster) {
        return new CustomErrorType("Error insert campaignmaster campaignName \"" + campaignMaster.getCampaignName() + "\" is duplicated");
    }

    static CustomErrorType campaignUpdateDuplicate(CampaignMaster campaignMaster) {
        return new CustomErrorType("Error update campaignmaster campaignName \"" + campaignMaster.getCampaignName() + "\" is duplicated");
    }

    static CustomErrorType campaignUpdateNotFound(CampaignMaster campaignMaster) {
        return new CustomErrorType("Error update campaignmaster campaignId \"" + campaignMaster.getCampaignId() + "\" is not found");
    }

    static CustomErrorType emailGroupNotFoundAll() {
        return new CustomErrorType("Error emailgroup is not found");
    }

    static CustomErrorType emailGroupNotFound(long emailGroupId) {
        return new CustomErrorType("Error emailgroup emailGroupId \"" + emailGroupId + "\" is not found");
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
