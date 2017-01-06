<html>
    <APPLET  CODE = "EmbeddedViewerApplet.class" CODEBASE = "applets" ARCHIVE = "jasperreports-1.2.3-applet.jar" WIDTH = "100%" HEIGHT = "100%">
        <PARAM NAME = CODE VALUE = "EmbeddedViewerApplet.class" >
        <PARAM NAME = CODEBASE VALUE = "./" >
        <PARAM NAME = ARCHIVE VALUE = "jasperreports-1.2.3-applet.jar" >
        <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.3">
        <PARAM NAME="scriptable" VALUE="false">
        <%
                    String url = request.getParameter("url");
                    url = url.replace("|", "?");
                    url = url.replace("$", "&");
        %>
        <PARAM NAME = "REPORT_URL" VALUE ="<%=url%>">
    </APPLET>
</html>
