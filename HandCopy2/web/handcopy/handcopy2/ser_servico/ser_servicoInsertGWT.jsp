<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ser_servicoJB" class="br.com.handcopy.jb.Ser_servicoInsertJB" scope="request"/>
<jsp:setProperty name="ser_servicoJB" property="*"/>
<jsp:setProperty name="ser_servicoJB" property="page" value="${pageContext}"/>
${ser_servicoJB.execute}
{"resultado":"${ser_servicoJB.msg}"}
