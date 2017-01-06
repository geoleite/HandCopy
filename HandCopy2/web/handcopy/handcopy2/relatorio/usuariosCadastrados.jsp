<jsp:useBean id="usuCad" class="br.com.handcopy.relatorio.Rel_UsuariosCadastrados" scope="request"/>
<jsp:setProperty name="usuCad" property="*"/>
<jsp:setProperty name="usuCad" property="page" value="${pageContext}"/>
${usuCad.execute}