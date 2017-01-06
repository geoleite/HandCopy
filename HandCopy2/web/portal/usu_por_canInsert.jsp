<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="usu_por_canJB" class="br.com.easynet.portal.jb.Usu_por_canInsertJB" scope="request"/>                                         
<jsp:setProperty name="usu_por_canJB" property="*"/>                                         
<jsp:setProperty name="usu_por_canJB" property="page" value="${pageContext}"/>                                         
${usu_por_canJB.execute}                                         
                                          
<html>                                         
    <head>                                         
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">                                         
        <title>Page Insert Generate By EasyNet</title>
	<link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        <script src="easyajax.js"></script>

	<script>
          var className = "br.com.easynet.portal.jb.Usu_por_canInsertJB";
	  function insertAjax() {
	    var xml = getResponse(className, "insert");            
            /*	   
		|COMMANDS|
	    */
 	  }
	  function findByIdAjax(id) {
	    var xml = getResponseParam(className, "findbyid", id);            
            /*	   
		|COMMANDS|
	    */
 	  }
	  function updateAjax(id) {
	    var xml = getResponse(className, "update");  
            /*	   
		|COMMANDS|
	    */
 	  }
	  function deleteAjax() {
	    var xml = getResponse(className, "delete");            
            /*	   
		|COMMANDS|
	    */
 	  }

          // Limpa os campos do formulário
	  function clear() {
	    clearFields();
          }

	</script>                                         
    </head>                                         
    <body>                                         

    <h1>Generate Page Automatic for Insert br.com.easynet.portal.jb.Usu_por_canInsertJB</h1>                                         
	<label class="errorMessage" align="center">${usu_por_canJB.msg} </label>
<form action="usu_por_canInsert.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <center>     
     	<label class="errorMessage">${usu_por_canJB.msg}</label><br/>

    <label>usu_nr_id:</label><input type="text" name="usu_por_canT.usu_nr_id" value="${usu_por_canJB.usu_por_canT.usu_nr_id}"/>  <br/>
<label>por_nr_id:</label><input type="text" name="usu_por_canT.por_nr_id" value="${usu_por_canJB.usu_por_canT.por_nr_id}"/>  <br/>
<label>can_nr_id:</label><input type="text" name="usu_por_canT.can_nr_id" value="${usu_por_canJB.usu_por_canT.can_nr_id}"/>  <br/>
<label>upc_tx_status:</label><input type="text" name="usu_por_canT.upc_tx_status" value="${usu_por_canJB.usu_por_canT.upc_tx_status}"/>  <br/>
<label>upc_nr_ordem:</label><input type="text" name="usu_por_canT.upc_nr_ordem" value="${usu_por_canJB.usu_por_canT.upc_nr_ordem}"/>  <br/>

    
	<br/>
    <input type="button" value="Insert"  onClick="setOp('insert')" /> &nbsp;&nbsp;&nbsp;
    <input type="reset"  value="Clear" onclick="setOp('clear')"/>
    <input type="button" value="Cancel"  onClick="history.go(-1)" />
    </center>     
	
    
</form>
    </body>
</html>
