<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="par_parametroJB" class="br.com.i9.portal.jb.Par_parametroInsertJB" scope="request"/>
<jsp:setProperty name="par_parametroJB" property="*"/>
<jsp:setProperty name="par_parametroJB" property="page" value="${pageContext}"/>
${par_parametroJB.execute}
{"resultado":"${par_parametroJB.msg}"}
