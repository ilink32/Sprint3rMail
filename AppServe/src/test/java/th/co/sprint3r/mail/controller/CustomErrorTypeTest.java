package th.co.sprint3r.mail.controller;

import org.junit.Before;
import org.junit.Test;
import th.co.sprint3r.mail.model.CampaignMaster;
import th.co.sprint3r.mail.model.EmailGroup;

import static org.junit.Assert.*;

public class CustomErrorTypeTest {
    private CampaignMaster customCampaign;
    private EmailGroup customEmail;

    @Before
    public void setUpdateCustomCampaign() throws Exception {
        customCampaign = new CampaignMaster();
        customCampaign.setCampaignId(1);
        customCampaign.setCampaignName("TEST_CAMPAIGN");

        customEmail = new EmailGroup();
        customEmail.setEmailGroupId(1);
    }

    @Test
    public void campaignNotFoundAllMsg() throws Exception {
        assertEquals("Error campaignmaster is not found", CustomErrorType.campaignNotFoundAll().getErrorMessage());
    }

    @Test
    public void campaignNotFoundMsg() throws Exception{
        assertEquals("Error campaignmaster campaignId \"1\" is not found", CustomErrorType.campaignNotFound(1).getErrorMessage());
    }

    @Test
    public void campaignInsertDuplicateMsg() throws Exception{
        assertEquals("Error insert campaignmaster campaignName \"TEST_CAMPAIGN\" is duplicated", CustomErrorType.campaignInsertDuplicate(this.customCampaign).getErrorMessage());
    }

    @Test
    public void campaignUpdateDuplicateMsg() throws Exception{
        assertEquals("Error update campaignmaster campaignName \"TEST_CAMPAIGN\" is duplicated", CustomErrorType.campaignUpdateDuplicate(this.customCampaign).getErrorMessage());
    }

    @Test
    public void campaignUpdateNotFoundMsg() throws Exception{
        assertEquals("Error update campaignmaster campaignId \"1\" is not found", CustomErrorType.campaignUpdateNotFound(this.customCampaign).getErrorMessage());
    }

    @Test
    public void emailNotFoundAllMsg() throws Exception {
        assertEquals("Error emailgroup is not found", CustomErrorType.emailGroupNotFoundAll().getErrorMessage());
    }

    @Test
    public void emailNotFoundMsg() throws Exception {
        assertEquals("Error emailgroup emailGroupId \"1\" is not found", CustomErrorType.emailGroupNotFound(customEmail.getEmailGroupId()).getErrorMessage());
    }
}