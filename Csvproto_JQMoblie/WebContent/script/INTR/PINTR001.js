
// CSS选择
function setTheme_BlackWhilte() {
    document.getElementById('SCPI001_css').href = '../css/INTR/SCPI001_blackwhite.css';
}

function submit() {
    var intputUsername = document.getElementById("pintr001Form:username");
//    var inputPassword = document.getElementById("password");

    if (intputUsername.value.length == 0) {
        alert("please input username");
        return false;
    }
    
    return true;
}