    function submitForm()
    {
    var fromVal=document.forms["form1"]["from"].value;
    var toVal=document.forms["form1"]["to"].value;
    var subjectVal=document.forms["form1"]["subject"].value;
    var bodyVal=document.forms["form1"]["emailBody"].value;

    var result = true;


    if (fromVal==null || fromVal=="")
      {
      document.getElementById("fromError").innerHTML = "Please fill FROM value";
      result = false;
      }
    if (toVal=="" || toVal==null)
      {
      document.getElementById("toError").innerHTML = "Please fill TO value";
      result = false;
      }
    if (subjectVal==null || subjectVal=="")
      {
      document.getElementById("subjectError").innerHTML = "Please fill SUBJECT value";
      result = false;
      }

    if (bodyVal==null || bodyVal=="")
      {
      document.getElementById("bodyError").innerHTML = "Please fill BODY value";
      result = false;
      }

    if (result == true ) {
      // TODO: Call backend sendMail
      alert("Send mail success");
    }
    return result;

    }
