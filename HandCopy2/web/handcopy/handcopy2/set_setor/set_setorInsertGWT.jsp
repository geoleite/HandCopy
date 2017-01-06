<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="set_setorJB" class="br.com.handcopy.jb.Set_setorInsertJB" scope="request"/>
<jsp:setProperty name="set_setorJB" property="*"/>
<jsp:setProperty name="set_setorJB" property="page" value="${pageContext}"/>
${set_setorJB.execute}
{"resultado":"${set_setorJB.msg}"}
