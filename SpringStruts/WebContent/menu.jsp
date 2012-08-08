<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.struts.Globals" %>
<%@ page import="org.apache.struts.action.ActionMessages" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
	<title>SZZA0102：メニュー画面</title>
	<link href="css/PartsProjectStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/menu.css" rel="stylesheet" type="text/css">
</head>
<body>
<form name="form1" method="post" action="">
	<div id="header">
	  <table class="titletable" border="0">
	    <tr>
	        <td rowspan="2">
	            <img src="image/logov2.gif" alt="ProjectZERO" />
	        </td>
			<td width="600" rowspan="2" class="screenname">SZZA0102：メニュー画面</td>
	        <td width="75" class="screenitem">&nbsp;</td>
	        <td width="75" class="screenitem">&nbsp;</td>
	    </tr>
	    <tr>
	        <td class="screenitem" colspan="2">ユーザhnnc</td>
	    </tr>
	    <tr>
	        <td class="screenitem" colspan="2">&nbsp;</td>
	        
	        <td width=75 class="screenitem">
	        	<a href="/ProjectZERO">メニューへ </a>
	        </td>
	        <td width=75 class="screenitem">
	        	<a href="/ProjectZERO" onclick="window.opener=window;window.self.close();">ログアウト</a>
	        </td>
	    </tr>
	  </table>
	</div>

	<div id="main">
		<div id="menu">
			<table border="0" align="left" cellpadding="0" cellspacing="0">
				<tr>
					<td style="background-color: #3233CF;text-align: center;color: #FFFFFF;">メニュー</td>
				</tr>
				<tr>
					<td style="background-color: #6263C5;text-align: left;color: #FFFFFF;">－商品管理</td>
				</tr>
				<tr>
					<td style="padding-left:25px;background-color: #CBFFC8;text-align: left;color: #6ABA43;">
						<a href=" <%=request.getContextPath()%>/SZAA0201Init.do ">■商品情報検索・更新・削除</a>
					</td>
				</tr>
				<tr>
					<td style="padding-left:25px;background-color: #CBFFC8;text-align: left;color: #6ABA43;">
						<a href=" <%=request.getContextPath()%>/SZAA0111Init.do ">■商品情報新規登録</a>
					</td>
				</tr>
				<tr>
					<td style="padding-left:25px;background-color: #CBFFC8;text-align: left;color: #6ABA43;">
						<a href=" <%=request.getContextPath()%>/SZAB0111Init.do ">■入庫情報一括登録</a>
					</td>
				</tr>
				<tr>
					<td style="background-color: #6263C5;text-align: left;color: #FFFFFF;">－出荷管理</td>
				</tr>
				<tr>
					<td style="padding-left:25px;background-color: #CBFFC8;text-align: left;color: #6ABA43;">
						<a href=" <%=request.getContextPath()%>/SZAC0201Init.do ">■出荷情報検索・削除</a>
					</td>
				</tr>
				<tr>
					<td style="padding-left:25px;background-color: #CBFFC8;text-align: left;color: #6ABA43;">
						<a href=" <%=request.getContextPath()%>/SZAC0111Init.do ">■出荷情報新規登録</a>
					</td>
				</tr>
			</table>
		</div>
		<div id="info">
			<H2>お知らせ</h2>
			<table border="0" align="center" cellpadding="0" cellspacing="0">
			
			</table>
		</div>
	</div>
	<div id="message">
		<div class="message_guide">
		</div>
	</div>
	<div id="footer">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>