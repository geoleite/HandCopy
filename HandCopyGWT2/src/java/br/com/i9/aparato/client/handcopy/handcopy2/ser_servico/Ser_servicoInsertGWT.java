/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.ser_servico;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.set_setor.SelecionarSetorGWT;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Ser_servicoInsertGWT extends CadastrarBaseGWT {

    private Ser_servicoConsultGWT ser_servicoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Ser_servicoDAOGWT ser_servicoDao = new Ser_servicoDAOGWT();
    private TextField<String> ser_tx_nome = new TextField<String>();
//    private Set_setorTGWT set_setorTGWT = new Set_setorTGWT();
//    private SelecionarSetorGWT selSetor = new SelecionarSetorGWT();
    
    public Ser_servicoInsertGWT() {
        setHeading("Cadastrar Servico");
        this.setSize("380", "150");
//        getDataWEST().setHidden(false);
//        getCpLeft().setVisible(true);
//        getCpLeft().setLayout(new FitLayout());
//        getCpLeft().add(selSetor);
        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(ser_tx_nome);
        ser_tx_nome.setWidth("250");
    }

    public void btnInsertAction(ButtonEvent ce) {
        Ser_servicoTGWT ser_servicoT = new Ser_servicoTGWT();
        ser_servicoT.setSer_tx_nome(ser_tx_nome.getValue());

        ser_servicoDao.inserir(ser_servicoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = ser_servicoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        ser_servicoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        ser_tx_nome.setValue("");
    }

    /**
     * @return the ser_servicoConsult
     */
    public Ser_servicoConsultGWT getSer_servicoConsult() {
        return ser_servicoConsult;
    }

    /**
     * @param ser_servicoConsult the ser_servicoConsult to set
     */
    public void setSer_servicoConsult(Ser_servicoConsultGWT ser_servicoConsult) {
        this.ser_servicoConsult = ser_servicoConsult;
    }
}
