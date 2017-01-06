<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_col_colaboradorJB" class="br.com.handcopy.jb.Vw_col_colaboradorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_col_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="vw_col_colaboradorJB" property="page" value="${pageContext}"/>                                         
${vw_col_colaboradorJB.execute}                                         
{"resultado":
{"msg":"${vw_col_colaboradorJB.msg}",
     "vw_col_colaborador":{	"col_tx_nome":"${vw_col_colaboradorJB.vw_col_colaboradorT.col_tx_nome}"
 ,	"col_tx_login":"${vw_col_colaboradorJB.vw_col_colaboradorT.col_tx_login}"
 ,	"col_tx_status":"${vw_col_colaboradorJB.vw_col_colaboradorT.col_tx_status}"
 ,	"col_tx_email":"${vw_col_colaboradorJB.vw_col_colaboradorT.col_tx_email}"
 ,	"col_nr_id":"${vw_col_colaboradorJB.vw_col_colaboradorT.col_nr_id}"
  }
    }
     
}                                                                                
   
