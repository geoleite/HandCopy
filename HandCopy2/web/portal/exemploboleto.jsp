<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="exBoletoJB" class="br.com.easynet.jb.ExemploBoletoJB" scope="request"/>                                         
<jsp:setProperty name="exBoletoJB" property="*"/>                                         
<jsp:setProperty name="exBoletoJB" property="page" value="${pageContext}"/>                                         
${exBoletoJB.execute}                                         
                                          
<html>                                         
    <head>                                         
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">                                         
        <title>JSP Page</title>
	<link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        

	                            
    </head>                                         
    <body>                                         

    <h1>Página de exemplo para Geracão de Boleto Bancário</h1>                                         

<form action="exemploboleto.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <center>     
    
	<br/>
    <input type="button" value="Gerar Boleto"  onClick="setOp('gerarBoleto')" /> &nbsp;&nbsp;&nbsp;
    </center>     
	

    
</form>
    </body>
</html>
