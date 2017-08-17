describe("CreateSendMailForm", function() {
  //var form;
  var rootId = 'testContainer';
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
//    var container = document.createElement('div');
//    container.setAttribute('id',rootId);
//    document.body.appendChild(container);
//    container.innerHTML = formMarkup;
//    console.log(container.innerHTML);
    //form = new CreateSendMailForm();
  });


  it("should show FROM error if from value is null", function() {
    // assign
    // action
    submitForm();
    // assertion
    expect($("#fromError").text()).toEqual('Please fill FROM value');
//      form.to = "abc";
//      form.subject = "xyz";
//      form.emailBody = "content";
//      form.btnSend.onClick = submitForm();
 //    expect($("#fromError").text()).toEqual('Please fill FROM value');
  });



});
