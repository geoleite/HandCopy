/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.relatorio;

import br.com.easynet.gwt.client.report.RelatorioBaseGWT;
import br.com.easyportal.gwt.client.Constantes;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Rel_TicketSolicitacao extends RelatorioBaseGWT {

    public Rel_TicketSolicitacao() {
        setHeading("Ticket para solicitacao");
        setSize(750, 400);
        /*
        //download(Constantes.URL+"handcopy/handcopy2/relatorio/solicitacao.jsp?op=imprimir&tipo=PDF");

        String url = Constantes.URL + JSP_VIEW + "../";
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
        getCpREL().setUrl(url);
         */
        
        //addBtnFiltrar();
        //addBtnExportar();
        filtrar();
    }

    public String getURL() {
        return "handcopy/handcopy2/relatorio/solicitacao.jsp?op=imprimir";
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + "applets/" + JSP_VIEW + "../";
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
        getCpREL().setUrl(url);
    }

    @Override
    public void exportarPDF() {
        download(Constantes.URL + getURL() + TIPO_PDF);
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL + getURL() + TIPO_XLS);
    }
}
