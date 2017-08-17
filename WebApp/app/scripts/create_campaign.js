$(document).ready(function(){
    pageLoad();
});

function pageLoad() {
    var form = new CreateCampaignForm();
    $("#btnCreateCampaign").click(function(){
        form.create();
    });
    $("#txtCampaignName").change(function(){
        form.txtCampaignName = $.trim($("#txtCampaignName").val());
    });
    $("#txtCampaignName").keyup(function(){
        $("#lblErrorCampaignName").text('');
    });
}

var CreateCampaignForm = function() {
    this.txtCampaignName = $.trim($("#txtCampaignName").val());

    this.create = function(){
        if (this.txtCampaignName.length == 0){
            this.lblErrorCampaignName = "Please input campaign name";
            $("#lblErrorCampaignName").text(this.lblErrorCampaignName);
        } else {
            this.lblErrorCampaignName = '';
            $("#lblErrorCampaignName").text(this.lblErrorCampaignName);
            window.location.replace("../create_campaign_info.html?campaignName=" + this.txtCampaignName);
        } 
    }
};
