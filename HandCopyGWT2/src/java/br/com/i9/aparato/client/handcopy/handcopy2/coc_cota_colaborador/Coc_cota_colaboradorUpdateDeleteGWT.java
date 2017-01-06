package br.com.i9.aparato.client.handcopy.handcopy2.coc_cota_colaborador;

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
public class Coc_cota_colaboradorUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Coc_cota_colaboradorConsultGWT coc_cota_colaboradorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Coc_cota_colaboradorDAOGWT coc_cota_colaboradorDao = new Coc_cota_colaboradorDAOGWT();
    private Coc_cota_colaboradorTGWT coc_cota_colaboradorT;
    private TextField<String> coc_nr_saldo = new TextField<String>();

    public Coc_cota_colaboradorUpdateDeleteGWT() {
        setMinimizable(false);
        setMaximizable(false);
        setResizable(false);
        setHeading("Alterar Cota do Colaborador");

        this.setSize("220", "100");

        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Cota:"));
        getCpMaster().add(coc_nr_saldo);
    }


    public void load(Coc_cota_colaboradorTGWT coc_cota_colaboradorT) {
        this.coc_cota_colaboradorT = coc_cota_colaboradorT;
        coc_nr_saldo.setValue(coc_cota_colaboradorT.getCoc_nr_saldo() + "");
        getToolBarMaster().add(getBtnDel());
    }

    public void btnUpdateAction(ButtonEvent ce) {
        coc_cota_colaboradorT.setCoc_nr_saldo(Integer.parseInt(coc_nr_saldo.getValue()));

        coc_cota_colaboradorDao.alterar(coc_cota_colaboradorT);
        Timer timer = new Timer() {

            public void run() {
                String msg = coc_cota_colaboradorDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        coc_cota_colaboradorConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        coc_cota_colaboradorDao.excluir(coc_cota_colaboradorT);
        Timer timer = new Timer() {

            public void run() {
                String msg = coc_cota_colaboradorDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        coc_cota_colaboradorConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the coc_cota_colaboradorConsult
     */
    public Coc_cota_colaboradorConsultGWT getCoc_cota_colaboradorConsult() {
        return coc_cota_colaboradorConsult;
    }

    /**
     * @param coc_cota_colaboradorConsult the coc_cota_colaboradorConsult to set
     */
    public void setCoc_cota_colaboradorConsult(Coc_cota_colaboradorConsultGWT coc_cota_colaboradorConsult) {
        this.coc_cota_colaboradorConsult = coc_cota_colaboradorConsult;
    }
}
