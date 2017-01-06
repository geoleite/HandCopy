<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ope_operacaoJB" class="br.com.i9.portal.jb.Ope_operacaoInsertJB" scope="request"/>
<jsp:setProperty name="ope_operacaoJB" property="*"/>
<jsp:setProperty name="ope_operacaoJB" property="page" value="${pageContext}"/>
${ope_operacaoJB.execute}
{"resultado":"${ope_operacaoJB.msg}"}
