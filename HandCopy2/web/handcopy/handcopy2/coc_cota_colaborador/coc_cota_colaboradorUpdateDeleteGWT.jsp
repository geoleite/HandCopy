<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="coc_cota_colaboradorJB" class="br.com.handcopy.jb.Coc_cota_colaboradorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="coc_cota_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="coc_cota_colaboradorJB" property="page" value="${pageContext}"/>                                         
${coc_cota_colaboradorJB.execute}                                         
{"resultado":
{"msg":"${coc_cota_colaboradorJB.msg}",
     "coc_cota_colaborador":{	"col_nr_id":"${coc_cota_colaboradorJB.coc_cota_colaboradorT.col_nr_id}"
 ,	"cot_nr_id":"${coc_cota_colaboradorJB.coc_cota_colaboradorT.cot_nr_id}"
 ,	"set_nr_id":"${coc_cota_colaboradorJB.coc_cota_colaboradorT.set_nr_id}"
 ,	"ser_nr_id":"${coc_cota_colaboradorJB.coc_cota_colaboradorT.ser_nr_id}"
 ,	"coc_nr_saldo":"${coc_cota_colaboradorJB.coc_cota_colaboradorT.coc_nr_saldo}"
  }
    }
     
}                                                                                
   
