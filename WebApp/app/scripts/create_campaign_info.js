$(document).ready(function(){
    pageLoad();
});

function pageLoad() {
    var form = new CampaignInfoForm();
    $("#txtCampaignName").val($.urlParam('campaignName'));
    $("#btnSaveCampaign").click(function(){
        form.save("N");
    });
    $("#btnCreateEmail").click(function(){
        form.save("Y");
    });

    $("#txtCampaignName").change(function(){
        form.txtCampaignName = $.trim($("#txtCampaignName").val());
    });
    
    $("#txtCampaignName").keyup(function(){
        $("#lblErrorCampaignName").text('');
    });

    $("#ddlEmailGroup").change(function(){
        $("#lblErrorEmailGroup").text('');
    });

    $("#txtEmailSubject").change(function(){
        form.txtEmailSubject = $.trim($("#txtEmailSubject").val());
    });

    $("#txtEmailSubject").keyup(function(){
        $("#lblErrorEmailSubject").text('');
    });

    $("#txtFromName").change(function(){
        form.txtFromName = $.trim($("#txtFromName").val());
    });
    $("#txtFromName").keyup(function(){
        $("#lblErrorFromName").text('');
    });

    $("#txtFromEmail").change(function(){
        form.txtFromEmail = $.trim($("#txtFromEmail").val());
    });
    $("#txtFromEmail").keyup(function(){
        $("#lblErrorFromEmail").text('');
    });
}

var CampaignInfoForm = function() {

   this.save = function(redirectFlag){
        
        this.txtCampaignName = $.trim($("#txtCampaignName").val());
        this.ddlEmailGroup = $.trim($("#ddlEmailGroup").val());
        this.txtEmailSubject = $.trim($("#txtEmailSubject").val());
        this.txtFromName = $.trim($("#txtFromName").val());
        this.txtFromEmail = $.trim($("#txtFromEmail").val());

        if (this.isEmpty(this["txtCampaignName"])){
            this.setErrorMsg("lblErrorCampaignName","Please input campaign name");
        } else {
            this.clearErrorMsg("lblErrorCampaignName");
        } 

        if (this.isUnSelected(this["ddlEmailGroup"])){
            this.setErrorMsg("lblErrorEmailGroup","Please select email group");
        } else {
            this.clearErrorMsg("lblErrorEmailGroup");
        } 

        if (this.isEmpty(this["txtEmailSubject"])){
            this.setErrorMsg("lblErrorEmailSubject","Please input email subject");
        } else {
            this.clearErrorMsg("lblErrorEmailSubject");
        } 

        if (this.isEmpty(this["txtFromName"])){
            this.setErrorMsg("lblErrorFromName","Please input From Name");
        } else {
            this.clearErrorMsg("lblErrorFromName");
        } 

        if (this.isEmpty(this["txtFromEmail"])){
            this.setErrorMsg("lblErrorFromEmail","Please input From Email");
        } else {
            this.clearErrorMsg("lblErrorFromEmail");
        }

        if (!this.hasError()) {
            saveCampaignName(redirectFlag);
        }

    }

    this.isEmpty = function(field){
        return (field.length == 0);
    }

    this.isUnSelected = function(field){
        return (field == 0);
    }

    this.clearErrorMsg = function(fieldName){
        this.fieldName = '';
        $("#" + fieldName).text(this.fieldName);
    }

    this.setErrorMsg = function(fieldName, errorMsg){
        this.fieldName = errorMsg;
        $("#" + fieldName).text(this.fieldName);
    }

    this.hasError = function(){
        var fields = ['txtCampaignName','txtEmailSubject','txtFromName','txtFromEmail'];
        var hasError;
        var self = this;
        fields.forEach( function(field,fields){
            hasError = hasError || self.isEmpty(self[field]);
        });
        return hasError || self.isUnSelected(self['ddlEmailGroup']);
    }
};

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return null;
    }
    else{
       return decodeURI(results[1]) || 0;
    }
}

function saveCampaignName(redirectFlag) {

    var data = {
        "campaignName": $("#txtCampaignName").val(),
        "emailGroup": $("#ddlEmailGroup").val(),
        "emailSubject": $("#txtEmailSubject").val(),
        "fromName": $("#txtFromName").val(),
        "fromEmail": $("#txtFromEmail").val()
    };

    $.ajax({
        type: "POST",
        url: "http://ec2-52-77-254-50.ap-southeast-1.compute.amazonaws.com:8090/campaignmaster",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        success: successHandler,
        error: errorHandler
    });

    function successHandler(data, status, jqXHR) {
        alert("Create Campaign Success");
        console.log("success");
        if (redirectFlag=="Y") 
            window.location.replace("../send_mail.html?campaignId=" + data[0].campaignId);
    }

    function errorHandler(jqXHR, status) {
        alert(jqXHR.responseText);
    }
}