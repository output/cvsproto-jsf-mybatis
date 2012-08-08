<%-- ********************************************************
  This file is generated
    GeneratedDate  : Fri Nov 25 16:42:35 JST 2011
    JspGeneratorVer: 1.1
    HtmlFileName   : D:\NEC_WORK\workspace\ProjectZERO\WebLayout\SZAB011Ｄ.html
********************************************************* --%>
<%-- ********** Generated section begin ********** --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%-- ********** Generated section end ********** --%>
<html>
<head>
<title><bean:message key="SZAB011D"/></title>
<link href="css/ProjectZEROStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<html:form action="/SZAB011D">
	<bean:define id="screenId" value="SZAB011D" />
	<%@ include file="/header.html"%>
	<div id="main">
	<div id="main2">
	<table width="93%" border="1" cellspacing="1" cellpadding="1">
		<tr class="row-title">
			<td width="35">番号</td>
			<td width="55">結果</td>
			<td width="90">入庫日</td>
			<td width="100">商品コード</td>
			<td width="95">入庫後数量</td>
			<td width="90">入庫数</td>
			<td width="110">入庫担当者ID</td>
			<td width="355">備考</td>
		</tr>

		<bean:define id="stockInfoRegResult" name="SZAB011D"
			property="stockInfoRegResult" />
		<logic:present name="stockInfoRegResult">
			<%
			  List aList = (List)pageContext.getAttribute("stockInfoRegResult");
			  if (aList.size()==0) {
			    pageContext.setAttribute("stockInfoRegResult", new String[] {"dummy"});
			  }
			%>
			<logic:iterate id="stockInfoRegResult" name="stockInfoRegResult"
				indexId="index">
				
				<logic:notEqual name="stockInfoRegResult" value="dummy">
					<bean:define id="rowstyle" value="" />
					
					<tr class='<bean:write name="stockInfoRegResult"
							property="cssClass" />'>
						<td>
						<div align="center"><%= index.intValue() + 1 %></div>
						</td>
						<td>
						<div><bean:write name="stockInfoRegResult"
							property="rnt" /></div>
						</td>						
						<td>
						<div align="center"><bean:write name="stockInfoRegResult"
							property="storingDate" /></div>
						</td>
						<td>
						<div align="center"><bean:write name="stockInfoRegResult"
							property="productCd" /></div>
						</td>
						
						<logic:equal value="0" name="stockInfoRegResult" property="quantity">
							<td><div>&nbsp;</div>
							</td>
						</logic:equal>
						<logic:notEqual value="0" name="stockInfoRegResult" property="quantity">
							<td>
								<div align="right"><bean:write name="stockInfoRegResult"
									property="quantity" format="###,###" /></div>
							</td>
						</logic:notEqual>
						
						<td>
						<div align="right"><bean:write name="stockInfoRegResult"
							property="storingQuantity"  format="##,###" /></div>
						</td>
						<td>
						<div><bean:write name="stockInfoRegResult"
							property="storingUserCd" /></div>
						</td>
						<td>
						<div><bean:write name="stockInfoRegResult"
							property="remarks" /></div>
						</td>
					</tr>
					
				</logic:notEqual>
			</logic:iterate>
		</logic:present>		
	</table>
	</div>
	</div>

	<div id="message">
			<%-- エラーメッセージ --%>
			<div id="message_error">
				<html:errors />
			</div>
			<%-- ガイドメッセージ --%>
			<div class="message_guide">
				<bean:message key="MZAB004I"/>
			</div>
		</div>

	<div id="footer">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left">&nbsp;</td>
			<td align="right"><html:submit property="updCompOk" value="OK"
				styleClass="button70"></html:submit></td>
		</tr>
	</table>
	</div>
</html:form>
		<script type="text/javascript">
			document.forms[0].updCompOk.focus();
		</script>
</body>
</html>