<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="set_setorJB" class="br.com.handcopy.jb.Set_setorConsultJB" scope="request"/>                                         
<jsp:setProperty name="set_setorJB" property="*"/>                                         
<jsp:setProperty name="set_setorJB" property="page" value="${pageContext}"/>                                         
${set_setorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${set_setorJB.list}" var="item">
     ,{	"set_nr_id":"${item.set_nr_id}"
 ,	"set_tx_nome":"${item.set_tx_nome}"
 ,	"set_tx_status":"${item.set_tx_status}"
 ,	"set_nr_idsetorpai":"${item.set_nr_idsetorpai}"
  }
</c:forEach>
]}                                                                                
   
