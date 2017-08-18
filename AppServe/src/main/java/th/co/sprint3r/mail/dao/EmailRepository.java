package th.co.sprint3r.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import th.co.sprint3r.mail.model.Email;

@Repository
public class EmailRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(Email email){

        String sql = "INSERT INTO send_history (send_from, send_to, send_subject, send_body, send_cc, send_time) VALUES (?, ?, ?, ?, ?, NOW())";

        return jdbcTemplate.update(sql, new Object[] { email.getFromEmail(), email.getToEmail(), email.getSubject(), email.getBody(), email.getCcEmail()});
    }
}
