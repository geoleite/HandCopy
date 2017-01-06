<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ser_servicoJB" class="br.com.handcopy.jb.Ser_servicoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ser_servicoJB" property="*"/>                                         
<jsp:setProperty name="ser_servicoJB" property="page" value="${pageContext}"/>                                         
${ser_servicoJB.execute}                                         
{"resultado":
{"msg":"${ser_servicoJB.msg}",
     "ser_servico":{	"ser_nr_id":"${ser_servicoJB.ser_servicoT.ser_nr_id}"
 ,	"ser_tx_nome":"${ser_servicoJB.ser_servicoT.ser_tx_nome}"
  }
    }
     
}                                                                                
   
