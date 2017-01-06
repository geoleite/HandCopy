<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="logJB" class="br.com.easynet.easylog.jb.LogConsultJB" scope="request"/>                                         
<jsp:setProperty name="logJB" property="*"/>                                         
<jsp:setProperty name="logJB" property="page" value="${pageContext}"/>                                         
${logJB.execute}                                         
                                                                                

<form name="log" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <div id="layer_calendar" style="position:absolute;top:0;left:0;z-index:100"></div>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/log/logConsult.jsp"/>
    <div align="center">     
        <label class="errorMessage" align="center">${logJB.msg} </label>
        <br/>
        <h3>Campos de Filtro</h3>
        <label>Usuário:</label> <input name="logT.log_tx_usuario" value="${logJB.logT.log_tx_usuario}"/> <br/>
        <label>Sistema:</label> <input name="logT.log_tx_sistema" value="${logJB.logT.log_tx_sistema}"/><br/>
        <label>Classe:</label> <input name="logT.log_tx_classe" value="${logJB.logT.log_tx_classe}"/><br/>
        <label>Método:</label> <input name="logT.log_tx_metodo" value="${logJB.logT.log_tx_metodo}"/><br/>
        <label>Data:</label> <input name="datainicial" value="${logJB.datainicial}"/>
        <img src="../images/btcalendar1.gif" border="0"  onclick="openCalendar(document.log.elements['datainicial'], true)"/>
        <br/>
        <label>Data:</label> <input name="datafinal" value="${logJB.datafinal}"/>
        <img src="../images/btcalendar1.gif" border="0"  onclick="openCalendar(document.log.elements['datafinal'], true)"/>
        <br/>
        <label>Status:</label> 
            <select name="logT.log_tx_status">
                   <option value=""> Todos </option>
                   <option value="S"> OK </option>
                   <option value="N">Erro</option>
            </select>
            <br/>
        <input type="button" value="Filter" onClick="setOpPortal('log','consult', '/portal/portal/log/logConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                
        <hr/> 
        <h3 align="center">Logs</h3>
        
        <display:table class="tabela" cellpadding="0" cellspacing="3" id="item" name="${logJB.list}"  pagesize="50">
            <display:column sortable="false" title="Usuario" >
                <label>
                    <c:out value="${item.log_tx_usuario}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Sistema" >
                <label>
                    <c:out value="${item.log_tx_sistema}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Classe" >
                <label>
                    <c:out value="${item.log_tx_classe}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Método" >
                <label>
                    <c:out value="${item.log_tx_metodo}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Data/Hora" >
                <label>
                    <c:out value="${item.log_dt_datahora}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Origem" >
                <label>
                    <c:out value="${item.log_tx_ip}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="" >
                <table bgcolor="${item.log_tx_status=='S'?'GREEN':'RED'}">
                    <tr><td>&nbsp;</td></tr>
                </table>
            </display:column>
            
        </display:table>
    </div>	
    
</form>

