<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="col_colaboradorJB" class="br.com.handcopy.jb.Col_colaboradorConsultJB" scope="request"/>                                         
<jsp:setProperty name="col_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="col_colaboradorJB" property="page" value="${pageContext}"/>                                         
${col_colaboradorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${col_colaboradorJB.list}" var="item">
     ,{	"col_nr_id":"${item.col_nr_id}"
 ,	"sca_nr_id":"${item.sca_nr_id}"
  }
</c:forEach>
]}                                                                                
   
