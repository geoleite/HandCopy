package br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao;

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
public class Sol_solicitacaoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Sol_solicitacaoConsultGWT sol_solicitacaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Sol_solicitacaoDAOGWT sol_solicitacaoDao = new Sol_solicitacaoDAOGWT();
    private Sol_solicitacaoTGWT sol_solicitacaoT;

    private TextField<String> sol_nr_id = new TextField<String>();
    private TextField<String> col_nr_id = new TextField<String>();
    private TextField<String> cot_nr_id = new TextField<String>();
    private TextField<String> set_nr_id = new TextField<String>();
    private TextField<String> ser_nr_id = new TextField<String>();
    private DateField sol_dt_datahora = new DateField();
    private TextField<String> sol_tx_idterminal = new TextField<String>();
    private TextField<String> sol_nr_quantidade = new TextField<String>();


    public Sol_solicitacaoUpdateDeleteGWT() {
        this.setSize("500", "400");
	
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("sol_nr_id:"));
        getCpMaster().add(sol_nr_id);

        getCpMaster().add(new LabelField("col_nr_id:"));
        getCpMaster().add(col_nr_id);

        getCpMaster().add(new LabelField("cot_nr_id:"));
        getCpMaster().add(cot_nr_id);

        getCpMaster().add(new LabelField("set_nr_id:"));
        getCpMaster().add(set_nr_id);

        getCpMaster().add(new LabelField("ser_nr_id:"));
        getCpMaster().add(ser_nr_id);

        getCpMaster().add(new LabelField("sol_dt_datahora:"));
        getCpMaster().add(sol_dt_datahora);

        getCpMaster().add(new LabelField("sol_tx_idterminal:"));
        getCpMaster().add(sol_tx_idterminal);

        getCpMaster().add(new LabelField("sol_nr_quantidade:"));
        getCpMaster().add(sol_nr_quantidade);


    }

    public void load(Sol_solicitacaoTGWT sol_solicitacaoT) {
	this.sol_solicitacaoT = sol_solicitacaoT;
		sol_nr_id.setValue(sol_solicitacaoT.getSol_nr_id() + "");
		col_nr_id.setValue(sol_solicitacaoT.getCol_nr_id() + "");
		cot_nr_id.setValue(sol_solicitacaoT.getCot_nr_id() + "");
		set_nr_id.setValue(sol_solicitacaoT.getSet_nr_id() + "");
		ser_nr_id.setValue(sol_solicitacaoT.getSer_nr_id() + "");
		sol_dt_datahora.setValue(sol_solicitacaoT.getSol_dt_datahora());
		sol_tx_idterminal.setValue(sol_solicitacaoT.getSol_tx_idterminal());
		sol_nr_quantidade.setValue(sol_solicitacaoT.getSol_nr_quantidade() + "");

    }
    public void btnUpdateAction(ButtonEvent ce) {
		sol_solicitacaoT.setSol_nr_id( Integer.parseInt(sol_nr_id.getValue()));
		sol_solicitacaoT.setCol_nr_id( Integer.parseInt(col_nr_id.getValue()));
		sol_solicitacaoT.setCot_nr_id( Integer.parseInt(cot_nr_id.getValue()));
		sol_solicitacaoT.setSet_nr_id( Integer.parseInt(set_nr_id.getValue()));
		sol_solicitacaoT.setSer_nr_id( Integer.parseInt(ser_nr_id.getValue()));
		sol_solicitacaoT.setSol_dt_datahora(sol_dt_datahora.getValue());
		sol_solicitacaoT.setSol_tx_idterminal(sol_tx_idterminal.getValue());
		sol_solicitacaoT.setSol_nr_quantidade( Integer.parseInt(sol_nr_quantidade.getValue()));

	sol_solicitacaoDao.alterar(sol_solicitacaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = sol_solicitacaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  sol_solicitacaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

	sol_solicitacaoDao.excluir(sol_solicitacaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = sol_solicitacaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  sol_solicitacaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }


   /**
     * @return the sol_solicitacaoConsult
     */
    public Sol_solicitacaoConsultGWT getSol_solicitacaoConsult() {
        return sol_solicitacaoConsult;
    }

    /**
     * @param sol_solicitacaoConsult the sol_solicitacaoConsult to set
     */
    public void setSol_solicitacaoConsult(Sol_solicitacaoConsultGWT sol_solicitacaoConsult) {
        this.sol_solicitacaoConsult = sol_solicitacaoConsult;
    }

}

