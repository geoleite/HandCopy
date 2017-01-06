<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sec_setor_colaboradorJB" class="br.com.handcopy.jb.Sec_setor_colaboradorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="sec_setor_colaboradorJB" property="*"/>                                         
<jsp:setProperty name="sec_setor_colaboradorJB" property="page" value="${pageContext}"/>                                         
${sec_setor_colaboradorJB.execute}                                         
{"resultado":
{"msg":"${sec_setor_colaboradorJB.msg}",
     "sec_setor_colaborador":{	"set_nr_id":"${sec_setor_colaboradorJB.sec_setor_colaboradorT.set_nr_id}"
 ,	"col_nr_id":"${sec_setor_colaboradorJB.sec_setor_colaboradorT.col_nr_id}"
 ,	"sec_dt_alocado":"<fmt:formatDate value="${sec_setor_colaboradorJB.sec_setor_colaboradorT.sec_dt_alocado}" pattern="dd/MM/yyyy"/>"
  }
    }
     
}                                                                                
   
