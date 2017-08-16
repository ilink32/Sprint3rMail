$(document).ready(function(){
    pageLoad();
});

function pageLoad() {
    $("#btnCreateCampaign").click(function(){
        validateCampaignName();
    });
    $("#txtCampaignName").keyup(function(){
        clearErrorMsg();
    });
}

function validateCampaignName() {
    var campaignName = $.trim($("#txtCampaignName").val());
    if (campaignName.length == 0 ) {
        campaignNameEmpty();
    } else {
        campaignNameCollect();
    }
}

function campaignNameEmpty() {
    var errorMsg = "Please input campaign name";
    $("#lblErrorCampaignName").html('').append(errorMsg);
    $("#txtCampaignName").focus();
} 

function campaignNameCollect() {
    window.location.replace("../create_campaign_info.html");
} 

function clearErrorMsg(){
    $("#lblErrorCampaignName").html('').append("");
}

// function validateCampaignName() {
//     var txtCampaignName = $("#txtCampaignName").val();
//     var errorMsg = "Please input campaign Name";

//     if (txtCampaignName.length == 0 ) {
//         return errorMsg;
//     } else {
//         return "";
//     }
// }