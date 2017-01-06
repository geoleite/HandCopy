<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sec_setor_colaboradorJB" class="br.com.handcopy.jb.Sec_setor_colaboradorConsultJB" scope="request"/>                                         
<jsp:setProperty name="sec_setor_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="sec_setor_colaboradorJB" property="page" value="${pageContext}"/>                                         
${sec_setor_colaboradorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${sec_setor_colaboradorJB.list}" var="item">
     ,{	"set_nr_id":"${item.set_nr_id}"
 ,	"col_nr_id":"${item.col_nr_id}"
 ,	"sec_dt_alocado":"<fmt:formatDate value="${item.sec_dt_alocado}" pattern="dd/MM/yyyy"/>"
  }
</c:forEach>
]}                                                                                
   
