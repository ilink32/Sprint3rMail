package th.co.sprint3r.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.co.sprint3r.mail.model.CampaignMaster;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CampaignMasterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CampaignMasterRepository() {

    }

    private static final class CampaignMasterMapper implements RowMapper<CampaignMaster> {

        public CampaignMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
            CampaignMaster campaign = new CampaignMaster();
            campaign.setCampaignId(rs.getInt("campaign_id"));
            campaign.setCampaignName(rs.getString("campaign_name"));
            campaign.setEmailGroup(rs.getInt("email_group"));
            campaign.setEmailSubject(rs.getString("email_subject"));
            campaign.setFromName(rs.getString("from_name"));
            campaign.setFromEmail(rs.getString("from_email"));
            campaign.setCreateDate(rs.getDate("create_date"));
            campaign.setChangeDate(rs.getDate("change_date"));
            return campaign;
        }
    }

    public List<CampaignMaster> listAll() {

        final String selectSql = "select campaign_id, campaign_name, email_group, email_subject, from_name, from_email, create_date, change_date from campaign_master";

        List<CampaignMaster> result = jdbcTemplate.query(selectSql, new CampaignMasterMapper());

        return result;

    }

    public List<CampaignMaster> listCampaign(long campaignId) {

        final String selectSql = "select campaign_id, campaign_name, email_group, email_subject, from_name, from_email, create_date, change_date from campaign_master where campaign_id = ?";

        List<CampaignMaster> result = jdbcTemplate.query(
                selectSql, new Object[]{campaignId}, new CampaignMasterMapper());

        return result;

    }

    public long insert(CampaignMaster campaignMaster) {
        final String selectSql = "select add_campaign(?, ?, ?, ?, ?) as campaign_id";

        long result = jdbcTemplate.queryForObject(
                selectSql, getInsertObjects(campaignMaster), Long.class);

        return result;
    }

    public long update(CampaignMaster campaignMaster) {
        final String selectSql = "select update_campaign(?, ?, ?, ?, ?, ?) as campaign_id";

        long result = jdbcTemplate.queryForObject(
                selectSql, getUpdateObjects(campaignMaster), Long.class);

        return result;
    }

    public boolean exists(CampaignMaster campaignMaster) {
        final String selectSql = "select check_dup_campaign(?, ?) as check_dup";

        boolean result = jdbcTemplate.queryForObject(
                selectSql, getExistsObjects(campaignMaster), Boolean.class);

        return result;
    }

    private Object[] getExistsObjects(CampaignMaster campaignMaster) {
        return new Object[]{campaignMaster.getCampaignName(), campaignMaster.getCampaignId()};
    }

    private Object[] getInsertObjects(CampaignMaster campaignMaster) {
        return new Object[]{campaignMaster.getCampaignName(), campaignMaster.getEmailGroup(), campaignMaster.getEmailSubject(), campaignMaster.getFromName(), campaignMaster.getFromEmail()};
    }

    private Object[] getUpdateObjects(CampaignMaster campaignMaster) {
        return new Object[]{campaignMaster.getCampaignId(), campaignMaster.getCampaignName(), campaignMaster.getEmailGroup(), campaignMaster.getEmailSubject(), campaignMaster.getFromName(), campaignMaster.getFromEmail()};
    }
}

