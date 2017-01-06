<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_col_colaboradorJB" class="br.com.handcopy.jb.Vw_col_colaboradorConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_col_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="vw_col_colaboradorJB" property="page" value="${pageContext}"/>                                         
${vw_col_colaboradorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_col_colaboradorJB.list}" var="item">
     ,{	"col_tx_nome":"${item.col_tx_nome}"
 ,	"col_tx_login":"${item.col_tx_login}"
 ,	"col_tx_status":"${item.col_tx_status}"
 ,	"col_tx_email":"${item.col_tx_email}"
 ,	"col_nr_id":"${item.col_nr_id}"
  }
</c:forEach>
]}                                                                                
   
