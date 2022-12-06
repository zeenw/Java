/**
 * create by wang
 * on May 13, 2022
*/


function startup() {
    getContactList();
}


function getContactList(){
    $.ajax({
        type : "get",
        url : `${HOST}/contact/getContactList/`,
        dataType : "json",
        success : function(data) {
            showContactList(data);
        }
    });
}

function showContactList(list) {
    let titles = ['First name', 'Last name', "Phone", "Email", "Message", "Opertion"];
    let html = '';
    html += '<table id="tbl_list" class="table table-dark table-striped">';
    html += '<thead><tr><th scope="col"> #</th>';
    for (let i in titles) {
        html += '<th scope="col">' + titles[i] + '</th>';
    }
    html += '</tr></thead><tbody>';

    for(let i = 0; i < list.length; i++) { 
        html += '<tr>'
        html += '<td>'+ list[i]['cuid']+'</td>';
        html += '<td>'+ list[i]['firstName']+'</td>';
        html += '<td>'+ list[i]['lastName']+'</td>';
        html += '<td>'+ list[i]['phone']+'</td>';
        html += '<td>'+ list[i]['email']+'</td>';
        html += '<td>'+ list[i]['message']+'</td>';
        html += '<td><a href="../contact/contact.html?'+list[i]['cuid']+'">Feedback</a></td>';
        html += '</tr>'
    }
    html += '</tbody></table>'

    let element = document.getElementById("contact_list");
    element.innerHTML = html;
  
}