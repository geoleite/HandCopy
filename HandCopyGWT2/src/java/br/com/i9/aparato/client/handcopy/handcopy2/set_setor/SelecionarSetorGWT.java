/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.set_setorNew;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.imagemanager.gwt.client.IModeloLoad;
import br.com.i9.imagemanager.gwt.client.Util;
import br.com.i9.imagemanager.gwt.client.dao.Set_setorNewDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorNewTGWT;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class SelecionarSetorGWT extends CPConsultarBaseGWT implements IModeloLoad {

    private Set_setorNewDAOGWT set_setorDao = new Set_setorNewDAOGWT();
    private IModeloLoad modeloLoad;
    private Button btnRefresh = new Button("Atualizar");
    private HashMap<Integer, Set_setorNewTGWT> setMap = new HashMap<Integer, Set_setorNewTGWT>();
    private TreePanel<SetorTree> treeSetor;
    private TreeStore<SetorTree> treeStore;
    private List<Set_setorNewTGWT> listSet;

    public SelecionarSetorGWT() {
        getCpMaster().remove(getCpMaster().getBottomComponent());
        //getCpMaster().setBottomComponent(new LabelField("teste"));

        btnRefresh.setIcon(ICONS.update());
        getToolBarMaster().remove(getBtnNovoSuper());
        getToolBarMaster().add(btnRefresh);

        setHeaderVisible(false);
        load();
        btnRefresh.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });
    }

    private void montaTree(SetorTree setor) {
        List<Set_setorNewTGWT> filhos = getFilhos(setor.getId());
        for (Set_setorNewTGWT setT : filhos) {
            SetorTree newSetor = new SetorTree(setT.getSet_nr_id(), setT.getSet_tx_nome(), "");
            setor.add(newSetor);
            montaTree(newSetor);
        }
    }

    private List<Set_setorNewTGWT> getFilhos(int setNrId) {
        List<Set_setorNewTGWT> filhos = new ArrayList<Set_setorNewTGWT>();
        for (Set_setorNewTGWT set_setorTGWT : listSet) {
            if (set_setorTGWT.getSet_nr_idsetorpai() == setNrId) {
                filhos.add(set_setorTGWT);
            }
        }
        return filhos;
    }

    
    public void load() {
        set_setorDao.consultarTodos();
        Timer timer = new Timer() {

            @Override
            public void run() {
                getCpMaster().removeAll();
                ListStore<Set_setorNewTGWT> list = set_setorDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    listSet = new ArrayList<Set_setorNewTGWT>();
                    for (int i = 0; i < list.getCount(); i++) {
                        Set_setorNewTGWT setT = list.getAt(i);
                        listSet.add(setT);
                        setMap.put(setT.getSet_nr_id(), setT);
                    }
                    SetorTree root = new SetorTree(Util.getCodigoSetorRaiz(listSet), "", "");
                    montaTree(root);

                    TreeLoader<SetorTree> loader = new BaseTreeLoader<SetorTree>(new TreeModelReader<List<SetorTree>>());
                    treeStore = new TreeStore<SetorTree>(loader);
                    treeSetor = new TreePanel<SetorTree>(treeStore);
                    treeSetor.setStateful(true);
                    treeSetor.setAutoLoad(true);
                    treeSetor.setDisplayProperty("name");
                    loader.load(root);
                    definirMenuSuspenso();

                    
                    treeSetor.addListener(Events.OnClick, new Listener<BaseEvent>() {

                        public void handleEvent(BaseEvent be) {
                            SetorTree setor = treeSetor.getSelectionModel().getSelectedItem();
                            Set_setorNewTGWT setT = setMap.get(setor.getId());
                            modeloLoad.setSet_setorTGWT(setT);
                            modeloLoad.setSet_setorTGWT(setT);
                            modeloLoad.load();
                        }
                    });

                    getCpMaster().add(treeSetor);                    
                    getCpMaster().layout();
                    treeSetor.expandAll();
                }
            }
        };

        timer.schedule(500);
    }

    public void btnNovoAction(ButtonEvent be) {
        Set_setorInsertGWT setInsert = new Set_setorInsertGWT();
        SetorTree setor = treeSetor.getSelectionModel().getSelectedItem();
        Set_setorNewTGWT set_setorTGWT = new Set_setorNewTGWT();
        set_setorTGWT.setSet_nr_id(setor.getId());
        setInsert.setSetorPai(set_setorTGWT);
        setInsert.setTreePanel(treeSetor);
        //setInsert.setTreeStore(treeStore);
        setInsert.setVisible(true);
    }
    
    private void definirMenuSuspenso() {
        Menu contextMenu = new Menu();

        MenuItem insert = new MenuItem();
        insert.setText("Cadastrar Setor");
        insert.setIcon(ICONS.add());
        insert.addSelectionListener(new SelectionListener<MenuEvent>() {

            public void componentSelected(MenuEvent ce) {

                SetorTree setor = treeSetor.getSelectionModel().getSelectedItem();
                if (setor != null) {
                    //SetorTree novoSetor = new SetorTree(id, name, type);
                    //novoSetor.setSet_tx_nome("setor");
                    //treeStore.add(setor, novoSetor, false);
                    treeSetor.setExpanded(setor, true);
                    Set_setorInsertGWT setInsert = new Set_setorInsertGWT();
                    Set_setorNewTGWT setT = setMap.get(setor.getId());
                    setInsert.setSetorPai(setT);
                    setInsert.setModeloLoad(SelecionarSetorGWT.this);
                    //setInsert.setTreePanel(treeSetor);
                    //setInsert.setTreeStore(treeStore);
                    setInsert.setVisible(true);
                }
            }
        });
        contextMenu.add(insert);

        MenuItem remove = new MenuItem();
        remove.setText("Selecionar Setor");
        remove.setIcon(ICONS.edit());
        remove.addSelectionListener(new SelectionListener<MenuEvent>() {
            public void componentSelected(MenuEvent ce) {
//                SetorTree selected = treeSetor.getSelectionModel().getSelectedItem();
//                Set_setorTGWT setT = setMap.get(selected.getId());
//                Set_setorUpdateDeleteGWT set_setorUpdateDeleteGWT = new Set_setorUpdateDeleteGWT();
//                set_setorUpdateDeleteGWT.setSet_setorConsult(Set_setorConsultGWT.this);
//                set_setorUpdateDeleteGWT.setSetorPai(setT);
//                set_setorUpdateDeleteGWT.setTreePanel(treeSetor);
//                //set_setorUpdateDeleteGWT.setTreeStore(treeStore);
//                set_setorUpdateDeleteGWT.load(sel);
//                set_setorUpdateDeleteGWT.show();
            }
        });
        contextMenu.add(remove);
        treeSetor.setContextMenu(contextMenu);
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

    public void setSet_setorTGWT(Set_setorNewTGWT set_setorTGWT) {
        
    }
}
