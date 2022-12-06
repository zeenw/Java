/**
 * create by Zeen Wu
 * on June 1, 2022
*/

function startup() {
    initialization();
    showClub();
    showCourse();
}

function showClub(){
    let cid = sessionStorage.getItem("current_club");

    $.ajax({
        type : "get",
        url : `${HOST}/club/cid/${cid}`,
        dataType : "json",
        success : function(data) {
            
            var html = "";
            html = '<div class="card col-4"><img src="images/' 
            + data['pfile'] +'" class="card-img-top" alt=""><div class="card-body"><h5 class="card-title"> ' 
            + data['title'] + '</h5><p class="card-text"> ' 
            + data['comments'] + '</p></div></div>';
            document.getElementById('current_club').innerHTML = html;
        }
    });
}

function showCourse(){
    let cid = sessionStorage.getItem("current_club");
    $.ajax({
        type : "get",
        url : `${HOST}/course/cid/${cid}`,
        dataType : "json",
        success : function(data) {
            let title = ['Course ID', 'Course', 'Detail','Instructor'];
            document.getElementById('course_list').innerHTML = generateEditList(data, title);
        }
    });
}


function generateEditList(list, titles) {
    let html = '';
    html += '<table id="tbl_list" class="table table-dark table-striped">';
    html += '<thead><tr><th scope="col"> #</th>';
    for (let i in titles) {
        html += '<th scope="col">' + titles[i] + '</th>';
    }
    html += '</tr></thead><tbody>';

    for(let i = 0; i < list.length; i++) { 
        html += '<tr><td><input name="ckb_course" value="'+ list[i]['ccid'] +'" type="checkbox"></td>';
        html += '<td><a href="update_course.html?ccid='+ list[i]['ccid'] +'">'+ list[i]['ccid']+'</a></td>';
        html += '<td>'+ list[i]['course']+'</td>';
        html += '<td>'+ list[i]['comments']+'</td>';
        html += '<td>'+ list[i]['name']+'</td>';
        html += '</tr>'
    }
    html += '</tbody></table>'
    return html;
}

function addCourse(){
    cid = sessionStorage.getItem("current_club");
    iid = document.getElementById("instructor").selectedOptions[0].value;
    course = document.getElementById("course").value;
    comments = document.getElementById("comments").value;
    $.ajax({
        method: "post",
        url: `${HOST}/course/new`,
        data: JSON.stringify ({
            "cid": cid,
            "iid": iid,
            "course": course,
            "comments": comments
    }),headers: {
        'Accept': 'application/json',
        'Content-type': 'application/json'
    }}).done((response) => {
        document.getElementById("msg_addCourse").style.display="inline";
        document.getElementById("msg_addCourse").innerHTML = "The course has been added.";
        showCourse();
    }).fail((obj, textStatus)=>{
        //An error is 400 ror 500
        if (obj && obj.responseJSON && obj.responseJSON.message){
            alert(obj.responseJSON.message)
        }
        if (obj && obj.responseText){
            alert(obj.responseText)
        }
    })   
}

function deleteCourses(){
    let elm = document.getElementsByName("ckb_course");
    for(let i=0; i<elm.length; i++){
        if(elm[i].checked){
            deleteCourse(elm[i].value);
        }
    }
}

function deleteCourse(ccid){
    $.ajax({
        method: "DELETE",
        url: `${HOST}/course/delete/${ccid}`
    }).done((response) => {
        document.getElementById("msg_deleteCourses").style.display="inline";
        document.getElementById("msg_deleteCourses").innerHTML = response;

        showCourse();
    }).fail((obj, textStatus)=>{
        //An error is 400 ror 500
        if (obj && obj.responseJSON && obj.responseJSON.message){
            alert(obj.responseJSON.message)
        }
        if (obj && obj.responseText){
            alert(obj.responseText)
        }
    })

    
}