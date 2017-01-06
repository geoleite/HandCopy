/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.aparato.client.handcopy.handcopy2.sec_setor_colaborador;

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
public class Sec_setor_colaboradorInsertGWT extends CadastrarBaseGWT  {
    private Sec_setor_colaboradorConsultGWT sec_setor_colaboradorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Sec_setor_colaboradorDAOGWT sec_setor_colaboradorDao = new Sec_setor_colaboradorDAOGWT();
    private TextField<String> set_nr_id = new TextField<String>();
    private TextField<String> col_nr_id = new TextField<String>();
    private DateField sec_dt_alocado = new DateField();


    public Sec_setor_colaboradorInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("set_nr_id:"));
        getCpMaster().add(set_nr_id);

        getCpMaster().add(new LabelField("col_nr_id:"));
        getCpMaster().add(col_nr_id);

        getCpMaster().add(new LabelField("sec_dt_alocado:"));
        getCpMaster().add(sec_dt_alocado);


    }

    public void btnInsertAction(ButtonEvent ce){
	Sec_setor_colaboradorTGWT sec_setor_colaboradorT = new Sec_setor_colaboradorTGWT();
			sec_setor_colaboradorT.setSet_nr_id( Integer.parseInt(set_nr_id.getValue()));
		sec_setor_colaboradorT.setCol_nr_id( Integer.parseInt(col_nr_id.getValue()));
		sec_setor_colaboradorT.setSec_dt_alocado(sec_dt_alocado.getValue());

        sec_setor_colaboradorDao.inserir(sec_setor_colaboradorT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = sec_setor_colaboradorDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  sec_setor_colaboradorConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			set_nr_id.setValue("");
		col_nr_id.setValue("");
		sec_dt_alocado.setValue(null);

    }

   /**
     * @return the sec_setor_colaboradorConsult
     */
    public Sec_setor_colaboradorConsultGWT getSec_setor_colaboradorConsult() {
        return sec_setor_colaboradorConsult;
    }

    /**
     * @param sec_setor_colaboradorConsult the sec_setor_colaboradorConsult to set
     */
    public void setSec_setor_colaboradorConsult(Sec_setor_colaboradorConsultGWT sec_setor_colaboradorConsult) {
        this.sec_setor_colaboradorConsult = sec_setor_colaboradorConsult;
    }
}

