describe("CreateSendMailForm", function() {
  //var rootId = 'testContainer';
  var formMarkup = '<form id="form1">'+
    '<input id="from" type="text" placeholder="">'+
    '<input id="to" type="text" placeholder="">'+
    '<input id="subject" type="text" placeholder="">'+
    '<textarea id="emailBody"/>'+
    '<button id="btnSend" type="button" >Send</button>'+
    '<span id="fromError"></span>'+
    '<span id="toError"></span>'+
    '<span id="subjectError"></span>'+
    '<span id="bodyError"></span>'+
    '</form>'

  beforeEach(function() {
    $("body", document).append(formMarkup);
  });


  it("should show FROM error if from value is null", function() {
    // assign
    // action
    submitForm();
    // assertion
    expect($("#fromError").text()).toEqual('Please fill FROM value');
  });

  it("should show TO error if to value is null", function() {
    // assign
    $("#from").value = "Test";
    console.log($("#from").value)
    // action
    submitForm();
    // assertion
    expect($("#toError").text()).toEqual('Please fill TO value');
  });

  it("should show SUBJECT error if subject value is null", function() {
    // assign
    $("#from").value = "Test";
    $("#to").value = "Test";
    // action
    submitForm();
    // assertion
    expect($("#subjectError").text()).toEqual('Please fill SUBJECT value');
  });

});
