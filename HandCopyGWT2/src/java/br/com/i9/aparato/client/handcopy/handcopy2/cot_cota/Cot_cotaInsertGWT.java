/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.aparato.client.handcopy.handcopy2.cot_cota;

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
public class Cot_cotaInsertGWT extends CadastrarBaseGWT  {
    private Cot_cotaConsultGWT cot_cotaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Cot_cotaDAOGWT cot_cotaDao = new Cot_cotaDAOGWT();
    private TextField<String> cot_nr_id = new TextField<String>();
    private TextField<String> set_nr_id = new TextField<String>();
    private TextField<String> ser_nr_id = new TextField<String>();
    private TextField<String> cot_nr_saldo = new TextField<String>();


    public Cot_cotaInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("cot_nr_id:"));
        getCpMaster().add(cot_nr_id);

        getCpMaster().add(new LabelField("set_nr_id:"));
        getCpMaster().add(set_nr_id);

        getCpMaster().add(new LabelField("ser_nr_id:"));
        getCpMaster().add(ser_nr_id);

        getCpMaster().add(new LabelField("cot_nr_saldo:"));
        getCpMaster().add(cot_nr_saldo);


    }

    public void btnInsertAction(ButtonEvent ce){
	Cot_cotaTGWT cot_cotaT = new Cot_cotaTGWT();
			cot_cotaT.setCot_nr_id( Integer.parseInt(cot_nr_id.getValue()));
		cot_cotaT.setSet_nr_id( Integer.parseInt(set_nr_id.getValue()));
		cot_cotaT.setSer_nr_id( Integer.parseInt(ser_nr_id.getValue()));
		cot_cotaT.setCot_nr_saldo( Integer.parseInt(cot_nr_saldo.getValue()));

        cot_cotaDao.inserir(cot_cotaT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = cot_cotaDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  cot_cotaConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			cot_nr_id.setValue("");
		set_nr_id.setValue("");
		ser_nr_id.setValue("");
		cot_nr_saldo.setValue("");

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
}

