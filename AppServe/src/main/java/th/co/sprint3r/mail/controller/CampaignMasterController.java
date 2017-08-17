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

@RestController
@RequestMapping("/campaignmaster")
public class CampaignMasterController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private CampaignMasterRepository campaignRepository;

    public CampaignMasterController(CampaignMasterRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CampaignMaster>> listAll() {

        List<CampaignMaster> resultList = campaignRepository.listAll();

        return new ResponseEntity<List<CampaignMaster>>(resultList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{campaignId}", method = RequestMethod.GET)
    public ResponseEntity<List<CampaignMaster>> listId(@PathVariable long campaignId) {

        List<CampaignMaster> resultList = campaignRepository.listCampaign(campaignId);

        if (resultList.isEmpty()) {
            return new ResponseEntity(new CustomErrorType("campaignId " + campaignId
                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<CampaignMaster>>(resultList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody CampaignMaster campaignMaster, UriComponentsBuilder ucBuilder) {
        if (campaignRepository.exists(campaignMaster)) {
            return new ResponseEntity(new CustomErrorType("Unable to create CampaignName " +
                    campaignMaster.getCampaignName() + " already exist."), HttpStatus.CONFLICT);
        }
        long campaignId = campaignRepository.insert(campaignMaster);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/campaignmaster/{campaignId}").buildAndExpand(campaignId).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{campaignId}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable long campaignId, @RequestBody CampaignMaster campaignMaster) {

        long result = campaignRepository.update(campaignMaster);

        if (result != 1) {
            return new ResponseEntity(new CustomErrorType("Unable to update campaignId " + campaignId + " cause campaignId not found."),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CampaignMaster>(campaignMaster, HttpStatus.OK);
    }
}

