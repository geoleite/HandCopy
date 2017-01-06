<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="col_colaboradorJB" class="br.com.handcopy.jb.Col_colaboradorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="col_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="col_colaboradorJB" property="page" value="${pageContext}"/>                                         
${col_colaboradorJB.execute}                                         
{"resultado":
{"msg":"${col_colaboradorJB.msg}",
     "col_colaborador":{	"col_nr_id":"${col_colaboradorJB.col_colaboradorT.col_nr_id}"
 ,	"sca_nr_id":"${col_colaboradorJB.col_colaboradorT.sca_nr_id}"
  }
    }
     
}                                                                                
   
