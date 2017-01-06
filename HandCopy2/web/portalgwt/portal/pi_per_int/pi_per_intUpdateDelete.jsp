<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="pi_per_intJB" class="br.com.easynet.easyportal.jb.Pi_per_intUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pi_per_intJB" property="*"/>                                         
<jsp:setProperty name="pi_per_intJB" property="page" value="${pageContext}"/>                                         
${pi_per_intJB.execute}                                         
                                                                                

<form name="pi_per_int" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portalgwt/portal/pi_per_int/pi_per_intUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${pi_per_intJB.tipoMsg}">${pi_per_intJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pi_per_int', 'update' , '/portalgwt/portal/pi_per_int/pi_per_intUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('pi_per_int', 'delete' , '/portalgwt/portal/pi_per_int/pi_per_intUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pi_per_int', 'consult', '/portalgwt/portal/pi_per_int/pi_per_intConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('pi_per_int', 'consult' , '/portalgwt/portal/pi_per_int/pi_per_intConsult.jsp')" /-->

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
	<td>
		<label>int_nr_id:</label>
	</td>
	<td>
	    <select name="pi_per_intT.int_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pi_per_intJB.listint_interface}" var="item">
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
	    <select name="pi_per_intT.per_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pi_per_intJB.listper_perfil}" var="item">
            	  <option value="${item.per_nr_id}">${item.per_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pi_per_int', 'update' , '/portalgwt/portal/pi_per_int/pi_per_intUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('pi_per_int', 'delete' , '/portalgwt/portal/pi_per_int/pi_per_intUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pi_per_int', 'consult', '/portalgwt/portal/pi_per_int/pi_per_intConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('pi_per_int', 'consult' , '/portalgwt/portal/pi_per_int/pi_per_intConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
