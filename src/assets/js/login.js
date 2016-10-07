
$('.profileName').html(getCookie('hpman').split('%')[1]);
if (document.cookie != "" || document.cookie != "") {
    if (getCookie('hpman') == "" || getCookie('hpman') == null)
    {
        window.location.href = "/auth.html";
    }

}
else window.location.href = "/auth.html";

function setCookie(email, position, name, days) {
    var d = new Date();
    d.setTime(d.getTime() + (days*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    if (position == "Manager"){
        window.localStorage.setItem('logged_in', true);
        document.cookie = "hpman="+email + "#" + position +"%" + name +"; " + expires;
    }
    else {
        document.cookie = "hpkey=" + email + "#" + position + "%" + name + "; " + expires;
    }
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length,c.length);
        }
    }
    return "";
}

function logout() {
    var d = new Date();
    d.setTime(d.getTime() + (-1*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    var email = "", position = "", name ="";
        document.cookie = "hpman="+email + "#" + position +"%" + name +"; " + expires;
        document.cookie = "hpkey="+email + "#" + position +"%" + name +"; " + expires;
    window.localStorage.setItem('logged_in', false);
    window.location.href = '/';
}

function openDash(email, name)
{
    // alert(email);
    setCookie(email, "Employee", name, 1);
    // window.location.href = '/';
    var win = window.open('/user#/dashboard', '_blank');
    win.focus();
    // alert(JSON.stringify(document.cookie));

}


$(document).on('cookieUpdate', function(){
    if (getCookie('hkey') == "" && getCookie('hman') != "") {
        this.location.reload();
    }

});

$(document).trigger('cookieUpdate');

