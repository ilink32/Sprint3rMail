function submitForm()
    {
    var fromVal=document.forms["form1"]["from"].value;
    var toVal=document.forms["form1"]["to"].value;
    var subjectVal=document.forms["form1"]["subject"].value;
    var bodyVal=document.forms["form1"]["emailBody"].value;

    var result = true;


    if (fromVal==null || fromVal=="")
      {
      //document.getElementById("fromError").innerHTML = "Please fill FROM value";
      $("#fromError").html("Please fill FROM value");
      result = false;
      }
    if (toVal=="" || toVal==null)
      {
      //document.getElementById("toError").innerHTML = "Please fill TO value";
      $("#toError").html("Please fill TO value");
      result = false;
      }
    if (subjectVal==null || subjectVal=="")
      {
      $("#subjectError").html("Please fill SUBJECT value");
      //document.getElementById("subjectError").innerHTML = "Please fill SUBJECT value";
      result = false;
      }

    if (bodyVal==null || bodyVal=="")
      {
      $("#bodyError").html("Please fill BODY value");
     // document.getElementById("bodyError").innerHTML = "Please fill BODY value";
      result = false;
      }

    if (result == true ) {
      // TODO: Call backend sendMail
      alert("Send mail success");
    }
    return result;

    }
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// You can do this to perform a global override of any of the "default" options
        // jHtmlArea.fn.defaultOptions.css = "jHtmlArea.Editor.css";
        $(function() {

            $("#emailBody").htmlarea(); // Initialize jHtmlArea's with all default values

            $("#txtCustomHtmlArea").htmlarea({
                // Override/Specify the Toolbar buttons to show
                toolbar: [
                    ["bold", "italic", "underline", "|", "forecolor"],
                    ["p", "h1", "h2", "h3", "h4", "h5", "h6"],
                    ["link", "unlink", "|", "image"],
                    [{
                        // This is how to add a completely custom Toolbar Button
                        css: "custom_disk_button",
                        text: "Save",
                        action: function(btn) {
                            // 'this' = jHtmlArea object
                            // 'btn' = jQuery object that represents the <A> "anchor" tag for the Toolbar Button
                            alert('SAVE!\n\n' + this.toHtmlString());
                        }
                    }]
                ],

                // Override any of the toolbarText values - these are the Alt Text / Tooltips shown
                // when the user hovers the mouse over the Toolbar Buttons
                // Here are a couple translated to German, thanks to Google Translate.
                toolbarText: $.extend({}, jHtmlArea.defaultOptions.toolbarText, {
                        "bold": "fett",
                        "italic": "kursiv",
                        "underline": "unterstreichen"
                    }),

                // Specify a specific CSS file to use for the Editor
                css: "styles//jHtmlArea.Editor.css",

                // Do something once the editor has finished loading
                loaded: function() {
                    //// 'this' is equal to the jHtmlArea object
                    //alert("jHtmlArea has loaded!");
                    //this.showHTMLView(); // show the HTML view once the editor has finished loading
                }
            });
        });
