<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="logJB" class="br.com.easynet.easylog.jb.LogUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="logJB" property="*"/>                                         
<jsp:setProperty name="logJB" property="page" value="${pageContext}"/>                                         
${logJB.execute}                                         
                                                                                

<form name="log" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/log/logUpdateDelete.jsp"/>
    <center>     
     	<label class="errorMessage">${logJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>log_nr_id:</label>
	</td>
	<td>
		<input type="text" name="logT.log_nr_id" value="${logJB.logT.log_nr_id}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>log_tx_sistema:</label>
	</td>
	<td>
		<input type="text" name="logT.log_tx_sistema" value="${logJB.logT.log_tx_sistema}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>log_tx_classe:</label>
	</td>
	<td>
		<input type="text" name="logT.log_tx_classe" value="${logJB.logT.log_tx_classe}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>log_tx_metodo:</label>
	</td>
	<td>
		<input type="text" name="logT.log_tx_metodo" value="${logJB.logT.log_tx_metodo}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>log_dt_datahora:</label>
	</td>
	<td>
		<input type="text" name="logT.log_dt_datahora" value="${logJB.logT.log_dt_datahora}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>log_tx_usuario:</label>
	</td>
	<td>
		<input type="text" name="logT.log_tx_usuario" value="${logJB.logT.log_tx_usuario}"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('log', 'consult', '/portal/portal/log/logConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('log', 'update' , '/portal/portal/log/logUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('log', 'delete' , '/portal/portal/log/logUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('log', 'consult' , '/portal/portal/log/logConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
