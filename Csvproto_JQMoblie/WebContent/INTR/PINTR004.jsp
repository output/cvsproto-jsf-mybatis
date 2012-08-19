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
</head>
<body>
  <f:view>
    <header>注册账号</header>
    <div id="mainDiv">
        <h:form id="pintr004Form">
            <div>
                                账号(*)：
                <h:inputText id="username"
                    value="#{PINTR004Form.username }"></h:inputText>
            </div>
            <div>
                                密码(*)：
                <h:inputSecret id="password"
                    value="#{PINTR004Form.password }"></h:inputSecret>
            </div>
            <div>
                                真实姓名：
                <h:inputText id="truename"
                    value="#{PINTR004Form.truename }"></h:inputText>
            </div>
            <div>
                                年龄：
                <h:inputText id="age" value="#{PINTR004Form.age }"></h:inputText>
                <h:selectOneListbox id="selectage"></h:selectOneListbox>
            </div>
            <div>
                                注册邮箱：
                <h:inputText id="email" value="#{PINTR004Form.email }"></h:inputText>
            </div>
            <div>
                <h:commandButton action="#{PINTR004Event.submitRegister }" value="提交" id="submitRegister"></h:commandButton>
            </div>
        </h:form>
    </div>
    <footer>八丹网</footer>
    </f:view>
</body>
</html>