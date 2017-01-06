package br.com.i9.imagemanager.gwt.client.set_setorNew;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.i9.imagemanager.gwt.client.IModeloLoad;
import br.com.i9.imagemanager.gwt.client.dao.Set_setorNewDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorNewTGWT;

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
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Set_setorUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private IModeloLoad modeloLoad;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Set_setorNewDAOGWT set_setorDao = new Set_setorNewDAOGWT();
    private Set_setorNewTGWT set_setorT;
    private TextField<String> set_nr_id = new TextField<String>();
    private TextField<String> set_tx_nome = new TextField<String>();
    private CheckBox set_tx_status = new CheckBox();
    private Set_setorNewTGWT setorPai;

    public Set_setorUpdateDeleteGWT() {
        setHeading("Alterar Servico");
        this.setSize("380", "200");

        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(set_tx_nome);
        set_tx_nome.setWidth("250");

        getCpMaster().add(new LabelField("Status:"));
        getCpMaster().add(set_tx_status);
        set_tx_status.setBoxLabel("Ativo");
    }

    public void load(Set_setorNewTGWT set_setorT) {
        this.set_setorT = set_setorT;
        set_tx_nome.setValue(set_setorT.getSet_tx_nome());
        set_tx_status.setValue("A".equals(set_setorT.getSet_tx_status()));
    }

    public void btnUpdateAction(ButtonEvent ce) {
        set_setorT.setSet_tx_nome(set_tx_nome.getValue());
        set_setorT.setSet_tx_status(set_tx_status.getValue() ? "A" : "I");

        set_setorDao.alterar(set_setorT);
        Timer timer = new Timer() {
            public void run() {
                String msg = set_setorDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        modeloLoad.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        set_setorDao.excluir(set_setorT);
        Timer timer = new Timer() {

            public void run() {
                String msg = set_setorDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        modeloLoad.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }    

    /**
     * @return the setorPai
     */
    public Set_setorNewTGWT getSetorPai() {
        return setorPai;
    }

    /**
     * @param setorPai the setorPai to set
     */
    public void setSetorPai(Set_setorNewTGWT setorPai) {
        this.setorPai = setorPai;
    }
    
    /**
     * @return the modeloLoad
     */
    public IModeloLoad getModeloLoad() {
        return modeloLoad;
    }

    /**
     * @param modeloLoad the modeloLoad to set
     */
    public void setModeloLoad(IModeloLoad modeloLoad) {
        this.modeloLoad = modeloLoad;
    }
}
