package th.co.sprint3r.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import th.co.sprint3r.mail.model.Email;

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

    @RequestMapping(value = "/test/", params = {"fromEmail","toEmail", "subject","body"}, method = RequestMethod.GET)

    public String SendEmail(@RequestParam(value = "fromEmail") String fromEmail,@RequestParam(value = "toEmail") String toEmail,@RequestParam(value = "subject") String subject,@RequestParam(value = "body") String body ) {
        try {
            //sendEmail("<b>How are you?</b>");
            sendEmail(fromEmail,toEmail,subject,body);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping(value = "/send/",method = RequestMethod.POST)
    public ResponseEntity<?> send(@RequestBody Email email, UriComponentsBuilder ucBuilder) {

        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("sprint3rsmtp@gmail.com",email.getFromEmail());
            helper.setTo(email.getToEmail());
            helper.setText(email.getBody(), true);
            helper.setSubject(email.getSubject());

            sender.send(message);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return ResponseEntity.ok("OK");
    }


    private void sendEmail(String fromEmail,String toEmail, String subject , String body) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("sprint3rsmtp@gmail.com",fromEmail);
        helper.setTo(toEmail);
        helper.setText(body, true);
        helper.setSubject(subject);

        sender.send(message);
    }
}
