<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_col_colaboradorJB" class="br.com.handcopy.jb.Vw_col_colaboradorInsertJB" scope="request"/>
<jsp:setProperty name="vw_col_colaboradorJB" property="*"/>
<jsp:setProperty name="vw_col_colaboradorJB" property="page" value="${pageContext}"/>
${vw_col_colaboradorJB.execute}
{"resultado":"${vw_col_colaboradorJB.msg}"}
