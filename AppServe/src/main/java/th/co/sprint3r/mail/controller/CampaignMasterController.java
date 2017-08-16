package th.co.sprint3r.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.co.sprint3r.mail.dao.CampaignMasterRepository;
import th.co.sprint3r.mail.model.CampaignMaster;


import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/CampaignMaster")
public class CampaignMasterController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private CampaignMasterRepository campaignRepository;

    public CampaignMasterController(CampaignMasterRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    String hello() {

        return "Hello api Campaign!!!";
    }

    @RequestMapping(value = "/Master/", method = RequestMethod.GET)
    public List<CampaignMaster> listAll() {

        List<CampaignMaster> resultList = campaignRepository.listCampaign(0);
        return resultList;
    }

    @RequestMapping(value = "/Master/{campaignId}", method = RequestMethod.GET)
    public List<CampaignMaster> listId(@PathVariable long campaignId) {

        List<CampaignMaster> resultList = campaignRepository.listCampaign(campaignId);
        return resultList;
    }
}

