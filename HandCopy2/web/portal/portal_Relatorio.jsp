<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="portal" class="br.com.easynet.portal.jb.PortalBaseJB" scope="request"/>                                         
<jsp:setProperty name="portal" property="*"/>                                         
<jsp:setProperty name="portal" property="page" value="${pageContext}"/>   
${portal.execute}

<%@page contentType="text/html" pageEncoding="LATIN1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <!-- DW6 -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=latin1" />
        <!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
        <!--<title>EasyPortal Authentication ..::Clínica Vitalite::..</title>-->
        <link rel="stylesheet" href="/recursos/mm_health_nutr.css" type="text/css" />
        <link href="../css/modelimpressao.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            <!--

            #controle_impressao {
                position:absolute;
                width:600px;
                height:30px;
                z-index:1;
                visibility: visible;
            }

            .style3 {font-size: 24px}
            -->
        </style>
        <script src="eventos.js"></script>  
        <script type="text/JavaScript">
            <!--
            function Imprimir(){
                if (!window.print){
                    alert("Use o Netscape  ou Internet Explorer \n nas versões 4.0 ou superior!")
                    return
                }
                window.print()
            }

            function MM_findObj(n, d) { //v4.01
                var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
                    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
                if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
                for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
                if(!x && d.getElementById) x=d.getElementById(n); return x;
            }
    
            function MM_showHideLayers() { //v6.0
                var i,p,v,obj,args=MM_showHideLayers.arguments;
                for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
                    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
                    obj.visibility=v; }
            }
            //-->
        </script>
    </head>
    <body >

        <table aling = "center" width="500">
            <tr>
                <td align ="center">
                    <div id="controle_impressao">
                        <input type="button" value ="Imprimir" onclick="MM_showHideLayers('controle_impressao','','hidden');Imprimir()"/>
                        <input type="button" value ="Fechar" onClick="window.close()"/>
                    </div>
                    
                    <div align="left">
                        ${portal.msg}<br/>
                        ${portal.montaCanal}
                    </div>                    

                </td>
            </tr>
        </table>    


    </body>
</html>
