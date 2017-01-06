<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="con_componente_negadoJB" class="br.com.easynet.easyportal.jb.Con_componente_negadoInsertJB" scope="request"/>                                         
<jsp:setProperty name="con_componente_negadoJB" property="*"/>                                         
<jsp:setProperty name="con_componente_negadoJB" property="page" value="${pageContext}"/>                                         
${con_componente_negadoJB.execute}                                         
                                                                               
	
<form name="con_componente_negado" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portalgwt/portal/con_componente_negado/con_componente_negadoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${con_componente_negadoJB.tipoMsg}">${con_componente_negadoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('con_componente_negado','insert', '/portalgwt/portal/con_componente_negado/con_componente_negadoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('con_componente_negado','Limpar', '/portalgwt/portal/con_componente_negado/con_componente_negadoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('con_componente_negado','', '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp')" />
    </div></td>
  </tr>
</table>
<br/>
<table align="left" width="600" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
	<table align="left" width="50%" border="0">
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
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('con_componente_negado','insert', '/portalgwt/portal/con_componente_negado/con_componente_negadoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('con_componente_negado','Limpar', '/portalgwt/portal/con_componente_negado/con_componente_negadoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('con_componente_negado','', '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
