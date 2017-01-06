/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.aparato.client.handcopy.handcopy2.col_colaborador;

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
public class Col_colaboradorInsertGWT extends CadastrarBaseGWT  {
    private Col_colaboradorConsultGWT col_colaboradorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Col_colaboradorDAOGWT col_colaboradorDao = new Col_colaboradorDAOGWT();
    private TextField<String> col_nr_id = new TextField<String>();
    private TextField<String> sca_nr_id = new TextField<String>();


    public Col_colaboradorInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("col_nr_id:"));
        getCpMaster().add(col_nr_id);

        getCpMaster().add(new LabelField("sca_nr_id:"));
        getCpMaster().add(sca_nr_id);


    }

    public void btnInsertAction(ButtonEvent ce){
	Col_colaboradorTGWT col_colaboradorT = new Col_colaboradorTGWT();
			col_colaboradorT.setCol_nr_id( Integer.parseInt(col_nr_id.getValue()));
		col_colaboradorT.setSca_nr_id( Integer.parseInt(sca_nr_id.getValue()));

        col_colaboradorDao.inserir(col_colaboradorT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = col_colaboradorDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  col_colaboradorConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			col_nr_id.setValue("");
		sca_nr_id.setValue("");

    }

   /**
     * @return the col_colaboradorConsult
     */
    public Col_colaboradorConsultGWT getCol_colaboradorConsult() {
        return col_colaboradorConsult;
    }

    /**
     * @param col_colaboradorConsult the col_colaboradorConsult to set
     */
    public void setCol_colaboradorConsult(Col_colaboradorConsultGWT col_colaboradorConsult) {
        this.col_colaboradorConsult = col_colaboradorConsult;
    }
}

