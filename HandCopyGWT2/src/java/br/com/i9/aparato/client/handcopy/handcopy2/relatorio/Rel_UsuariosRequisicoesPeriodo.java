/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.relatorio;

import br.com.easynet.gwt.client.report.RelatorioBaseGWT;
import br.com.i9.aparato.client.Constantes;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 *
 * @author geoleite
 */
public class Rel_UsuariosRequisicoesPeriodo extends RelatorioBaseGWT {

    private Button btnGerar = new Button("Gerar");
    private DateTimeFormat DTF = DateTimeFormat.getFormat("dd/MM/yyyy");

    public Rel_UsuariosRequisicoesPeriodo() {
        setHeading("Usuarios e Solicitacoes por Periodo");
        setSize(750, 400);
        getToolBarMaster().add(new LabelField("Dt. Inicio"));
        getToolBarMaster().add(getDtInicio());
        getToolBarMaster().add(new LabelField("Dt. Fim"));
        getToolBarMaster().add(getDtFim());
        getToolBarMaster().add(btnGerar);
        setVisible(true);
        //
        btnGerar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                filtrar();
//                String dtInicio = DTF.format(getDtInicio().getValue());
//                String dtFim = DTF.format(getDtFim().getValue());
//                download(Constantes.URL + "handcopy/handcopy2/relatorio/usuariosSolicitacoesPeriodo.jsp?op=imprimir&tipo=PDF&dtInicio=" + dtInicio + "&dtFim=" + dtFim);
            }
        });
    }

    public String getURL() {
        String dtInicio = DTF.format(getDtInicio().getValue());
        String dtFim = DTF.format(getDtFim().getValue());
        return "handcopy/handcopy2/relatorio/usuariosSolicitacoesPeriodo.jsp?op=imprimir&dtInicio=" + dtInicio + "&dtFim=" + dtFim;
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
