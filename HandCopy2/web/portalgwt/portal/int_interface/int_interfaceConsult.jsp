<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="int_interfaceJB" class="br.com.easynet.easyportal.jb.Int_interfaceConsultJB" scope="request"/>                                         
<jsp:setProperty name="int_interfaceJB" property="*"/>                                         
<jsp:setProperty name="int_interfaceJB" property="page" value="${pageContext}"/>                                         
${int_interfaceJB.execute}                                         
                                                                                

<form name="int_interface" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portalgwt/portal/int_interface/int_interfaceConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${int_interfaceJB.tipoMsg}">${int_interfaceJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('int_interface','', '/portalgwt/portal/int_interface/int_interfaceInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('int_interface','consult', '/portalgwt/portal/int_interface/int_interfaceConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${int_interfaceJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Int_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/int_interface/int_interfaceUpdateDelete.jsp&op=findbyid&int_interfaceT.int_nr_id=${item.int_nr_id}&">
      		<c:out value="${item.int_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Int_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/int_interface/int_interfaceUpdateDelete.jsp&op=findbyid&int_interfaceT.int_nr_id=${item.int_nr_id}&">
      		<c:out value="${item.int_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('int_interface','delete', '/portalgwt/portal/int_interface/int_interfaceConsult.jsp?int_interfaceT.int_nr_id=${item.int_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
