<jsp:useBean id="sol" class="br.com.handcopy.relatorio.Rel_TicketSolicitacao" scope="request"/>
<jsp:setProperty name="sol" property="*"/>
<jsp:setProperty name="sol" property="page" value="${pageContext}"/>
${sol.execute}