<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="set_setorJB" class="br.com.handcopy.jb.Set_setorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="set_setorJB" property="*"/>                                         
<jsp:setProperty name="set_setorJB" property="page" value="${pageContext}"/>                                         
${set_setorJB.execute}                                         
{"resultado":
{"msg":"${set_setorJB.msg}",
     "set_setor":{	"set_nr_id":"${set_setorJB.set_setorT.set_nr_id}"
 ,	"set_tx_nome":"${set_setorJB.set_setorT.set_tx_nome}"
 ,	"set_tx_status":"${set_setorJB.set_setorT.set_tx_status}"
 ,	"set_nr_idsetorpai":"${set_setorJB.set_setorT.set_nr_idsetorpai}"
  }
    }
     
}                                                                                
   
