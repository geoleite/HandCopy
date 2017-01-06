<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="logJB" class="br.com.i9.portal.jb.LogConsultJB" scope="request"/>                                         
<jsp:setProperty name="logJB" property="*"/>                                         
<jsp:setProperty name="logJB" property="page" value="${pageContext}"/>                                         
${logJB.execute}                                         
                                                                                

<form name="log" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/log/logConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${logJB.tipoMsg}">${logJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('log','', '/portal/portal/log/logInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('log','consult', '/portal/portal/log/logConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${logJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Log_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_tx_sistema" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_tx_sistema}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_tx_classe" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_tx_classe}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_tx_metodo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_tx_metodo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_tx_usuario" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_tx_usuario}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_dt_datahora" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<fmt:formatDate value="${item.log_dt_datahora}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_tx_status" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_tx_status}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_tx_ip" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_tx_ip}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Log_tx_parametros" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/log/logUpdateDelete.jsp&op=findbyid&logT.log_nr_id=${item.log_nr_id}&">
      		<c:out value="${item.log_tx_parametros}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('log','delete', '/portal/portal/log/logConsult.jsp?logT.log_nr_id=${item.log_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
