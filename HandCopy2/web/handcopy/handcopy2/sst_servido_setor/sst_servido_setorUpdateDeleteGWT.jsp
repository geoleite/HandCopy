<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sst_servido_setorJB" class="br.com.handcopy.jb.Sst_servido_setorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="sst_servido_setorJB" property="*"/>                                         
<jsp:setProperty name="sst_servido_setorJB" property="page" value="${pageContext}"/>                                         
${sst_servido_setorJB.execute}                                         
{"resultado":
{"msg":"${sst_servido_setorJB.msg}",
     "sst_servido_setor":{	"set_nr_id":"${sst_servido_setorJB.sst_servido_setorT.set_nr_id}"
 ,	"ser_nr_id":"${sst_servido_setorJB.sst_servido_setorT.ser_nr_id}"
  }
    }
     
}                                                                                
   
