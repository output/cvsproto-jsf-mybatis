<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib tagdir="/WEB-INF/tags/jsfx" prefix="jsfx"%>


<!DOCTYPE html> 
<html> 
    <head>
    <meta charset="utf-8" />
    <title>Page Title</title>
    <!-- JQMobile -->
    <link rel="stylesheet" type="text/css" href="../css/common/jquery.mobile-1.1.1.css">
    <script type="text/javascript" src="../script/common/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="../script/common/jquery.mobile-1.1.1.js"></script>

<script type="text/javascript">
$(document).bind("mobileinit",function(){ 
    //这里是重写的代码
    alert("init");
    }
);

$.mobile.pageLoading(); 
</script>
</head> 
<body> 

<div data-role="page">

    <div data-role="header">
        <h1>标题</h1>
    </div><!-- /header -->

    <div data-role="content">   
        <p>页面主体.</p>        
        
        <a href="PINTR001.faces" rel="external">Multi-page link</a>
    </div><!-- /content -->
    
    <div data-role="footer">
        <h4>页脚</h4>

    </div><!-- /footer -->
</div><!-- /page -->

<script type="text/javascript">
//$.mobile.changePage("PINTR002.faces", "sildeup");
$.mobile.changePage("ok.html", "sildeup");
</script>
</body>
</html>
