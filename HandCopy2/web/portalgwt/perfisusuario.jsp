<%@page contentType="text/html" pageEncoding="latin1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<jsp:useBean id="perfis" class="br.com.easynet.easyportal.jb.PrincipalPageJB" scope="request"/>
<jsp:setProperty name="perfis" property="*"/>
<jsp:setProperty name="perfis" property="page" value="${pageContext}"/>
${perfis.execute}
{"resultado":{
"perfis":[{"nome":"root"}
<c:forEach var="item" items="${perfis.perfilUser}">
    ,{"nome":"${item.per_tx_nome}"}
</c:forEach>
]}
}