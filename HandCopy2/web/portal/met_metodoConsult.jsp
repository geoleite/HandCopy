<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="met_metodoJB" class="br.com.easynet.easyportal.jb.Met_metodoConsultJB" scope="request"/>                                         
<jsp:setProperty name="met_metodoJB" property="*"/>                                         
<jsp:setProperty name="met_metodoJB" property="page" value="${pageContext}"/>                                         
${met_metodoJB.execute}                                         

<form name="met_metodo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="met_metodoConsult.jsp"/>
    <input type="hidden" name="ope_operacaoT.sis_nr_id" value="${met_metodoJB.sis_sistemaT.sis_nr_id}"/>
    <input type="hidden" name="ope_operacaoT.ope_nr_id" value="${met_metodoJB.ope_operacaoT.ope_nr_id}"/>
    
    <center>     
        <h3 align="left">Métodos</h3>
        <label class="errorMessage" align="center">${met_metodoJB.msg} </label><br/>
        <label>Sistema</label>${met_metodoJB.sis_sistemaT.sis_tx_nome}<br/>
        <label>Operação</label>${met_metodoJB.ope_operacaoT.ope_tx_nome}<br/>
        <label>Classe:    </label>${met_metodoJB.ope_operacaoT.ope_tx_classe}
        <br/>
        <input type="button" value="New" onClick="setOpPortal('met_metodo','', 'met_metodoInsert.jsp')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOpPortal('met_metodo','consult', 'met_metodoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
    
    <hr/> 
    <h2 align="center">Métodos</h2>
    <center>	
        <display:table class="tabela" cellpadding="5" cellspacing="0" id="item" name="${met_metodoJB.list}"  pagesize="10" >
            <display:column sortable="false" title="Método" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
                    <c:out value="${item.met_tx_metodo}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Status" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=met_metodoUpdateDelete.jsp&op=findbyid&met_metodoT.met_nr_id=${item.met_nr_id}&">
                    <c:out value="${item.met_tx_status=='A'?'Ativo':'Inativo'}"/>
                </a>
            </display:column>
            <display:column title="Apagar">
                    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=met_metodoConsult.jsp&op=delete&met_metodoT.met_nr_id=${item.met_nr_id}&ope_operacaoT.sis_nr_id=${met_metodoJB.sis_sistemaT.sis_nr_id}&ope_operacaoT.ope_nr_id=${met_metodoJB.ope_operacaoT.ope_nr_id}">
                        <img border="0" src="../images/delete.png">
                    </a>
            </display:column>	
        </display:table>
    </center>	
    
</form>           

