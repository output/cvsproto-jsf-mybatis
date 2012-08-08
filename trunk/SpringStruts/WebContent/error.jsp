<%@ page contentType="text/html; charset=MS932" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.struts.Globals" %>
<%@ page import="org.apache.struts.action.ActionMessages" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!--
   Copyright 2007 NEC Corporation. All Rights Reserved
  -->



<%--
   システム名    : ProjectZEROv2
   サブシステム名: ZZZ01
   ファイル名    : $RCSfile: error.jsp,v $
   概要      	 : システムエラー画面
--%>


<html lang=”ja”>
<head>
    <title><bean:message key="SZZA0103"/></title>
    <link href="css/PartsProjectStyle.css" rel="stylesheet" type="text/css" />
<%-- ********** Generated section begin ********** --%>
<script language="javascript">
</script>



<%-- ********** Generated section end ********** --%>
</head>


<body>

<!---------------- ヘッダー領域 start ----------------------------------------->
<bean:define id="screenId" value="SZZA0103"/>
<bean:define id="menuControl" value="none"/>
<!--  bean:define id="logoutControl" value="none"/ -->
<%@ include file="header.html" %>
<!---------------- ヘッダー領域 end ------------------------------------------->


<!---------------- メイン領域 start ------------------------------------------->

<div id="main">

<br><br><br><br><br>
  <html:errors/>
</div>
<!---------------- メイン領域 end --------------------------------------------->


<!---------------- メッセージ領域 start --------------------------------------->

<!---------------- メッセージ領域 end ----------------------------------------->


<!---------------- ボタン領域 start ------------------------------------------->

<div id="footer">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">

    <tr>
        <td align="right"><input type="button" value="閉じる" class="button" onclick="window.close()"></td>
    </tr>
    </table>
</div>
<!---------------- ボタン領域 end --------------------------------------------->


</body>


</html>

<%
    try{
	    // セッションの無効化
	    session.invalidate();
    }catch(IllegalStateException e){
        // すでに無効化されているため、処理無し
    }
%>


<%--
  改版履歴：
  Rev = Date ======= Name ========= Note =================================
  1.0   2007/03/31    NEC           新規作成
  --%>


