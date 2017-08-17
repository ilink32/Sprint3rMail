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

  afterEach(function() {
    $("#form1").remove();
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
    $("#from").val("from email");
    // action
    submitForm();
    // assertion
//    expect($("#toError").text()).toEqual('Please fill TO value');
    expect($("#toError").text()).toEqual('Please fill TO value');
  });

  it("should show SUBJECT error if subject value is null", function() {
    // assign
    $("#from").val("from email");
    $("#to").val("to email");
    // action
    submitForm();
    // assertion
    expect($("#subjectError").text()).toEqual('Please fill SUBJECT value');
  });

  it("should show BODY error if body value is null", function() {
    // assign
    $("#from").val("from email");
    $("#to").val("to email");
    $("#subject").val("subject email");
    // action
    submitForm();
    // assertion
    expect($("#bodyError").text()).toEqual('Please fill BODY value');
  });

});
