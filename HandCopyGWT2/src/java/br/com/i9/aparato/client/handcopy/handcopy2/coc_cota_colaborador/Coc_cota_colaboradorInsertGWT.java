/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.aparato.client.handcopy.handcopy2.coc_cota_colaborador;

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
public class Coc_cota_colaboradorInsertGWT extends CadastrarBaseGWT  {
    private Coc_cota_colaboradorConsultGWT coc_cota_colaboradorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Coc_cota_colaboradorDAOGWT coc_cota_colaboradorDao = new Coc_cota_colaboradorDAOGWT();
    private TextField<String> col_nr_id = new TextField<String>();
    private TextField<String> cot_nr_id = new TextField<String>();
    private TextField<String> set_nr_id = new TextField<String>();
    private TextField<String> ser_nr_id = new TextField<String>();
    private TextField<String> coc_nr_saldo = new TextField<String>();


    public Coc_cota_colaboradorInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("col_nr_id:"));
        getCpMaster().add(col_nr_id);

        getCpMaster().add(new LabelField("cot_nr_id:"));
        getCpMaster().add(cot_nr_id);

        getCpMaster().add(new LabelField("set_nr_id:"));
        getCpMaster().add(set_nr_id);

        getCpMaster().add(new LabelField("ser_nr_id:"));
        getCpMaster().add(ser_nr_id);

        getCpMaster().add(new LabelField("coc_nr_saldo:"));
        getCpMaster().add(coc_nr_saldo);


    }

    public void btnInsertAction(ButtonEvent ce){
	Coc_cota_colaboradorTGWT coc_cota_colaboradorT = new Coc_cota_colaboradorTGWT();
			coc_cota_colaboradorT.setCol_nr_id( Integer.parseInt(col_nr_id.getValue()));
		coc_cota_colaboradorT.setCot_nr_id( Integer.parseInt(cot_nr_id.getValue()));
		coc_cota_colaboradorT.setSet_nr_id( Integer.parseInt(set_nr_id.getValue()));
		coc_cota_colaboradorT.setSer_nr_id( Integer.parseInt(ser_nr_id.getValue()));
		coc_cota_colaboradorT.setCoc_nr_saldo( Integer.parseInt(coc_nr_saldo.getValue()));

        coc_cota_colaboradorDao.inserir(coc_cota_colaboradorT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = coc_cota_colaboradorDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  coc_cota_colaboradorConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			col_nr_id.setValue("");
		cot_nr_id.setValue("");
		set_nr_id.setValue("");
		ser_nr_id.setValue("");
		coc_nr_saldo.setValue("");

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

