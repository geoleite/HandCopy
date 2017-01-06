/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.set_setorNew;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.imagemanager.gwt.client.IModeloLoad;
import br.com.i9.imagemanager.gwt.client.dao.Set_setorNewDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorNewTGWT;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
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
public class Set_setorInsertGWT extends CadastrarBaseGWT {

    private IModeloLoad modeloLoad;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Set_setorNewDAOGWT set_setorDao = new Set_setorNewDAOGWT();
    private TextField<String> set_tx_nome = new TextField<String>();
    private CheckBox set_tx_status = new CheckBox();
    private Set_setorNewTGWT setorPai;
    private TreeStore<SetorTree> treeStore;
    private TreePanel<SetorTree> treePanel;
    private CheckBox cbNivel0 = new CheckBox();

    public Set_setorInsertGWT() {
        setHeading("Cadastrar Setor");
        this.setSize("380", "150");
        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(set_tx_nome);
        set_tx_nome.setWidth("250");

        getCpMaster().add(new LabelField("Status:"));
        getCpMaster().add(set_tx_status);
        set_tx_status.setBoxLabel("Ativo");
        set_tx_status.setValue(true);

        getCpMaster().add(new LabelField("Nivel:"));
        getCpMaster().add(cbNivel0);
        cbNivel0.setBoxLabel("Indica nivel zero");
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
        cbNivel0.setValue(setorPai == null);
    }
    public void btnInsertAction(ButtonEvent ce) {
        final Set_setorNewTGWT set_setorT = new Set_setorNewTGWT();
        set_setorT.setSet_tx_nome(set_tx_nome.getValue());
        set_setorT.setSet_tx_status(set_tx_status.getValue() ? "A" : "I");
        if (cbNivel0.getValue()) {
            set_setorT.setSet_nr_idsetorpai(0);
        } else {
            set_setorT.setSet_nr_idsetorpai(getSetorPai().getSet_nr_id());
        }
        set_setorDao.inserir(set_setorT);
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
                        btnLimpartAction(null);
                        getModeloLoad().load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        set_tx_nome.setValue("");
        set_tx_status.setValue(true);
    }

   
    /**
     * @return the treeStore
     */
    public TreeStore<SetorTree> getTreeStore() {
        return treeStore;
    }

    /**
     * @param treeStore the treeStore to set
     */
    public void setTreeStore(TreeStore<SetorTree> treeStore) {
        this.treeStore = treeStore;
    }

    /**
     * @return the treePanel
     */
    public TreePanel<SetorTree> getTreePanel() {
        return treePanel;
    }

    /**
     * @param treePanel the treePanel to set
     */
    public void setTreePanel(TreePanel<SetorTree> treePanel) {
        this.treePanel = treePanel;
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
