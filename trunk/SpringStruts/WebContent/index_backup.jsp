<html>
<head>
<SCRIPT language="JavaScript" >

function openLogin() {
        w=1024;
        h=768;
        LeftPosition = (screen.width) ? (screen.width-w)/2:0;
        TopPosition = (screen.height) ? (screen.height-h)/2:0;
        allurl = '<%=request.getContextPath()%>/menu.jsp';
        window.open(allurl,'','location=no,status=yes,scrollbars=no,titlebar=no,toolbar=no,width=1019,height=706,top='+TopPosition+',left='+LeftPosition+'');
        window.opener=this;
        window.close();
        }
</SCRIPT>

</head>

<body onLoad="openLogin()">

</body>
</html>