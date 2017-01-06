<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="con_componente_negadoJB" class="br.com.easynet.easyportal.jb.Con_componente_negadoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="con_componente_negadoJB" property="*"/>                                         
<jsp:setProperty name="con_componente_negadoJB" property="page" value="${pageContext}"/>                                         
${con_componente_negadoJB.execute}                                         
                                                                                

<form name="con_componente_negado" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${con_componente_negadoJB.tipoMsg}">${con_componente_negadoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('con_componente_negado', 'update' , '/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('con_componente_negado', 'delete' , '/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('con_componente_negado', 'consult', '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('con_componente_negado', 'consult' , '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
<br/>
<table width="600" align="left" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
    <table align="left" border="0" width="50%">
    		     <tr>
	<td class="ms-standardheader">
		con_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="con_componente_negadoT.con_nr_id" value="${con_componente_negadoJB.con_componente_negadoT.con_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>int_nr_id:</label>
	</td>
	<td>
	    <select name="con_componente_negadoT.int_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${con_componente_negadoJB.listpi_per_int}" var="item">
            	  <option value="${item.int_nr_id}">${item.int_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>per_nr_id:</label>
	</td>
	<td>
	    <select name="con_componente_negadoT.per_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${con_componente_negadoJB.listpi_per_int}" var="item">
            	  <option value="${item.per_nr_id}">${item.per_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		con_tx_visivel:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="con_componente_negadoT.con_tx_visivel" value="${con_componente_negadoJB.con_componente_negadoT.con_tx_visivel}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		con_tx_ativo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="con_componente_negadoT.con_tx_ativo" value="${con_componente_negadoJB.con_componente_negadoT.con_tx_ativo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('con_componente_negado', 'update' , '/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('con_componente_negado', 'delete' , '/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('con_componente_negado', 'consult', '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('con_componente_negado', 'consult' , '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
