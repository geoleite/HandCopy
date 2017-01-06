<jsp:useBean id="principalPageJB" class="br.com.easynet.portal.jb.ExemploUploadJB" scope="request"/>                                         
<jsp:setProperty name="principalPageJB" property="*"/>                                         
<jsp:setProperty name="principalPageJB" property="page" value="${pageContext}"/>                                         
${principalPageJB.execute}                                         
                                                                             
<form name="up" action="portal.jsp" method="post" enctype="multipart/form-data" > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="exemploupload.jsp"/>
    
    <center>     
        <input type="text" name="upt.codigo" value="1" /> 
        <input type="file" name="upt.anexo" /> 
        <input type="button" value="Cadastrar" onclick="setOpPortal('up', 'cadastrar', 'exemploupload.jsp')"/>
    </center>     
</form>       