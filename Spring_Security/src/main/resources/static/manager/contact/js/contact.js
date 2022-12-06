/**
 * create by wang
 * on May 13, 2022
*/


function startup() {
    var url = window.location.search.substring(1);
    console.log(url)
    getContact(url);
}


function getContact(url){
    $.ajax({
        type : "get",
        url : `${HOST}/contact/feedback/`+url,
        dataType : "json",
        success : function(data) {
            console.log(data);
            showContact(data);
        }
    });
}

function showContact(data) {
    $("#fName").val(data.firstName);
    $("#lName").val(data.lastName);
    $("#phone").val(data.phone);
    $("#emailaddress").val(data.email);
    $("#message").val(data.message);
    $("#cuid").val(data.cuid);
    $("#feedback").val(data.feedback);

}

function feedbackMsg(){
    console.log($("#feedback").val());
    $.ajax({
        method: "put",
        url: `${HOST}/contact/feedbackContact`,
        data: JSON.stringify ({
            "firstName":$("#fName").val(),
            "lastName":$("#lName").val(),
            "phone":$("#phone").val(),
            "email":$("#emailaddress").val(),
            "cuid":$("#cuid").val(),
            "message":$("#message").val(),
            "feedback":$("#feedback").val(),

        }),

        headers: {
            'Accept': 'application/json',
            'Content-type': 'application/json'
        }
    }).done((response) => {
            if(response.object!=null){
                alert(response.message);
            }
        }
    ).fail((obj, textStatus)=>{
        //An error is 400 ror 500
        if (obj && obj.responseJSON && obj.responseJSON.message){
            alert('b');
            alert(obj.responseJSON.message)
        }
        if (obj && obj.responseText){
            alert('c');
            alert(obj.responseText)
        }
    })
}