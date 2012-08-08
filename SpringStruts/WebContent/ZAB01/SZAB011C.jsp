<%-- ********************************************************
  This file is generated
    GeneratedDate  : Fri Nov 25 16:41:50 JST 2011
    JspGeneratorVer: 1.1
    HtmlFileName   : D:\NEC_WORK\workspace\ProjectZERO\WebLayout\SZAB011C.html
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
<title><bean:message key="SZAB011C" /></title>

<link href="css/ProjectZEROStyle.css" rel="stylesheet" type="text/css" />

</head>
<body>
<html:form action="/SZAB011C">
	<bean:define id="screenId" value="SZAB011C" />
	<%@ include file="/header.html"%>

	<div id="main">
	<div id="main2">
	<table width="90%" border="1" cellspacing="1" cellpadding="1" id="tab">
		<tr class="row-title">
			<td width="80" align="center">入庫日</td>
			<td width="90" align="center">商品コード</td>
			<td width="100" align="center">入庫後数量</td>
			<td width="80" align="center">入庫数</td>
			<td width="100" align="center">入庫担当者ID</td>
			<td width="373" align="center">備考</td>
		</tr>

		<bean:define id="stockInfoRegConfirm" name="SZAB011C"
			property="stockInfoRegConfirm" />
		<logic:present name="stockInfoRegConfirm">
			<%
			  List aList = (List)pageContext.getAttribute("stockInfoRegConfirm");
			  if (aList.size()==0) {
			    pageContext.setAttribute("stockInfoRegConfirm", new String[] {"dummy"});
			  }
			%>
			<logic:iterate id="stockInfoRegConfirm" name="stockInfoRegConfirm"
				indexId="index">

				<logic:notEqual name="stockInfoRegConfirm" value="dummy">
					<bean:define id="rowstyle" value="" />
					<%
					      pageContext.setAttribute("rowstyle", 
						(index.intValue()%2==0)?"row-odd":"row-even");
					
					%>

					<tr class='<%=pageContext.getAttribute("rowstyle")%>'>
						<td>
							<div align="center"><bean:write name="stockInfoRegConfirm"
							property="storingDate" format="YYYY/MM/DD" /></div>
						</td>
						<td>
							<div align="center"><bean:write name="stockInfoRegConfirm"
							property="productCd" /></div>
						</td>
						
						<logic:equal value="0" name="stockInfoRegConfirm" property="quantity">
							<td><div>&nbsp;</div>
							</td>
						</logic:equal>
						<logic:notEqual value="0" name="stockInfoRegConfirm" property="quantity">
							<td>
								<div align="right"><bean:write name="stockInfoRegConfirm"
									property="quantity" format="##,###" /></div>
							</td>
						</logic:notEqual>

						<td>
							<div align="right"><bean:write name="stockInfoRegConfirm"
							property="storingQuantity"  format="##,###" /></div>
						</td>
						<td>
							<div><bean:write name="stockInfoRegConfirm"
							property="storingUserCd" /></div>
						</td>
						<td>
							<div><bean:write name="stockInfoRegConfirm"
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
				<bean:message key="MZAB002I"/>
			</div>
			<div class="message_guide">
				<bean:message key="MZAB003I"/>
			</div>
		</div>
	
	<div id="footer">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="left">
			 	 		<html:submit property="updInpBack" value="戻る" styleClass="button70"></html:submit>
			 	 	</td>
					<td align="right">
						<html:submit property="updInpOk" value="OK" styleClass="button70"></html:submit>
					</td>
				</tr>
			</table>
		</div>
</html:form>
		<script type="text/javascript">
			document.forms[0].updInpBack.focus();
		</script>
</body>

</html>