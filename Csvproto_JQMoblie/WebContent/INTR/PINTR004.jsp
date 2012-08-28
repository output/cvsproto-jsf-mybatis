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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册账号</title>
<!-- JQmobile -->
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.css" />
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.js"></script>
<!-- 公共CSS文件 -->
<!-- 
<link rel="stylesheet" type="text/css" href="../css/common/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/common/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="../css/common/pagelayout.css" />
 -->
<!-- 公共JavaScript文件 -->
<!--
<script type="text/javascript" src="../script/common/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../script/common/jquery.alerts.js"></script>
 -->
<!-- PINTR001 -->
<link rel="stylesheet" type="text/css" href="../css/INTR/PINTR004.css" id="PINTR001_css" >
<script type="text/javascript" src="../script/INTR/PINTR004.js"></script>
</head>
<body>
  <f:view>
  <div data-role="page">
    <div data-role="header">注册账号</div>
    <div id="mainDiv" data-role="content">
        <h:form id="pintr004Form">
            <div>
                                账号(*)：
                <h:inputText id="username"
                    value="#{PINTR004Form.username }" required="true"></h:inputText><h:messages for="username" showDetail="true" showSummary="false"></h:messages>
            </div>
            <div>
                                密码(*)：
                <h:inputSecret id="password"
                    value="#{PINTR004Form.password }" required="true"></h:inputSecret><h:messages for="password" showDetail="true" showSummary="false"></h:messages>
            </div>
            <div>
                                真实姓名：
                <h:inputText id="truename"
                    value="#{PINTR004Form.truename }"></h:inputText><h:messages for="truename" showDetail="true" showSummary="false"></h:messages>
            </div>
            <div>
                <!-- 年龄：
                <h:inputText id="age" value="#{PINTR004Form.age }"></h:inputText><h:messages for="age" showDetail="true" showSummary="false"></h:messages>
                <h:selectOneListbox id="selectage" size="5" ></h:selectOneListbox>
                 -->
                <label for="slider-0">年龄：</label>
                <input type="range" name="age" id="age" value="20" min="0" max="100" />
                <h:messages for="age" showDetail="true" showSummary="false"></h:messages>
            </div>
            <div>
                                出生年月
                <h:inputText id="birthday" value="#{PINTR004Form.birthday }">
                    <f:convertDateTime type="date" pattern="yyyy/MM"/>
                </h:inputText><h:messages for="birthday" showDetail="true" showSummary="false"></h:messages>
            </div>
            <div>
                                注册邮箱：
                <h:inputText id="email" value="#{PINTR004Form.email }">
                </h:inputText><h:messages for="email" showDetail="true" showSummary="false"></h:messages>
            </div>
            <div>
                                电话：
                <h:inputText id="telphone" value="#{PINTR004Form.phone }">
                    <f:converter converterId="kang.PhoneConverter" />
                    <f:validateLength minimum="11" maximum="11"/>
                    <f:convertNumber pattern="#10000000000"/>                    
                </h:inputText><h:messages for="telphone" showDetail="true" showSummary="false"></h:messages>
            </div>
            <div>
                <h:commandButton action="#{PINTR004Event.submitRegister }" value="提交" id="submitRegister"></h:commandButton>
            </div>            
        </h:form>
    </div>
    <div data-role="footer">八丹网</div>
    </div>
    </f:view>
</body>
</html>