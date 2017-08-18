
describe("CampaignInfoForm", function() {

  var rootId = 'testContainer';
  var formMarkup = '<form>'+
    '<input id="txtCampaignName" type="text">'+
    '<span id="lblErrorCampaignName"></span>'+
    '<select id="ddlEmailGroup" type="select" class="form-control">'+
    '<option value="0">Please Select</option>' +
    '<option value="1">Customer Group</option>'+
    '<option value="1">Employee Group</option>'+
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
  
  it("Save require campaign name", function() {
    form.save();
    expect($("#lblErrorCampaignName").text()).toEqual('Please input campaign name');
  });

  it("Save require email subject", function() {
    form.save();
    expect($("#lblErrorEmailSubject").text()).toEqual('Please input email subject');
  });

  it("Save require From Name", function() {
    form.save();
    expect($("#lblErrorFromName").text()).toEqual('Please input From Name');
  });

  it("Save require From Email", function() {
    form.save();
    expect($("#lblErrorFromEmail").text()).toEqual('Please input From Email');
  });

});
