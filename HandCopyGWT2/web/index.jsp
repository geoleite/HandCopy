<!doctype html>
<!--
The DOCTYPE declaration above will set the browser's rendering engine into
"Standards Mode". Replacing this declaration with a "Quirks Mode" doctype may
lead to some differences in layout.
-->
<html>
    <head>
        <meta name='gwt:module' content='br.com.i9.aparato.Main=br.com.i9.aparato.Main'>
        <meta name="gwt:property" content="locale=${param['locale']}">
        <title>Aparato - HandCopy</title>
        <link rel="stylesheet" type="text/css" href="gxt/css/gxt-all.css" />

        <script type="text/javascript">
//            var userAgent = navigator.userAgent.toLowerCase();
//            var ip="";
//            if (navigator.javaEnabled()) {
//                ip = java.net.InetAddress.getLocalHost().getHostAddress();
//            }
//            alert(ip);
        </script>
        <style type="text/css">
            #header {
                width: 100%;
                background: url(images/topo.jpg) no-repeat left top;
                background-color:#006EB9;
                height: 60px;
                margin: 0;
                padding-top:0px;
            }
            #menu {
                width: 100%;
                height: 40px;
                margin: 0 auto;
            }
            #menu ul {
                float: right;
                margin: 0;
                padding: 25px 0px 0px 0px;
                list-style: none;
                line-height: normal;

            }

            #menu li {
                float: right;
                padding-right: 10px;

            }

            #menu a {
                display: block;
                font-family: Arial, Verdana, Georgia;
                text-decoration: none;
                font-weight: normal;
                color: #FFFFFF;
                border: none;
                font-size: 11px;
            }

            #menu a:hover, #menu .current_page_item a {
                text-decoration: none;
            }

            #footer {

                bottom: 0;
                background-color: #F0F0F0;
                height: 30px;
                width: 100%;
                text-align: center;
            }
            #banner {

                width: 100%;

                background-color:#006EB9;
                height: 768px;
                margin: 0;
                padding-top:0px;
                text-align: center;
            }
            #fundo {

                background: url(images/i9im.jpg) no-repeat left top;
                width: 1024px;
                height: 100%;

            }
            body1 {
                scrollbar-arrow-color:#000000;
                scrollbar-3dlight-color:#000000;
                scrollbar-highlight-color:#FF0000;
                scrollbar-face-color:#FFFFFF;
                scrollbar-shadow-color:#0000FF;
                scrollbar-darkshadow-color:#FFFF00;
                scrollbar-track-color:#00FF00;
            }

        </style>

    </head>

    <body leftmargin="0" topmargin="0"  style="margin-top: 0px; margin-left: 0px; margin-right: 0px;margin-bottom: 0px">

        <script type="text/javascript"  src="br.com.i9.aparato.Main/br.com.i9.aparato.Main.nocache.js"></script>
        <div id="header">
        </div>
        <div id="gwt"></div>
        <div id="x-desktop">
            <dl id="x-shortcuts">
                <dd></dd>
            </dl>
        </div>
        <div id="banner1" align="center">
        </div>
    </body>
</html>
