
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

function changeTheme(){
//   if ( document.getElementById('PINTR001_css').href != '../css/INTR/PINTR001_black.css'){
//       document.getElementById('PINTR001_css').href = '../css/INTR/PINTR001_blur.css';
//   }else{
//       document.getElementById('PINTR001_css').href = '../css/INTR/PINTR001_blur.css';
//   }
    
//    $('mianpanel').toogleClass('themeBlack');
    var panel = document.getElementById('MianPanel');
    if( panel.className  != 'themeBlack'){
        panel.className  = 'themeBlack';
    }else{
        panel.className  = 'theme';
    }    
    return false;
}