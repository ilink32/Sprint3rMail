$(document).ready(function(){
    pageLoad();
});

function pageLoad() {
    // $("#btnCreateCampaign").click(function(){
    //     validateCampaignName();
    // });
    // $("#txtCampaignName").keyup(function(){
    //     clearErrorMsg();
    // });
    var form = new CreateCampaignForm();
    $("#btnCreateCampaign").click(function(){
        form.create();
    });
}


// function validateCampaignName() {
//     var campaignName = $.trim($("#txtCampaignName").val());
//     if (campaignName.length == 0 ) {
//         campaignNameEmpty();
//     } else {
//         campaignNameCollect();
//     }
// }

// function campaignNameEmpty() {
//     var errorMsg = "Please input campaign name";
//     $("#lblErrorCampaignName").html('').append(errorMsg);
//     $("#txtCampaignName").focus();
// } 

// function campaignNameCollect() {
//     window.location.replace("../create_campaign_info.html");
// } 

// function clearErrorMsg(){
//     $("#lblErrorCampaignName").html('').append("");
// }


var CreateCampaignForm = function() {
    this.txtCampaignName = $("#txtCampaignName").val();

    this.create = function(){
        this.lblErrorCampaignName = "Please input campaign name";
        $("#lblErrorCampaignName").text(this.lblErrorCampaignName);
    }
};
