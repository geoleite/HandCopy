package br.com.i9.aparato.client.handcopy.handcopy2.ser_servico;

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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Ser_servicoUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Ser_servicoConsultGWT ser_servicoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Ser_servicoDAOGWT ser_servicoDao = new Ser_servicoDAOGWT();
    private Ser_servicoTGWT ser_servicoT;
    private TextField<String> ser_tx_nome = new TextField<String>();
    private LabelField lfOrgao = new LabelField();
    private Set_setorDAOGWT setDao = new Set_setorDAOGWT();
    private Set_setorTGWT setT;

    public Ser_servicoUpdateDeleteGWT() {
        setHeading("Alterar Servico");
        this.setSize("380", "150");

        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(ser_tx_nome);


    }

    public void load(Ser_servicoTGWT ser_servicoT) {
        this.ser_servicoT = ser_servicoT;

        ser_tx_nome.setValue(ser_servicoT.getSer_tx_nome());

        setT = new Set_setorTGWT();

    }

    public void btnUpdateAction(ButtonEvent ce) {
        ser_servicoT.setSer_tx_nome(ser_tx_nome.getValue());
        ser_servicoDao.alterar(ser_servicoT);
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
                        ser_servicoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        ser_servicoDao.excluir(ser_servicoT);
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
                        ser_servicoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
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
