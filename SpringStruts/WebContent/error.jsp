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
   �V�X�e����    : ProjectZEROv2
   �T�u�V�X�e����: ZZZ01
   �t�@�C����    : $RCSfile: error.jsp,v $
   �T�v      	 : �V�X�e���G���[���
--%>


<html lang=�hja�h>
<head>
    <title><bean:message key="SZZA0103"/></title>
    <link href="css/PartsProjectStyle.css" rel="stylesheet" type="text/css" />
<%-- ********** Generated section begin ********** --%>
<script language="javascript">
</script>



<%-- ********** Generated section end ********** --%>
</head>


<body>

<!---------------- �w�b�_�[�̈� start ----------------------------------------->
<bean:define id="screenId" value="SZZA0103"/>
<bean:define id="menuControl" value="none"/>
<!--  bean:define id="logoutControl" value="none"/ -->
<%@ include file="header.html" %>
<!---------------- �w�b�_�[�̈� end ------------------------------------------->


<!---------------- ���C���̈� start ------------------------------------------->

<div id="main">

<br><br><br><br><br>
  <html:errors/>
</div>
<!---------------- ���C���̈� end --------------------------------------------->


<!---------------- ���b�Z�[�W�̈� start --------------------------------------->

<!---------------- ���b�Z�[�W�̈� end ----------------------------------------->


<!---------------- �{�^���̈� start ------------------------------------------->

<div id="footer">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">

    <tr>
        <td align="right"><input type="button" value="����" class="button" onclick="window.close()"></td>
    </tr>
    </table>
</div>
<!---------------- �{�^���̈� end --------------------------------------------->


</body>


</html>

<%
    try{
	    // �Z�b�V�����̖�����
	    session.invalidate();
    }catch(IllegalStateException e){
        // ���łɖ���������Ă��邽�߁A��������
    }
%>


<%--
  ���ŗ����F
  Rev = Date ======= Name ========= Note =================================
  1.0   2007/03/31    NEC           �V�K�쐬
  --%>


