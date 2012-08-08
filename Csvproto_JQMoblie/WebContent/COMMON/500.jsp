<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="2; url=../INTR/PINTR001.faces">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>500系统内部出错</title>
</head>
<body>
  500系统内部出错
  <br/> 错误码：
  <%=request.getAttribute("javax.servlet.error.status_code")%>
  <br/> 信息：
  <%=request.getAttribute("javax.servlet.error.message")%>
  <br/> 异常：
  <%=request.getAttribute("javax.servlet.error.exception_type")%>
  <br/>
</body>
</html>