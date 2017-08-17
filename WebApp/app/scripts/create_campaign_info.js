// function saveCampaignName(data) {
//     $.ajax({
//         type: "POST",
//         url: "http://ec2-52-77-254-50.ap-southeast-1.compute.amazonaws.com:8090/campaignmaster",
//         data: JSON.stringify({data:"test"}),
//         contentType: "application/json; charset=utf-8",
//         crossDomain: true,
//         dataType: "json",
//         success: function (data, status, jqXHR) {
//             alert("success");
//         },

//         error: function (jqXHR, status) {
//             console.log(jqXHR);
//             alert('fail' + status.code);
//         }
//     });
// }