<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sol_solicitacaoJB" class="br.com.handcopy.jb.Sol_solicitacaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="sol_solicitacaoJB" property="*"/>                                         
<jsp:setProperty name="sol_solicitacaoJB" property="page" value="${pageContext}"/>                                         
${sol_solicitacaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${sol_solicitacaoJB.list}" var="item">
     ,{	"sol_nr_id":"${item.sol_nr_id}"
 ,	"col_nr_id":"${item.col_nr_id}"
 ,	"cot_nr_id":"${item.cot_nr_id}"
 ,	"set_nr_id":"${item.set_nr_id}"
 ,	"ser_nr_id":"${item.ser_nr_id}"
 ,	"sol_dt_datahora":"<fmt:formatDate value="${item.sol_dt_datahora}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"sol_tx_idterminal":"${item.sol_tx_idterminal}"
 ,	"sol_nr_quantidade":"${item.sol_nr_quantidade}"
  }
</c:forEach>
]}                                                                                
   
