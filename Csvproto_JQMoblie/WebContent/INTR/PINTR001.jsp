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
<title>用户登录</title>
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
<link rel="stylesheet" type="text/css" href="../css/INTR/PINTR001.css" id="PINTR001_css" >
<script type="text/javascript" src="../script/INTR/PINTR001.js"></script>
</head>
<body>
  <f:view>
  <div data-role="page">
        <%-- JSF的标签要写在<f:view>里面 --%>
    <div id="MianPanel" class="theme" data-role="content">
<div id="loginPanel">
      <h:form id="pintr001Form">
        <c:if test="${PINTR001Form.loginFlag == false }">
                     账号:
          <h:inputText id="username" styleClass="inputType" accesskey="u"
            value="#{PINTR001Form.username }">
            </h:inputText>
          <br />
                    密码:
          <h:inputSecret id="password" styleClass="inputType" accesskey="p"
            value="#{PINTR001Form.password }"></h:inputSecret>
          <br />
          <h:commandButton id="submit" value="提交"
            action="#{PINTR001Event.checkUser }"></h:commandButton>
          <h:commandButton id="register" value="注册" accesskey="r" action="#{PINTR001Event.registerUser }"></h:commandButton>
        </c:if>
        <c:if test="${PINTR001Form.loginFlag == true  }">
          <h:commandLink id="getUserList" accesskey="u" value="用户列表"
            action="#{PINTR001Event.getUserList }"></h:commandLink>
          <h:commandButton id="logout" value="退出登录"
            action="#{PINTR001Event.logOut }"></h:commandButton>
          <c:if test="${not empty PINTR001Form.list }">
          <table class="">
            <c:forEach var="item" items="${PINTR001Form.list }">
              <tr>
                <td><c:out value="${item.username}" /></td>
              </tr>
            </c:forEach>
          </table>
          </c:if>
        </c:if>
        <br/>
      <h:commandButton value="切换主题" onclick="return changeTheme()" ></h:commandButton>
      </h:form>
      </div>
      <div class="imgFilter">
        <img src="../image/PINTR001/QQ2012-Wallpaper-White.jpg" height="700" width="1364">
      </div>
    </div>
    </div>
  </f:view>
</body>
</html>