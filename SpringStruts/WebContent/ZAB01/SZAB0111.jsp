<%-- ********************************************************
  This file is generated
    GeneratedDate  : Thu Nov 24 16:12:43 JST 2011
    JspGeneratorVer: 1.1
    HtmlFileName   : D:\NEC_WORK\workspace\ProjectZERO\WebLayout\SZAB0111.html
********************************************************* --%>
<%-- ********** Generated section begin ********** --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%-- ********** Generated section end ********** --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="SZAB0111" /></title>
<link href="css/ProjectZEROStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

      function comSubmit(action) {
        var url = "<%=request.getContextPath()%>" + action;
        alert(url);
        document.forms[0].action = url;
        document.forms[0].submit();
        return true;
    }
</script>
</head>
<body>
  <html:form action="/SZAB0111" enctype="multipart/form-data">
    <bean:define id="screenId" value="SZAB0111" />
    <%@ include file="/header.html"%>
    
    <div id="main">
      <br></br>
      <html:file property="upload" errorStyleClass="error" />
      <br/>
      账号:
      <html:text property="username" errorStyleClass="error"></html:text>
      <br/>
      密码:
      <html:password property="password" errorStyleClass="error"></html:password>
    </div>
    
    <div id="message">
      <%-- エラーメッセージ --%>
      <div id="message_error">
        <html:errors />
      </div>
      <%-- ガイドメッセージ --%>
      <div class="message_guide">
        <bean:message key="MZAB001I" />
      </div>
    </div>
    
    <div id="footer">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="left"><input type="button" name="clear" class="button70" value="クリア" onclick="javascript:comSubmit('/SZAB0111Clear.do')" />
          </td>
          <td align="right"><input type="submit" name="login" class="button70" value="登録" />
        </tr>
      </table>
    </div>
  </html:form>
  
  <script type="text/javascript">
    document.forms[0].upload.focus();
  </script>
</body>
</html>