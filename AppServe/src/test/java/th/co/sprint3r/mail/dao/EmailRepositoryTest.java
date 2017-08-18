package th.co.sprint3r.mail.dao;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import th.co.sprint3r.mail.model.Email;

import static org.junit.Assert.assertEquals;

public class EmailRepositoryTest {

    private Email email = new Email("sprint3rmail", "sprint3rsmtp@gmail.com", "", "Subject", "Body");

    @Test
    public void insert(){
        EmailRepository emailRepository = new EmailRepository();

        JdbcTemplateMock jdbcMock = new JdbcTemplateMock();

        emailRepository.jdbcTemplate = jdbcMock;

        emailRepository.insert(email);

        jdbcMock.assertShouldCallUpdate(1);
    }

    private class JdbcTemplateMock extends JdbcTemplate {
        int count;

        @Override
        public int update(String sql, @Nullable Object... args) throws DataAccessException {
            return count++;
        }

        public void assertShouldCallUpdate(int time){
            assertEquals(time, count);
        }
    }
}