package th.co.sprint3r.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.sprint3r.mail.dao.EmailGroupRepository;
import th.co.sprint3r.mail.model.EmailGroup;


import javax.sql.DataSource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/emailgroup")
public class EmailGroupController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private EmailGroupRepository emailGroupRepository;

    public EmailGroupController(EmailGroupRepository emailGroupRepository) {
        this.emailGroupRepository = emailGroupRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EmailGroup>> listAll() {

        List<EmailGroup> resultList = emailGroupRepository.listAll();

        if (resultList.isEmpty()) {
            return new ResponseEntity(CustomErrorType.emailGroupNotFoundAll().getErrorMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<EmailGroup>>(resultList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{emailGroupId}", method = RequestMethod.GET)
    public ResponseEntity<List<EmailGroup>> listId(@PathVariable long emailGroupId) {

        List<EmailGroup> resultList = emailGroupRepository.listEmail(emailGroupId);

        if (resultList.isEmpty()) {
            return new ResponseEntity(CustomErrorType.emailGroupNotFound(emailGroupId).getErrorMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<EmailGroup>>(resultList, HttpStatus.OK);
    }

}

