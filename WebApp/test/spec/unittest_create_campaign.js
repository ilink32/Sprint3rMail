
describe("CreateCampaignForm", function() {

  var rootId = 'testContainer';
  var formMarkup = '<form>'+
    '<input id="txtCampaignName" type="text">'+
    '<button id="btnCreateCampaign" type="button" >Create</button>'+
    '<span id="lblErrorCampaignName"></span>'+
    '</form>';

  beforeEach(function() {
    var container  = $("<div>" + formMarkup + "</div>");  
    $("body").append(container);
    container.attr("id",rootId);
    form = new CreateCampaignForm();
  });

  afterEach(function(){
    var container = $("#" + rootId);
    container.remove();
  });

  it("Has blank campaign name initially", function() {
    expect(form.txtCampaignName).toEqual('');
  });

  it("Create require campaign name", function() {
    form.create();
    expect($("#lblErrorCampaignName").text()).toEqual('Please input campaign name');
  });

  // it("Create correct campaign name", function() {
  //   form.txtCampaignName = "New Campaign Name";
  //   form.create();
  //   expect($("#lblErrorCampaignName").text()).toEqual('');
  // });

});