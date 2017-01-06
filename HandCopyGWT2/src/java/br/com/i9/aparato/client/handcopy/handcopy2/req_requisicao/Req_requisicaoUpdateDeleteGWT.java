package br.com.i9.aparato.client.handcopy.handcopy2.req_requisicao;

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
public class Req_requisicaoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Req_requisicaoConsultGWT req_requisicaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Req_requisicaoDAOGWT req_requisicaoDao = new Req_requisicaoDAOGWT();
    private Req_requisicaoTGWT req_requisicaoT;

    private TextField<String> req_nr_id = new TextField<String>();
    private TextField<String> req_tx_identificador = new TextField<String>();
    private TextField<String> req_tx_teriminal = new TextField<String>();
    private DateField req_dt_requisitado = new DateField();


    public Req_requisicaoUpdateDeleteGWT() {
        this.setSize("500", "400");
	
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("req_nr_id:"));
        getCpMaster().add(req_nr_id);

        getCpMaster().add(new LabelField("req_tx_identificador:"));
        getCpMaster().add(req_tx_identificador);

        getCpMaster().add(new LabelField("req_tx_teriminal:"));
        getCpMaster().add(req_tx_teriminal);

        getCpMaster().add(new LabelField("req_dt_requisitado:"));
        getCpMaster().add(req_dt_requisitado);


    }

    public void load(Req_requisicaoTGWT req_requisicaoT) {
	this.req_requisicaoT = req_requisicaoT;
		req_nr_id.setValue(req_requisicaoT.getReq_nr_id() + "");
		req_tx_identificador.setValue(req_requisicaoT.getReq_tx_identificador());
		req_tx_teriminal.setValue(req_requisicaoT.getReq_tx_teriminal());
		req_dt_requisitado.setValue(req_requisicaoT.getReq_dt_requisitado());

    }
    public void btnUpdateAction(ButtonEvent ce) {
		req_requisicaoT.setReq_nr_id( Integer.parseInt(req_nr_id.getValue()));
		req_requisicaoT.setReq_tx_identificador(req_tx_identificador.getValue());
		req_requisicaoT.setReq_tx_teriminal(req_tx_teriminal.getValue());
		req_requisicaoT.setReq_dt_requisitado(req_dt_requisitado.getValue());

	req_requisicaoDao.alterar(req_requisicaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = req_requisicaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  req_requisicaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

	req_requisicaoDao.excluir(req_requisicaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = req_requisicaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  req_requisicaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }


   /**
     * @return the req_requisicaoConsult
     */
    public Req_requisicaoConsultGWT getReq_requisicaoConsult() {
        return req_requisicaoConsult;
    }

    /**
     * @param req_requisicaoConsult the req_requisicaoConsult to set
     */
    public void setReq_requisicaoConsult(Req_requisicaoConsultGWT req_requisicaoConsult) {
        this.req_requisicaoConsult = req_requisicaoConsult;
    }

}

