<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="coc_cota_colaboradorJB" class="br.com.handcopy.jb.Coc_cota_colaboradorInsertJB" scope="request"/>
<jsp:setProperty name="coc_cota_colaboradorJB" property="*"/>
<jsp:setProperty name="coc_cota_colaboradorJB" property="page" value="${pageContext}"/>
${coc_cota_colaboradorJB.execute}
{"resultado":"${coc_cota_colaboradorJB.msg}"}
