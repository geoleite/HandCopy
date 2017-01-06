<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="int_interfaceJB" class="br.com.easynet.easyportal.jb.Int_interfaceInsertJB" scope="request"/>                                         
<jsp:setProperty name="int_interfaceJB" property="*"/>                                         
<jsp:setProperty name="int_interfaceJB" property="page" value="${pageContext}"/>                                         
${int_interfaceJB.execute}                                         
                                                                               
	
<form name="int_interface" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portalgwt/portal/int_interface/int_interfaceInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${int_interfaceJB.tipoMsg}">${int_interfaceJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('int_interface','insert', '/portalgwt/portal/int_interface/int_interfaceInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('int_interface','Limpar', '/portalgwt/portal/int_interface/int_interfaceInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('int_interface','', '/portalgwt/portal/int_interface/int_interfaceConsult.jsp')" />
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
	<td class="ms-standardheader">
		int_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="int_interfaceT.int_tx_nome" value="${int_interfaceJB.int_interfaceT.int_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('int_interface','insert', '/portalgwt/portal/int_interface/int_interfaceInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('int_interface','Limpar', '/portalgwt/portal/int_interface/int_interfaceInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('int_interface','', '/portalgwt/portal/int_interface/int_interfaceConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
