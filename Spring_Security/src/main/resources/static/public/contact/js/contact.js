/**
 * create by Zeen Wu
 * on June 1, 2022
*/

function startup() {
    showUser();

}

function isValidate() {
  let feedback;
  let rs = true;
  let o_fName = document.getElementById('fName');
  let v_fName = o_fName.value;
  let o_lName = document.getElementById('lName');
  let v_lName = o_lName.value;
  let o_phone = document.getElementById('phone');
  let v_phone = o_phone.value;
  let o_email = document.getElementById('emailaddress');
  let v_email = o_email.value;
  let o_message = document.getElementById('message');
  let v_message = o_message.value;
  let div_common_msg = document.getElementById('div_common_msg');
  let div_email_msg = document.getElementById('div_email_msg');
  let div_phone_msg = document.getElementById('div_phone_msg');
  let div_fName_msg = document.getElementById('div_fName_msg');
  let div_lName_msg = document.getElementById('div_lName_msg');


  // focus order depends the input controller order in web page
  if(v_message == '') {
    o_message.focus(); 
    div_message_msg.innerHTML = MSG_EMPTY_NICE;
    div_message_msg.style.color = 'red';
    rs = false;
  } else {
    div_message_msg.innerHTML = '';
  }

  if(isEmail(v_email)) {

    div_email_msg.innerHTML = '';
  }else{
    o_email.value = v_email;
    o_email.focus(); 
    div_email_msg.innerHTML = MSG_INVALIDEMAIL;
    div_email_msg.style.color = 'red';
    rs = false;
  }

  if(v_phone == '') {
    o_phone.focus(); 
    div_phone_msg.innerHTML = MSG_EMPTY;
    div_phone_msg.style.color = 'red';
    rs = false;
  } else if(ck_Phone(v_phone)){
    div_phone_msg.innerHTML = '';
    o_phone.value = ck_Phone(v_phone);
  } else {
    o_phone.focus(); 
    div_phone_msg.innerHTML = MSG_INVALIDPHONE;
    div_phone_msg.style.color = 'red';
  }

  if(v_fName == '') {
    o_fName.focus();
    div_fName_msg.innerHTML = MSG_EMPTY;
    div_fName_msg.style.color = 'red';
    rs = false;
  } else {
    div_fName_msg.innerHTML = '';
  }

  if(v_fName == '') {
    o_fName.focus();
    div_lName_msg.innerHTML = MSG_EMPTY;
    div_lName_msg.style.color = 'red';
    rs = false;
  } else {
    div_lName_msg.innerHTML = '';
  }

  if( rs ) {
    document.getElementById('div_msg_success').style.visibility = 'visible';
    feedback = {
      "firstName": v_fName,
      "lastName": v_lName,
      "phone": v_phone,
      "email": v_email,
      "message": v_message
    }
    $.ajax({
      method: "post",
      url: `${HOST}/contact/saveContact`,
      data: JSON.stringify ({
        "firstName":v_fName,
        "lastName":v_lName,
        "phone":v_phone,
        "email":v_email,
        "message":v_message,
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

    localStorage.setItem('feedback', feedback);
  } else {
    document.getElementById('div_msg_success').style.visibility = 'hidden';
  }

}
  
  
  