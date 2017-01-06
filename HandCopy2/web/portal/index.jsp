<%-- 
    Document   : index
    Created on : 05/05/2008, 20:26:21
    Author     : geoleite
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="portal" class="br.com.easynet.portal.jb.PortalBase" scope="request"/>                                         
<jsp:setProperty name="portal" property="*"/>                                         
<jsp:setProperty name="portal" property="page" value="${pageContext}"/>                                         
${portal.execute}      
<%@page contentType="text/html" pageEncoding="LATIN1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Portal</title>
        <link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        <script src="easyajax.js"></script>
    </head>
    <body>
        <!--form action="index.jsp" method="get"-->                                         
            <input type="hidden" name="op"/>
            <input type="hidden" name="classjb"/>
            <table border="0" cellpadding="0" cellspacing="5" class="vazio" width="100%">           
                <tbody>                    
                    <%
            for (int i = 0; i < portal.getCanais().size();) {
                    %>
                    <tr>
                        <td rowspan="10" valign="top" align="center">                        
                            <%
                        int j = i;
                        String channel = request.getParameter("channel");
                        if (channel == null) {
                            channel = "";
                        }

                        for (int cont = 0; cont < (portal.getPortalT().getPor_nr_colunas()) &&
                                j < portal.getCanais().size(); cont++) {

                            int codigo = portal.getCanais().get(j).getCan_nr_id();
                            String estado = portal.getCanais().get(j).getCan_tx_estado();
                            String url = portal.getCanais().get(j).getCan_tx_url();
                            String name = portal.getCanais().get(j).getCan_tx_nome();
                            String borda = portal.getCanais().get(j).getCan_tx_border();
                            String border = "";
                            if ("S".equals(borda)) {
                                border = "tdborderout";
                            }
                            j++;
                            %>
                             
                            <table border="0" cellpadding="0" cellspacing="0" align="center" width="100%">
                                <tr> 
                                    <th nowrap>
                                        <%=name%> <a href="index.jsp?op=minimizar&can_canalT.can_nr_id=<%=codigo%>">Min</a>
                                        <a href="index.jsp?op=normalizar&can_canalT.can_nr_id=<%=codigo%>">Nor</a>
                                        <a href="index.jsp?op=maximizar&can_canalT.can_nr_id=<%=codigo%>">Max</a>
                                        <a href="index.jsp?op=fechar&can_canalT.can_nr_id=<%=codigo%>">Close</a>
                                    </th>
                                </tr>   
                                <%
                                if (!"MIN".equals(estado)) {

                                %>
                                <tr>                                    
                                    
                                    <td class="<%=border%>" > 
                                       <%
                                         String urlPage = request.getParameter("url");
                                         String pageUrl = request.getParameter("pageActual");
                                         if (pageUrl != null  && pageUrl.equals(url) && urlPage != null) {
                                           String str = request.getQueryString();
                                           byte[] dataPage = (byte[])request.getAttribute(str);
                                           if (dataPage != null) {
                                              //request.removeAttribute(request.getQueryString());
                                              //out.println(dataPage);
                                              out.println(new String(dataPage));
                                           } 
                                         }else {
                                         %>
                                          <jsp:include page="<%=url%>" flush="true"/>
                                        <%
                                          }
                                        %>
                                    </td>
                                </tr>
                                <%
                                }
                                %>
                            </table>
                            
                            <%
                        }

                        i += portal.getPortalT().getPor_nr_colunas();
                            %>
                        </td>
                    </tr>
                    <%
            }
                    %>                    
                </tbody>
            </table>
        <!--/form-->
    </body>
</html>
