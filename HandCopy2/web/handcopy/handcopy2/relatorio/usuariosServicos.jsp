<jsp:useBean id="usuSOl" class="br.com.handcopy.relatorio.UsuariosSolicitacoesREL" scope="request"/>
<jsp:setProperty name="usuSOl" property="*"/>
<jsp:setProperty name="usuSOl" property="page" value="${pageContext}"/>
${usuSOl.execute}
