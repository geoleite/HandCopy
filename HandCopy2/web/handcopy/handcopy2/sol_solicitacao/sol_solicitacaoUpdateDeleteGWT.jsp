<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sol_solicitacaoJB" class="br.com.handcopy.jb.Sol_solicitacaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="sol_solicitacaoJB" property="*"/>                                         
<jsp:setProperty name="sol_solicitacaoJB" property="page" value="${pageContext}"/>                                         
${sol_solicitacaoJB.execute}                                         
{"resultado":
{"msg":"${sol_solicitacaoJB.msg}",
     "sol_solicitacao":{	"sol_nr_id":"${sol_solicitacaoJB.sol_solicitacaoT.sol_nr_id}"
 ,	"col_nr_id":"${sol_solicitacaoJB.sol_solicitacaoT.col_nr_id}"
 ,	"cot_nr_id":"${sol_solicitacaoJB.sol_solicitacaoT.cot_nr_id}"
 ,	"set_nr_id":"${sol_solicitacaoJB.sol_solicitacaoT.set_nr_id}"
 ,	"ser_nr_id":"${sol_solicitacaoJB.sol_solicitacaoT.ser_nr_id}"
 ,	"sol_dt_datahora":"<fmt:formatDate value="${sol_solicitacaoJB.sol_solicitacaoT.sol_dt_datahora}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"sol_tx_idterminal":"${sol_solicitacaoJB.sol_solicitacaoT.sol_tx_idterminal}"
 ,	"sol_nr_quantidade":"${sol_solicitacaoJB.sol_solicitacaoT.sol_nr_quantidade}"
  }
    }
     
}                                                                                
   
