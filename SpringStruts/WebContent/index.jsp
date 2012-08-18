<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 
<meta http-equiv="refresh" content="0; url=./menu.jsp">
 -->
<title>Loading...</title>
<script type="text/javascript">

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
</script>
</head>
<body onLoad="openLogin()">
</body>
</html>