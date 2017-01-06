<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="can_porJB" class="br.com.easynet.portal.jb.Can_porUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="can_porJB" property="*"/>                                         
<jsp:setProperty name="can_porJB" property="page" value="${pageContext}"/>                                         
${can_porJB.execute}                                         
                                          
<html>                                         
    <head>                                         
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">                                         
        <title>Page Update and Delete Generate By EasyNet </title>
	<link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        <script src="easyajax.js"></script>

	                                  
    </head>                                         
    <body>                                         

    <h1>Generate Page Automatic for Update and Delete br.com.easynet.portal.jb.Can_porUpdateDeleteJB</h1>                                         

<form action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="can_canalConsult.jsp"/>
    <input type="hidden" name="urlCanal" value="can_canalUpdateDelete.jsp"/>
    <center>     
     	<label class="errorMessage">${can_porJB.msg}</label><br/>

    <label>por_nr_id:</label><input type="text" name="can_porT.por_nr_id" value="${can_porJB.can_porT.por_nr_id}"/>  <br/>
<label>can_nr_id:</label><input type="text" name="can_porT.can_nr_id" value="${can_porJB.can_porT.can_nr_id}"/>  <br/>
<label>cp_nr_ordem:</label><input type="text" name="can_porT.cp_nr_ordem" value="${can_porJB.can_porT.cp_nr_ordem}"/>  <br/>

    
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
