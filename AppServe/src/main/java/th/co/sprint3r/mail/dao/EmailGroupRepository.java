package th.co.sprint3r.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.co.sprint3r.mail.model.EmailGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmailGroupRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmailGroupRepository() {

    }

    private static final class EmailGroupMapper implements RowMapper<EmailGroup> {

        public EmailGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmailGroup emailGroup = new EmailGroup();
            emailGroup.setEmailGroupId(rs.getLong("email_group_id"));
            emailGroup.setEmailGroupName(rs.getString("email_group_name"));
            emailGroup.setEmailAddr(rs.getString("email_addr"));
            emailGroup.setCreateDate(rs.getDate("create_date"));
            emailGroup.setChangeDate(rs.getDate("change_date"));
            emailGroup.setStatus(rs.getString("status"));
            return emailGroup;
        }
    }

    public List<EmailGroup> listAll() {

        final String selectSql = "select email_group_id, email_group_name, email_addr, create_date, change_date, status from email_group";

        List<EmailGroup> result = jdbcTemplate.query(selectSql, new EmailGroupMapper());

        return result;

    }

    public List<EmailGroup> listEmail(long emailGroupId) {

        final String selectSql = "select email_group_id, email_group_name, email_addr, create_date, change_date, status from email_group where email_group_id = ?";

        List<EmailGroup> result = jdbcTemplate.query(
                selectSql, new Object[]{emailGroupId}, new EmailGroupMapper());

        return result;

    }
}

