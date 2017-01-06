<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ser_servicoJB" class="br.com.handcopy.jb.Ser_servicoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ser_servicoJB" property="*"/>                                         
<jsp:setProperty name="ser_servicoJB" property="page" value="${pageContext}"/>                                         
${ser_servicoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ser_servicoJB.list}" var="item">
     ,{	"ser_nr_id":"${item.ser_nr_id}"
 ,	"ser_tx_nome":"${item.ser_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
