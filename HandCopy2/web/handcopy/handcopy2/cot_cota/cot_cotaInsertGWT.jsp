<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cot_cotaJB" class="br.com.handcopy.jb.Cot_cotaInsertJB" scope="request"/>
<jsp:setProperty name="cot_cotaJB" property="*"/>
<jsp:setProperty name="cot_cotaJB" property="page" value="${pageContext}"/>
${cot_cotaJB.execute}
{"resultado":"${cot_cotaJB.msg}"}
