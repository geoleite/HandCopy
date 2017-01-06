<jsp:useBean id="usuSOl" class="br.com.handcopy.relatorio.Rel_UsuariosRequisicoes" scope="request"/>
<jsp:setProperty name="usuSOl" property="*"/>
<jsp:setProperty name="usuSOl" property="page" value="${pageContext}"/>
${usuSOl.execute}
