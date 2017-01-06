<jsp:useBean id="usuSOl" class="br.com.handcopy.relatorio.REL_UsuariosSolicitacoesPeriodo" scope="request"/>
<jsp:setProperty name="usuSOl" property="*"/>
<jsp:setProperty name="usuSOl" property="page" value="${pageContext}"/>
${usuSOl.execute}
