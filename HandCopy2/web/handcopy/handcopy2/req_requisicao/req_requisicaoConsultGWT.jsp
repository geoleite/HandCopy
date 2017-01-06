<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="req_requisicaoJB" class="br.com.handcopy.jb.Req_requisicaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="req_requisicaoJB" property="*"/>                                         
<jsp:setProperty name="req_requisicaoJB" property="page" value="${pageContext}"/>                                         
${req_requisicaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${req_requisicaoJB.list}" var="item">
     ,{	"req_nr_id":"${item.req_nr_id}"
 ,	"col_nr_id":"${item.col_nr_id}"
 ,	"req_tx_identificador":"${item.req_tx_identificador}"
 ,	"req_tx_teriminal":"${item.req_tx_teriminal}"
 ,	"req_dt_requisitado":"<fmt:formatDate value="${item.req_dt_requisitado}" pattern="dd/MM/yyyy HH:mm"/>"
  }
</c:forEach>
]}                                                                                
   
