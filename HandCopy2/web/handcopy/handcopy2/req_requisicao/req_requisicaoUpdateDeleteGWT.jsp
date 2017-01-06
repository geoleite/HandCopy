<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="req_requisicaoJB" class="br.com.handcopy.jb.Req_requisicaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="req_requisicaoJB" property="*"/>                                         
<jsp:setProperty name="req_requisicaoJB" property="page" value="${pageContext}"/>                                         
${req_requisicaoJB.execute}                                         
{"resultado":
{"msg":"${req_requisicaoJB.msg}",
     "req_requisicao":{	"req_nr_id":"${req_requisicaoJB.req_requisicaoT.req_nr_id}"
 ,	"col_nr_id":"${req_requisicaoJB.req_requisicaoT.col_nr_id}"
 ,	"req_tx_identificador":"${req_requisicaoJB.req_requisicaoT.req_tx_identificador}"
 ,	"req_tx_teriminal":"${req_requisicaoJB.req_requisicaoT.req_tx_teriminal}"
 ,	"req_dt_requisitado":"<fmt:formatDate value="${req_requisicaoJB.req_requisicaoT.req_dt_requisitado}" pattern="dd/MM/yyyy HH:mm"/>"
  }
    }    
}                                                                                
   
