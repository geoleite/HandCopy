<!-- Motando Menu -->
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="mep_men_perJB" class="br.com.easynet.easyportal.menu.jb.MontaMenuJB" scope="request"/>                                         
<jsp:setProperty name="mep_men_perJB" property="*"/>                                         
<jsp:setProperty name="mep_men_perJB" property="page" value="${pageContext}"/>    
<script type="text/javascript" src="../Resource/js/stmenu.js"></script>
<script type="text/javascript">
<!--
window.onerror=function(m,u,l)
{
	window.status = "Java Script Error: "+m;
	return true;
}
//-->
</script>

    ${mep_men_perJB.execute}

<!-- Fim menu-->