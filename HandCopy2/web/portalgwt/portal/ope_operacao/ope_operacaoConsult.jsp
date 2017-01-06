<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ope_operacaoJB" class="br.com.i9.portal.jb.Ope_operacaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ope_operacaoJB" property="*"/>                                         
<jsp:setProperty name="ope_operacaoJB" property="page" value="${pageContext}"/>                                         
${ope_operacaoJB.execute}                                         
                                                                                

<form name="ope_operacao" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/ope_operacao/ope_operacaoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${ope_operacaoJB.tipoMsg}">${ope_operacaoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('ope_operacao','', '/portal/portal/ope_operacao/ope_operacaoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('ope_operacao','consult', '/portal/portal/ope_operacao/ope_operacaoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ope_operacaoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ope_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/ope_operacao/ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.ope_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sis_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/ope_operacao/ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.sis_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ope_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/ope_operacao/ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.ope_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ope_tx_status" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/ope_operacao/ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.ope_tx_status}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ope_tx_url" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/ope_operacao/ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.ope_tx_url}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ope_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/ope_operacao/ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.ope_tx_descricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ope_tx_classe" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/ope_operacao/ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.ope_tx_classe}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('ope_operacao','delete', '/portal/portal/ope_operacao/ope_operacaoConsult.jsp?ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
