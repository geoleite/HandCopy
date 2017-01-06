<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="sol_solicitacaoJB" class="br.com.handcopy.jb.Sol_solicitacaoInsertJB" scope="request"/>
<jsp:setProperty name="sol_solicitacaoJB" property="*"/>
<jsp:setProperty name="sol_solicitacaoJB" property="page" value="${pageContext}"/>
${sol_solicitacaoJB.execute}
{"resultado":"${sol_solicitacaoJB.msg}"}
