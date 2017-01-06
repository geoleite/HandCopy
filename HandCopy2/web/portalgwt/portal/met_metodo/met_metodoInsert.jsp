<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="met_metodoJB" class="br.com.i9.portal.jb.Met_metodoInsertJB" scope="request"/>                                         
<jsp:setProperty name="met_metodoJB" property="*"/>                                         
<jsp:setProperty name="met_metodoJB" property="page" value="${pageContext}"/>                                         
${met_metodoJB.execute}                                         
                                                                               
	
<form name="met_metodo" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/met_metodo/met_metodoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${met_metodoJB.tipoMsg}">${met_metodoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('met_metodo','insert', '/portal/portal/met_metodo/met_metodoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('met_metodo','Limpar', '/portal/portal/met_metodo/met_metodoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('met_metodo','', '/portal/portal/met_metodo/met_metodoConsult.jsp')" />
    </div></td>
  </tr>
</table>
<br/>
<table align="left" width="600" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
	<table align="left" width="50%" border="0">
	    <tr>
	<td>
		<label>ope_nr_id:</label>
	</td>
	<td>
	    <select name="met_metodoT.ope_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${met_metodoJB.listope_operacao}" var="item">
            	  <option value="${item.ope_nr_id}">${item.ope_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		met_tx_metodo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="met_metodoT.met_tx_metodo" value="${met_metodoJB.met_metodoT.met_tx_metodo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		met_tx_status:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="met_metodoT.met_tx_status" value="${met_metodoJB.met_metodoT.met_tx_status}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>sis_nr_id:</label>
	</td>
	<td>
	    <select name="met_metodoT.sis_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${met_metodoJB.listope_operacao}" var="item">
            	  <option value="${item.sis_nr_id}">${item.sis_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		met_tx_descricao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="met_metodoT.met_tx_descricao" value="${met_metodoJB.met_metodoT.met_tx_descricao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('met_metodo','insert', '/portal/portal/met_metodo/met_metodoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('met_metodo','Limpar', '/portal/portal/met_metodo/met_metodoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('met_metodo','', '/portal/portal/met_metodo/met_metodoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
