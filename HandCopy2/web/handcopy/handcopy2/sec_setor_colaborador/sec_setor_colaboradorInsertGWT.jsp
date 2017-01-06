<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="sec_setor_colaboradorJB" class="br.com.handcopy.jb.Sec_setor_colaboradorInsertJB" scope="request"/>
<jsp:setProperty name="sec_setor_colaboradorJB" property="*"/>
<jsp:setProperty name="sec_setor_colaboradorJB" property="page" value="${pageContext}"/>
${sec_setor_colaboradorJB.execute}
{"resultado":"${sec_setor_colaboradorJB.msg}"}
