
describe("CreateCampaignForm", function() {

  var rootId = 'testContainer';
  var formMarkup = '<form>'+
    '<input id="txtCampaignName" type="text" placeholder="" maxlength="50">'+
    '<button id="btnCreateCampaign" type="button" >Create</button>'+
    '<span id="lblErrorCampaignName"></span>'+
    '</form>'

  beforeEach(function() {
    var container = document.createElement('div');
    container.setAttribute('id',rootId);
    document.body.appendChild(container);
    container.innerHTML = formMarkup;
    form = new CreateCampaignForm();
  });

  it("Has blank campaign name initially", function() {
    expect(form.txtCampaignName).toEqual('');
  });

  it("Create require campaign name", function() {
    form.create();
     expect($("#lblErrorCampaignName").text()).toEqual('Please input campaign name');
  });



});

