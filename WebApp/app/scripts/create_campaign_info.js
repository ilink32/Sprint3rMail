$(document).ready(function(){
    pageLoad();
});

function pageLoad() {
    var form = new CampaignInfoForm();
    $("#txtCampaignName").val($.urlParam('campaignName'));
    $("#btnSaveCampaign").click(function(){
        form.create();
    });
    $("#btnCreateEmail").click(function(){
        form.create();
        window.location.replace("../send_mail.html");
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
    var hasError = false;
    this.txtCampaignName = $.trim($.urlParam('campaignName'));
    this.txtEmailSubject = $.trim($("#txtEmailSubject").val());
    this.txtFromName = $.trim($("#txtFromName").val());
    this.txtFromEmail = $.trim($("#txtFromEmail").val());
    //this.ddlEmailGroup = 

    this.create = function(){
        if (this.txtCampaignName.length == 0){
            this.lblErrorCampaignName = "Please input campaign name";
            $("#lblErrorCampaignName").text(this.lblErrorCampaignName);
            hasError = true;
        } else {
            this.lblErrorCampaignName = '';
            $("#lblErrorCampaignName").text(this.lblErrorCampaignName);
        } 

        if (this.txtEmailSubject.length == 0){
            this.lblErrorEmailSubject = "Please input email subject";
            $("#lblErrorEmailSubject").text(this.lblErrorEmailSubject);
            hasError = true;
        } else {
            this.lblErrorEmailSubject = '';
            $("#lblErrorEmailSubject").text(this.lblErrorEmailSubject);
        } 

        if (this.txtFromName.length == 0){
            this.lblErrorFromName = "Please input From Name";
            $("#lblErrorFromName").text(this.lblErrorFromName);
            hasError = true;
        } else {
            this.lblErrorFromName = '';
            $("#lblErrorFromName").text(this.lblErrorFromName);
        } 

        if (this.txtFromEmail.length == 0){
            this.lblErrorFromEmail = "Please input From Email";
            $("#lblErrorFromEmail").text(this.lblErrorFromEmail);
            hasError = true;
        } else {
            this.lblErrorFromEmail = '';
            $("#lblErrorFromEmail").text(this.lblErrorFromEmail);
        }

        if(hasError == false){
            saveCampaignName();
        }

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

function saveCampaignName(data) {

    data = [{
        "campaignName": $("#txtCampaignName").val(),
        "emailGroup": $("#ddlEmailGroup").val(),
        "emailSubject": $("#txtEmailSubject").val(),
        "fromName": $("#txtFromName").val(),
        "fromEmail": $("#txtFromEmail").val()
    }];

    console.log(data);

    // $.ajax({
    //     type: "POST",
    //     url: "http://ec2-52-77-254-50.ap-southeast-1.compute.amazonaws.com:8090/campaignmaster",
    //     data: JSON.stringify(data),
    //     contentType: "application/json; charset=utf-8",
    //     crossDomain: true,
    //     dataType: "json",
    //     success: function (data, status, jqXHR) {
    //         alert("success");
    //     },

    //     error: function (jqXHR, status) {
    //         console.log(jqXHR);
    //         alert('fail' + status.code);
    //     }
    // });
}