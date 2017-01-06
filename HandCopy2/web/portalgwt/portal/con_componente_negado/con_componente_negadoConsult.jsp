<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="con_componente_negadoJB" class="br.com.easynet.easyportal.jb.Con_componente_negadoConsultJB" scope="request"/>                                         
<jsp:setProperty name="con_componente_negadoJB" property="*"/>                                         
<jsp:setProperty name="con_componente_negadoJB" property="page" value="${pageContext}"/>                                         
${con_componente_negadoJB.execute}                                         
                                                                                

<form name="con_componente_negado" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${con_componente_negadoJB.tipoMsg}">${con_componente_negadoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('con_componente_negado','', '/portalgwt/portal/con_componente_negado/con_componente_negadoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('con_componente_negado','consult', '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${con_componente_negadoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Con_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp&op=findbyid&con_componente_negadoT.con_nr_id=${item.con_nr_id}&con_componente_negadoT.int_nr_id=${item.int_nr_id}&con_componente_negadoT.per_nr_id=${item.per_nr_id}&">
      		<c:out value="${item.con_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Int_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp&op=findbyid&con_componente_negadoT.con_nr_id=${item.con_nr_id}&con_componente_negadoT.int_nr_id=${item.int_nr_id}&con_componente_negadoT.per_nr_id=${item.per_nr_id}&">
      		<c:out value="${item.int_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Per_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp&op=findbyid&con_componente_negadoT.con_nr_id=${item.con_nr_id}&con_componente_negadoT.int_nr_id=${item.int_nr_id}&con_componente_negadoT.per_nr_id=${item.per_nr_id}&">
      		<c:out value="${item.per_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Con_tx_visivel" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp&op=findbyid&con_componente_negadoT.con_nr_id=${item.con_nr_id}&con_componente_negadoT.int_nr_id=${item.int_nr_id}&con_componente_negadoT.per_nr_id=${item.per_nr_id}&">
      		<c:out value="${item.con_tx_visivel}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Con_tx_ativo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portalgwt/portal/con_componente_negado/con_componente_negadoUpdateDelete.jsp&op=findbyid&con_componente_negadoT.con_nr_id=${item.con_nr_id}&con_componente_negadoT.int_nr_id=${item.int_nr_id}&con_componente_negadoT.per_nr_id=${item.per_nr_id}&">
      		<c:out value="${item.con_tx_ativo}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('con_componente_negado','delete', '/portalgwt/portal/con_componente_negado/con_componente_negadoConsult.jsp?con_componente_negadoT.con_nr_id=${item.con_nr_id}&con_componente_negadoT.int_nr_id=${item.int_nr_id}&con_componente_negadoT.per_nr_id=${item.per_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
