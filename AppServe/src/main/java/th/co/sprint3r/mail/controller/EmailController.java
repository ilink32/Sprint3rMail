package th.co.sprint3r.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender sender;

    @RequestMapping(method = RequestMethod.GET)
    String hello() {

        return "Hello api Email!!!";
    }

    @RequestMapping(value = "/send/", params = {"toEmail", "subject","body"}, method = RequestMethod.GET)

    public String SendEmail(@RequestParam(value = "toEmail") String toEmail,@RequestParam(value = "subject") String subject,@RequestParam(value = "body") String body ) {
        try {
            //sendEmail("<b>How are you?</b>");
            sendEmail(toEmail,subject,body);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "ok";
    }

    private void sendEmail(String toEmail, String subject , String body) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(toEmail);
        helper.setText(body, true);
        helper.setSubject(subject);

        sender.send(message);
    }
}
