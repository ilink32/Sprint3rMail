package th.co.sprint3r.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import th.co.sprint3r.mail.dao.CampaignMasterRepository;
import th.co.sprint3r.mail.model.CampaignMaster;


import javax.sql.DataSource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/campaignmaster")
public class CampaignMasterController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private CampaignMasterRepository campaignRepository;

//    public CampaignMasterController(CampaignMasterRepository campaignRepository) {
//        this.campaignRepository = campaignRepository;
//    }

    private CustomErrorType customError = new CustomErrorType("");

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CampaignMaster>> listAll() {

        List<CampaignMaster> resultList = campaignRepository.listAll();

        if (resultList.isEmpty()) {
            return new ResponseEntity(customError.campaignNotFound(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<CampaignMaster>>(resultList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{campaignId}", method = RequestMethod.GET)
    public ResponseEntity<List<CampaignMaster>> listId(@PathVariable long campaignId) {

        List<CampaignMaster> resultList = campaignRepository.listCampaign(campaignId);

        if (resultList.isEmpty()) {
            return new ResponseEntity(customError.campaignNotFound(campaignId), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<CampaignMaster>>(resultList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<CampaignMaster>> insert(@RequestBody CampaignMaster campaignMaster) {
        boolean exist = campaignRepository.exists(campaignMaster);
        System.out.println("campaignMaster " + campaignMaster.getCampaignName() + " --> exist = " + exist);
        if (exist) {
            return new ResponseEntity(customError.campaignInsertDuplicate(campaignMaster), HttpStatus.CONFLICT);
        }
        long campaignId = campaignRepository.insert(campaignMaster);

        List<CampaignMaster> resultList = campaignRepository.listCampaign(campaignId);
        return new ResponseEntity<List<CampaignMaster>>(resultList, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{campaignId}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable long campaignId, @RequestBody CampaignMaster campaignMaster) {

        long result = campaignRepository.update(campaignMaster);

        if (result != 1) {
            return new ResponseEntity(customError.campaignUpdateNotFound(campaignMaster), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CampaignMaster>(campaignMaster, HttpStatus.OK);
    }
}

