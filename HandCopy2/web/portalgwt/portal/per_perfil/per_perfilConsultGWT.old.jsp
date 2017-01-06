<%@page contentType="text/html" pageEncoding="latin1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<jsp:useBean id="perfis" class="br.com.easynet.easyportal.jb.Per_perfilConsultJB" scope="request"/>
<jsp:setProperty name="perfis" property="*"/>
<jsp:setProperty name="perfis" property="page" value="${pageContext}"/>
${perfis.execute}
{"resultado":[
   {"registro":"marcacao"}
   <c:forEach var="item" items="${perfis.list}">
    ,{"per_nr_id":"${item.per_nr_id}"
    ,"per_tx_nome":"${item.per_tx_nome}"
    ,"per_tx_status":"${item.per_tx_status}"
    ,"per_tx_class":"${item.per_tx_class}"
    }
</c:forEach>
]}