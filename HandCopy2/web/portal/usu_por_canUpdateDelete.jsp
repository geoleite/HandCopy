<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="usu_por_canJB" class="br.com.easynet.portal.jb.Usu_por_canUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="usu_por_canJB" property="*"/>                                         
<jsp:setProperty name="usu_por_canJB" property="page" value="${pageContext}"/>                                         
${usu_por_canJB.execute}                                         
                                          
<html>                                         
    <head>                                         
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">                                         
        <title>Page Update and Delete Generate By EasyNet </title>
	<link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        <script src="easyajax.js"></script>

	                                  
    </head>                                         
    <body>                                         

    <h1>Generate Page Automatic for Update and Delete br.com.easynet.portal.jb.Usu_por_canUpdateDeleteJB</h1>                                         

<form action="usu_por_canUpdateDelete.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <center>     
     	<label class="errorMessage">${usu_por_canJB.msg}</label><br/>

    <label>usu_nr_id:</label><input type="text" name="usu_por_canT.usu_nr_id" value="${usu_por_canJB.usu_por_canT.usu_nr_id}"/>  <br/>
<label>por_nr_id:</label><input type="text" name="usu_por_canT.por_nr_id" value="${usu_por_canJB.usu_por_canT.por_nr_id}"/>  <br/>
<label>can_nr_id:</label><input type="text" name="usu_por_canT.can_nr_id" value="${usu_por_canJB.usu_por_canT.can_nr_id}"/>  <br/>
<label>upc_tx_status:</label><input type="text" name="usu_por_canT.upc_tx_status" value="${usu_por_canJB.usu_por_canT.upc_tx_status}"/>  <br/>
<label>upc_nr_ordem:</label><input type="text" name="usu_por_canT.upc_nr_ordem" value="${usu_por_canJB.usu_por_canT.upc_nr_ordem}"/>  <br/>

    
	<br/>
    <input type="button" value="Consult" onClick="setOp('consult')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="Update"  onClick="setOp('update')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="Delete"  onClick="setOp('delete')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="Cancel"  onClick="history.go(-1)" />
    <input type="reset"  value="Clear" onclick="setOp('clear')"/>
    </center>     
	
</form>
    </body>
</html>
