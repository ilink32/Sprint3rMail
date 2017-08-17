
describe("CampaignInfoForm", function() {

  var rootId = 'testContainer';
  var formMarkup = '<form>'+
    '<input id="txtCampaignName" type="text">'+
    '<span id="lblErrorCampaignName"></span>'+
    '<select id="ddlEmailGroup" type="select" class="form-control">'+
    '<option value="1">Please Select</option>'+
    '<option value="2">Customer1</option>'+
    '</select>'+
    '<span id="lblErrorEmailGroup"></span>'+
    '<input id="txtEmailSubject" type="text">'+
    '<span id="lblErrorEmailSubject"></span>'+
    '<input id="txtFromName" type="text">'+
    '<span id="lblErrorFromName"></span>'+
    '<input id="txtFromEmail" type="text">'+
    '<span id="lblErrorFromEmail"></span>'+
    '<button id="btnSaveCampaign" type="button">'+
    '<button id="btnCreateEmail" type="button"'+
    '</form>';

  beforeEach(function() {
    var container  = $("<div>" + formMarkup + "</div>");  
    $("body").append(container);
    container.attr("id",rootId);
    form = new CampaignInfoForm();
  });

  afterEach(function(){
    var container = $("#" + rootId);
    container.remove();
  });

  // it("Has blank email subject initially", function() {
  //   expect(form.txtEmailSubject).toEqual('');
  // });

  // it("Has blank from name initially", function() {
  //   expect(form.txtFromName).toEqual('');
  // });

  // it("Has blank from email initially", function() {
  //   expect(form.txtFromEmail).toEqual('');
  // });
  
  // it("Save require campaign name", function() {
  //   form.create();
  //   expect($("#lblErrorCampaignName").text()).toEqual('Please input campaign name');
  // });

  it("Save require email subject", function() {
    form.create();
    expect($("#lblErrorEmailSubject").text()).toEqual('Please input email subject');
  });

  it("Save require From Name", function() {
    form.create();
    expect($("#lblErrorFromName").text()).toEqual('Please input From Name');
  });

  it("Save require From Email", function() {
    form.create();
    expect($("#lblErrorFromEmail").text()).toEqual('Please input From Email');
  });

});
