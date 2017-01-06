package br.com.i9.aparato.client.handcopy.handcopy2.cot_cota;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Cot_cotaUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Cot_cotaConsultGWT cot_cotaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Cot_cotaDAOGWT cot_cotaDao = new Cot_cotaDAOGWT();
    private Cot_cotaTGWT cot_cotaT;
    private TextField<String> cot_nr_saldo = new TextField<String>();
    private Set_setorTGWT set_setorTGWT;
    private Ser_servicoTGWT ser_servicoTGWT;
    private LabelField lfSetor = new LabelField();
    private LabelField lfServico = new LabelField();

    public Cot_cotaUpdateDeleteGWT() {
        setMaximizable(false);
        setMinimizable(false);
        setResizable(false);
        setHeading("Alterar Cota");
        this.setSize("380", "150");
        //getToolBarMaster().remove(getbtnDel);
        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Setor:"));
        getCpMaster().add(lfSetor);

        getCpMaster().add(new LabelField("Servico:"));
        getCpMaster().add(lfServico);

        getCpMaster().add(new LabelField("Cota:"));
        getCpMaster().add(cot_nr_saldo);


    }

    public void load(Cot_cotaTGWT cot_cotaT) {
        this.cot_cotaT = cot_cotaT;
        cot_nr_saldo.setValue(cot_cotaT.getCot_nr_saldo() + "");
        lfSetor.setText(set_setorTGWT.getSet_tx_nome());
        lfServico.setText(ser_servicoTGWT.getSer_tx_nome());
    }

    public void btnUpdateAction(ButtonEvent ce) {
        cot_cotaT.setCot_nr_saldo(Integer.parseInt(cot_nr_saldo.getValue()));

        cot_cotaDao.alterar(cot_cotaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = cot_cotaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        cot_cotaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        cot_cotaDao.excluir(cot_cotaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = cot_cotaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        cot_cotaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the cot_cotaConsult
     */
    public Cot_cotaConsultGWT getCot_cotaConsult() {
        return cot_cotaConsult;
    }

    /**
     * @param cot_cotaConsult the cot_cotaConsult to set
     */
    public void setCot_cotaConsult(Cot_cotaConsultGWT cot_cotaConsult) {
        this.cot_cotaConsult = cot_cotaConsult;
    }

    /**
     * @return the set_setorTGWT
     */
    public Set_setorTGWT getSet_setorTGWT() {
        return set_setorTGWT;
    }

    /**
     * @param set_setorTGWT the set_setorTGWT to set
     */
    public void setSet_setorTGWT(Set_setorTGWT set_setorTGWT) {
        this.set_setorTGWT = set_setorTGWT;
    }

    /**
     * @return the ser_servicoTGWT
     */
    public Ser_servicoTGWT getSer_servicoTGWT() {
        return ser_servicoTGWT;
    }

    /**
     * @param ser_servicoTGWT the ser_servicoTGWT to set
     */
    public void setSer_servicoTGWT(Ser_servicoTGWT ser_servicoTGWT) {
        this.ser_servicoTGWT = ser_servicoTGWT;
    }
}
