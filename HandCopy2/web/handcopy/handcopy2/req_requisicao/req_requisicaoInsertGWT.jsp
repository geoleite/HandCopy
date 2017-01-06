<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="req_requisicaoJB" class="br.com.handcopy.jb.Req_requisicaoInsertJB" scope="request"/>
<jsp:setProperty name="req_requisicaoJB" property="*"/>
<jsp:setProperty name="req_requisicaoJB" property="page" value="${pageContext}"/>
${req_requisicaoJB.execute}
{"resultado":"${req_requisicaoJB.msg}"}
