<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cot_cotaJB" class="br.com.handcopy.jb.Cot_cotaConsultJB" scope="request"/>                                         
<jsp:setProperty name="cot_cotaJB" property="*"/>                                         
<jsp:setProperty name="cot_cotaJB" property="page" value="${pageContext}"/>                                         
${cot_cotaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cot_cotaJB.list}" var="item">
     ,{	"cot_nr_id":"${item.cot_nr_id}"
 ,	"set_nr_id":"${item.set_nr_id}"
 ,	"ser_nr_id":"${item.ser_nr_id}"
 ,	"cot_nr_saldo":"${item.cot_nr_saldo}"
  }
</c:forEach>
]}                                                                                
   
