<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="opm_met_ope_perJB" class="br.com.i9.portal.jb.Opm_met_ope_perUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="opm_met_ope_perJB" property="*"/>                                         
<jsp:setProperty name="opm_met_ope_perJB" property="page" value="${pageContext}"/>                                         
${opm_met_ope_perJB.execute}                                         
                                                                                

<form name="opm_met_ope_per" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${opm_met_ope_perJB.tipoMsg}">${opm_met_ope_perJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('opm_met_ope_per', 'update' , '/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('opm_met_ope_per', 'delete' , '/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('opm_met_ope_per', 'consult', '/portal/portal/opm_met_ope_per/opm_met_ope_perConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('opm_met_ope_per', 'consult' , '/portal/portal/opm_met_ope_per/opm_met_ope_perConsult.jsp')" /-->

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
		<label>per_nr_id:</label>
	</td>
	<td>
	    <select name="opm_met_ope_perT.per_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${opm_met_ope_perJB.listper_perfil}" var="item">
            	  <option value="${item.per_nr_id}">${item.per_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>ope_nr_id:</label>
	</td>
	<td>
	    <select name="opm_met_ope_perT.ope_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${opm_met_ope_perJB.listope_operacao}" var="item">
            	  <option value="${item.ope_nr_id}">${item.ope_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>sis_nr_id:</label>
	</td>
	<td>
	    <select name="opm_met_ope_perT.sis_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${opm_met_ope_perJB.listope_operacao}" var="item">
            	  <option value="${item.sis_nr_id}">${item.sis_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>met_nr_id:</label>
	</td>
	<td>
	    <select name="opm_met_ope_perT.met_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${opm_met_ope_perJB.listmet_metodo}" var="item">
            	  <option value="${item.met_nr_id}">${item.met_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('opm_met_ope_per', 'update' , '/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('opm_met_ope_per', 'delete' , '/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('opm_met_ope_per', 'consult', '/portal/portal/opm_met_ope_per/opm_met_ope_perConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('opm_met_ope_per', 'consult' , '/portal/portal/opm_met_ope_per/opm_met_ope_perConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
