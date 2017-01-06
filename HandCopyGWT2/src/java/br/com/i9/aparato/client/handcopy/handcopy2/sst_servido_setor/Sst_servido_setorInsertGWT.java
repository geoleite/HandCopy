/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.sst_servido_setor;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;

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
public class Sst_servido_setorInsertGWT extends CadastrarBaseGWT {

    private Sst_servido_setorConsultGWT sst_servido_setorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Sst_servido_setorDAOGWT sst_servido_setorDao = new Sst_servido_setorDAOGWT();
    private TextField<String> set_nr_id = new TextField<String>();
    private TextField<String> ser_nr_id = new TextField<String>();

    public Sst_servido_setorInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("set_nr_id:"));
        getCpMaster().add(set_nr_id);

        getCpMaster().add(new LabelField("ser_nr_id:"));
        getCpMaster().add(ser_nr_id);


    }

    public void btnInsertAction(ButtonEvent ce) {
        Sst_servido_setorTGWT sst_servido_setorT = new Sst_servido_setorTGWT();
        sst_servido_setorT.setSet_nr_id(Integer.parseInt(set_nr_id.getValue()));
        sst_servido_setorT.setSer_nr_id(Integer.parseInt(ser_nr_id.getValue()));

        sst_servido_setorDao.inserir(sst_servido_setorT);
        Timer timer = new Timer() {

            public void run() {
                String msg = sst_servido_setorDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        sst_servido_setorConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        set_nr_id.setValue("");
        ser_nr_id.setValue("");

    }

    /**
     * @return the sst_servido_setorConsult
     */
    public Sst_servido_setorConsultGWT getSst_servido_setorConsult() {
        return sst_servido_setorConsult;
    }

    /**
     * @param sst_servido_setorConsult the sst_servido_setorConsult to set
     */
    public void setSst_servido_setorConsult(Sst_servido_setorConsultGWT sst_servido_setorConsult) {
        this.sst_servido_setorConsult = sst_servido_setorConsult;
    }
}
