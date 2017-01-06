<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sst_servido_setorJB" class="br.com.handcopy.jb.Sst_servido_setorConsultJB" scope="request"/>                                         
<jsp:setProperty name="sst_servido_setorJB" property="*"/>                                         
<jsp:setProperty name="sst_servido_setorJB" property="page" value="${pageContext}"/>                                         
${sst_servido_setorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${sst_servido_setorJB.list}" var="item">
     ,{	"set_nr_id":"${item.set_nr_id}"
 ,	"ser_nr_id":"${item.ser_nr_id}"
  }
</c:forEach>
]}                                                                                
   
