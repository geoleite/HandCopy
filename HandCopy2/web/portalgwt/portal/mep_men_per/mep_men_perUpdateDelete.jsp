<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="mep_men_perJB" class="br.com.i9.portal.jb.Mep_men_perUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="mep_men_perJB" property="*"/>                                         
<jsp:setProperty name="mep_men_perJB" property="page" value="${pageContext}"/>                                         
${mep_men_perJB.execute}                                         
                                                                                

<form name="mep_men_per" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/mep_men_per/mep_men_perUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${mep_men_perJB.tipoMsg}">${mep_men_perJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('mep_men_per', 'update' , '/portal/portal/mep_men_per/mep_men_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('mep_men_per', 'delete' , '/portal/portal/mep_men_per/mep_men_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('mep_men_per', 'consult', '/portal/portal/mep_men_per/mep_men_perConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('mep_men_per', 'consult' , '/portal/portal/mep_men_per/mep_men_perConsult.jsp')" /-->

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
	    <select name="mep_men_perT.per_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${mep_men_perJB.listper_perfil}" var="item">
            	  <option value="${item.per_nr_id}">${item.per_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>men_nr_id:</label>
	</td>
	<td>
	    <select name="mep_men_perT.men_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${mep_men_perJB.listmen_menu}" var="item">
            	  <option value="${item.men_nr_id}">${item.men_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('mep_men_per', 'update' , '/portal/portal/mep_men_per/mep_men_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('mep_men_per', 'delete' , '/portal/portal/mep_men_per/mep_men_perUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('mep_men_per', 'consult', '/portal/portal/mep_men_per/mep_men_perConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('mep_men_per', 'consult' , '/portal/portal/mep_men_per/mep_men_perConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
