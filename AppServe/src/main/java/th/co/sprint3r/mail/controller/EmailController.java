package th.co.sprint3r.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.UriComponentsBuilder;

import th.co.sprint3r.mail.model.Email;

import javax.mail.internet.MimeMessage;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender sender;

    @RequestMapping(value = "/sendemail/",method = RequestMethod.POST)
    public ResponseEntity<?> send(@RequestBody Email email) {

        try {
            sendEmail(email);
        } catch (Exception ex){
            return new ResponseEntity(new CustomErrorType(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("200:OK");
    }


    private void sendEmail(Email email) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        boolean isHtml = true;

        helper.setFrom("sprint3rsmtp@gmail.com", email.getFromEmail());
        helper.setTo(email.getToEmail());
        if (email.getCcEmail() != null && !email.getCcEmail().isEmpty()) {
            helper.setCc(email.getCcEmail());
        }
        helper.setText(email.getBody(), isHtml);
        helper.setSubject(email.getSubject());

        sender.send(message);
    }
}
