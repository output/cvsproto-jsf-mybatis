<%@ tag body-content="empty" pageEncoding="UTF-8"
    description="表示前アクションタグ部品(JSF環境用)です。
    指定したメソッドをJSP実行時に呼び出します。" %>
<%@tag import="javax.faces.context.FacesContext" %>
<%@ attribute name="action"
    required="true"
    deferredMethod="true"
    type="javax.el.MethodExpression"
    description="呼び出すメソッドを
    &quot;&#x0023;{Bean名.メソッド名}&quot;
    の形式で指定します。"
    %>
<%
    action.invoke(FacesContext.getCurrentInstance().getELContext(), null);
%>
