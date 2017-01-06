<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="can_canalConsultJB" class="br.com.easynet.portal.jb.Can_canalConsultJB" scope="request"/>                                         
<jsp:setProperty name="can_canalConsultJB" property="*"/>                                         
<jsp:setProperty name="can_canalConsultJB" property="page" value="${pageContext}"/>                                         
${can_canalConsultJB.execute}                                         
                                     

<h3>Canais</h3>

<form name="can_canal" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="can_canalConsult.jsp"/>
    <center>     
        <label class="errorMessage" align="center">${can_canalConsultJB.msg} </label>
        <br/>
        <input type="button" value="New" onClick="setOpPortal('can_canal', '', 'can_canalInsert.jsp')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOp('consult')"/>&nbsp;&nbsp;&nbsp;
    </center>     
    
    <hr/> 
    <h2 align="center">List</h2>
    <center>	
        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${can_canalConsultJB.list}"  pagesize="10" >
            <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=${item.can_nr_id}&">
                    <c:out value="${item.can_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Descricão" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=${item.can_nr_id}&">
                    <c:out value="${item.can_tx_descricao}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Url" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=${item.can_nr_id}&">
                    <c:out value="${item.can_tx_url}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Status" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=${item.can_nr_id}&">
                    <c:out value="${item.can_tx_status == 'A'?'Ativo':'Inativo'}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Border" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=${item.can_nr_id}&">
                    <c:out value="${item.can_tx_border=='S'?'Sim':'Não'}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Estado" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=${item.can_nr_id}&">
                    <c:out value="${item.can_tx_estado=='NOR'?'Normal':''}"/>
                    <c:out value="${item.can_tx_estado=='MIN'?'Minimizado':''}"/>
                    <c:out value="${item.can_tx_estado=='CLO'?'Fechado':''}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Iframe" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=${item.can_nr_id}&">
                    <c:out value="${item.can_tx_iframe=='S'?'Sim':'Não'}"/>
                </a>
            </display:column>
            
            <display:column title="Apagar">
                <center>
                    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_canalConsult.jsp&op=delete&can_canalT.can_nr_id=${item.can_nr_id}&">
                        <img border="0" src="../images/delete.png">
                    </a>
                </center>
            </display:column>	
        </display:table>
    </center>	
    
</form>
