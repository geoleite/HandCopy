<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="pi_per_intJB" class="br.com.easynet.easyportal.jb.Pi_per_intConsultJB" scope="request"/>                                         
<jsp:setProperty name="pi_per_intJB" property="*"/>                                         
<jsp:setProperty name="pi_per_intJB" property="page" value="${pageContext}"/>                                         
${pi_per_intJB.execute}                                         
                                                                                

<form name="pi_per_int" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portalgwt/portal/pi_per_int/pi_per_intConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${pi_per_intJB.tipoMsg}">${pi_per_intJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('pi_per_int','', '/portalgwt/portal/pi_per_int/pi_per_intInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('pi_per_int','consult', '/portalgwt/portal/pi_per_int/pi_per_intConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${pi_per_intJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Int_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/pi_per_int/pi_per_intUpdateDelete.jsp&op=findbyid&pi_per_intT.int_nr_id=${item.int_nr_id}&pi_per_intT.per_nr_id=${item.per_nr_id}&">
      		<c:out value="${item.int_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Per_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/pi_per_int/pi_per_intUpdateDelete.jsp&op=findbyid&pi_per_intT.int_nr_id=${item.int_nr_id}&pi_per_intT.per_nr_id=${item.per_nr_id}&">
      		<c:out value="${item.per_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('pi_per_int','delete', '/portalgwt/portal/pi_per_int/pi_per_intConsult.jsp?pi_per_intT.int_nr_id=${item.int_nr_id}&pi_per_intT.per_nr_id=${item.per_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
