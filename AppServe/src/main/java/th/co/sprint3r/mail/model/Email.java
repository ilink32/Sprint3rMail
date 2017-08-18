package th.co.sprint3r.mail.model;

public class Email {
    String fromEmail;
    String toEmail;
    String ccEmail;
    String subject;
    String body;

    public Email() {
    }

    public Email(String fromEmail, String toEmail, String ccEmail,String subject, String body) {
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.ccEmail = ccEmail;
        this.subject = subject;
        this.body = body;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
