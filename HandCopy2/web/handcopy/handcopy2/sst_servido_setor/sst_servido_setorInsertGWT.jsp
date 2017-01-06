<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="sst_servido_setorJB" class="br.com.handcopy.jb.Sst_servido_setorInsertJB" scope="request"/>
<jsp:setProperty name="sst_servido_setorJB" property="*"/>
<jsp:setProperty name="sst_servido_setorJB" property="page" value="${pageContext}"/>
${sst_servido_setorJB.execute}
{"resultado":"${sst_servido_setorJB.msg}"}
