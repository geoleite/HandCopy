<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cot_cotaJB" class="br.com.handcopy.jb.Cot_cotaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cot_cotaJB" property="*"/>                                         
<jsp:setProperty name="cot_cotaJB" property="page" value="${pageContext}"/>                                         
${cot_cotaJB.execute}                                         
{"resultado":
{"msg":"${cot_cotaJB.msg}",
     "cot_cota":{	"cot_nr_id":"${cot_cotaJB.cot_cotaT.cot_nr_id}"
 ,	"set_nr_id":"${cot_cotaJB.cot_cotaT.set_nr_id}"
 ,	"ser_nr_id":"${cot_cotaJB.cot_cotaT.ser_nr_id}"
 ,	"cot_nr_saldo":"${cot_cotaJB.cot_cotaT.cot_nr_saldo}"
  }
    }
     
}                                                                                
   
