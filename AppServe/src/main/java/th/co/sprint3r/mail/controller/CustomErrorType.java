package th.co.sprint3r.mail.controller;

public class CustomErrorType {

    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void notFoundProfile(long campaignId) {
        if (campaignId > 0) {
            this.errorMessage = "campaignId \"" + campaignId + "\" not found";
        }

        this.errorMessage = "campaignmaster profile not found";
    }
}
