// $(document).ready(function(){
//     pageLoad();
// });

// function pageLoad() {
//     $("#btnCreateCampaign").click(function(){
//         validateCampaignName();
//     });
// }

// function validateCampaignName() {
//     var campaignName = $.trim($("#txtCampaignName").val());
//     var errorMsg = "Please input campaign Name";
    
//     if (campaignName.length == 0 ) {
//         campaignNameEmpty(errorMsg);
//     } else {
//         campaignNameCollect(campaignName);
//     }
// }

// function campaignNameCollect(campaignName) {
//     clearErrorMsg();
//     alert("Campaign Name: " + campaignName);
// } 

// function campaignNameEmpty(errorMsg) {
//     $("#lblErrorCampaignName").html('').append(errorMsg);
//     $("#txtCampaignName").focus();
// } 

// function clearErrorMsg() {
//     $("#lblErrorCampaignName").html('').append('');
// }


// function validateCampaignName() {
//     var txtCampaignName = $("#txtCampaignName").val();
//     var errorMsg = "Please input campaign Name";

//     if (txtCampaignName.length == 0 ) {
//         return errorMsg;
//     } else {
//         return "";
//     }
// }