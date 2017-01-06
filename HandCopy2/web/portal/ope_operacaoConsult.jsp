<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ope_operacaoJB" class="br.com.easynet.easyportal.jb.Ope_operacaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ope_operacaoJB" property="*"/>                                         
<jsp:setProperty name="ope_operacaoJB" property="page" value="${pageContext}"/>                                         
${ope_operacaoJB.execute}                                         
                                                                       
<form name="ope_operacao" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="ope_operacaoConsult.jsp"/>
    
    <center>     
        <label class="errorMessage" align="center">${ope_operacaoJB.msg} </label>
        <br/>
        <input type="hidden" name="ope_operacaoT.sis_nr_id" value="${ope_operacaoJB.sis_sistemaT.sis_nr_id}"/>
        <label>Sistema:</label>${ope_operacaoJB.sis_sistemaT.sis_tx_nome}     <br/><br/>
        <input type="button" value="New" onClick="setOpPortal('ope_operacao','', 'ope_operacaoInsert.jsp')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOpPortal('ope_operacao','consult', 'ope_operacaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
    
    <hr/> 
    <h2 align="center">Operações</h2>
    <center>	
        <display:table class="tabela" cellpadding="5" cellspacing="0" id="item" name="${ope_operacaoJB.list}"  pagesize="20" >
            
            <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
                    <c:out value="${item.ope_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Status" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
                    <c:out value="${item.ope_tx_status=='A'?'Ativo':'Inativo'}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Url" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
                    <c:out value="${item.ope_tx_url}"/>
                </a>
            </display:column>
            
            <display:column sortable="false" title="Classe" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=ope_operacaoUpdateDelete.jsp&op=findbyid&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
                    <c:out value="${item.ope_tx_classe}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=met_metodoConsult.jsp&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
                    Métodos
                </a>
            </display:column>
            <display:column title="Apagar">
                <center>
                    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=ope_operacaoConsult.jsp&op=delete&ope_operacaoT.ope_nr_id=${item.ope_nr_id}&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
                        <img border="0" src="../images/delete.png">
                    </a>
                </center>
            </display:column>	
        </display:table>
    </center>	
    
</form>           
