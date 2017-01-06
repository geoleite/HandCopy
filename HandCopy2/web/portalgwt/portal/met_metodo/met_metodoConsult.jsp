<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="met_metodoJB" class="br.com.i9.portal.jb.Met_metodoConsultJB" scope="request"/>                                         
<jsp:setProperty name="met_metodoJB" property="*"/>                                         
<jsp:setProperty name="met_metodoJB" property="page" value="${pageContext}"/>                                         
${met_metodoJB.execute}                                         
                                                                                

<form name="met_metodo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/met_metodo/met_metodoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${met_metodoJB.tipoMsg}">${met_metodoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('met_metodo','', '/portal/portal/met_metodo/met_metodoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('met_metodo','consult', '/portal/portal/met_metodo/met_metodoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${met_metodoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ope_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/met_metodo/met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.ope_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Met_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/met_metodo/met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.met_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Met_tx_metodo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/met_metodo/met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.met_tx_metodo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Met_tx_status" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/met_metodo/met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.met_tx_status}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sis_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/met_metodo/met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.sis_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Met_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/met_metodo/met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.met_tx_descricao}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('met_metodo','delete', '/portal/portal/met_metodo/met_metodoConsult.jsp?met_metodoT.met_nr_id=${item.met_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
