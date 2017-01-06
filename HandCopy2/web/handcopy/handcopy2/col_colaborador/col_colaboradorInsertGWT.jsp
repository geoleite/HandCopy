<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="col_colaboradorJB" class="br.com.handcopy.jb.Col_colaboradorInsertJB" scope="request"/>
<jsp:setProperty name="col_colaboradorJB" property="*"/>
<jsp:setProperty name="col_colaboradorJB" property="page" value="${pageContext}"/>
${col_colaboradorJB.execute}
{"resultado":"${col_colaboradorJB.msg}"}
