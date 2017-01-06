<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="coc_cota_colaboradorJB" class="br.com.handcopy.jb.Coc_cota_colaboradorConsultJB" scope="request"/>                                         
<jsp:setProperty name="coc_cota_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="coc_cota_colaboradorJB" property="page" value="${pageContext}"/>                                         
${coc_cota_colaboradorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${coc_cota_colaboradorJB.list}" var="item">
     ,{	"col_nr_id":"${item.col_nr_id}"
 ,	"cot_nr_id":"${item.cot_nr_id}"
 ,	"set_nr_id":"${item.set_nr_id}"
 ,	"ser_nr_id":"${item.ser_nr_id}"
 ,	"coc_nr_saldo":"${item.coc_nr_saldo}"
  }
</c:forEach>
]}                                                                                
   
