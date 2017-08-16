
var AuthenticationForm = function() {
  this.txtCampaignName = $("#txtCampaignName").val();
  this.create = function(){
    this.lblErrorCampaignName = "Please input campaign name.";
    $("#lblErrorCampaignName").text(this.lblErrorCampaignName);
  }
};


describe("Validate campaign name", function() {
  
  
  
  var rootId = 'testContainer';
  var authenticationFormMarkup = '<form>'+
    '<input id="txtCampaignName" type="text" placeholder="" maxlength="50">'+
    '<button id="btnCreateCampaign" type="button" >Create</button>'+
    '<span id="lblErrorCampaignName"></span>'+
    '</form>'

  beforeEach(function() {
    var container = document.createElement('div');
    container.setAttribute('id',rootId);
    document.body.appendChild(container);
    container.innerHTML = authenticationFormMarkup;
    authenticationForm = new AuthenticationForm();
  });

  it("Blank campaign name", function() {
    expect(authenticationForm.txtCampaignName).toEqual('');
  });

  it("submit require campaign name", function() {
     authenticationForm.create();
     expect(authenticationForm.lblErrorCampaignName).toEqual('Please input campaign name.');
     expect($("#lblErrorCampaignName").text()).toEqual('Please input campaign name.');
  });

});

