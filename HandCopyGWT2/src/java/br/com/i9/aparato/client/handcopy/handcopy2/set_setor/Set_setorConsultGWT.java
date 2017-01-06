/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.set_setorNew;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.imagemanager.gwt.client.IModeloLoad;
import br.com.i9.imagemanager.gwt.client.Util;
import br.com.i9.imagemanager.gwt.client.dao.Set_setorNewDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorNewTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorTGWT;

import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.ModelKeyProvider;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;

import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Set_setorConsultGWT extends CPConsultarBaseGWT implements IModeloLoad {

    private Set_setorNewDAOGWT set_setorDao = new Set_setorNewDAOGWT();
    private HashMap<Integer, Set_setorNewTGWT> setMap = new HashMap<Integer, Set_setorNewTGWT>();
    private TreePanel<SetorTree> treeSetor;
    private TreeStore<SetorTree> treeStore;
    private List<Set_setorNewTGWT> listSet;
    private Button btnRefresh = new Button("Atualizar");

    public Set_setorConsultGWT() {
        setHeaderVisible(false);
        //getToolBarMaster().remove(getBtnNovoSuper());
        btnRefresh.setIcon(ICONS.update());
        getToolBarMaster().add(btnRefresh);

        load();
        btnRefresh.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });
    }

    public void btnNovoAction(ButtonEvent be) {
        abrirJanelaInsert();
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
                    treeSetor.addListener(Events.OnClick, new SelectionListener<ComponentEvent>() {

                        @Override
                        public void componentSelected(ComponentEvent ce) {
                            Info.display("DEBUG", "clicou");
                        }
                    });
                    loader.load(root);
                    definirMenuSuspenso();
                    getCpMaster().add(treeSetor);
                    getCpMaster().layout();
                    treeSetor.expandAll();
                }
            }
        };

        timer.schedule(500);
    }

    private void abrirJanelaInsert() {
        SetorTree setor = treeSetor.getSelectionModel().getSelectedItem();
        Set_setorInsertGWT setInsert = new Set_setorInsertGWT();
        if (setor != null) {
            Set_setorNewTGWT setT = setMap.get(setor.getId());
            setInsert.setSetorPai(setT);
        } else {
        }
        setInsert.setModeloLoad(Set_setorConsultGWT.this);
        setInsert.setVisible(true);
    }

    private void definirMenuSuspenso() {
        Menu contextMenu = new Menu();

        MenuItem insert = new MenuItem();
        insert.setText("Cadastrar Setor");
        insert.setIcon(ICONS.add());
        insert.addSelectionListener(new SelectionListener<MenuEvent>() {

            public void componentSelected(MenuEvent ce) {
                abrirJanelaInsert();
//                SetorTree setor = treeSetor.getSelectionModel().getSelectedItem();
//                Set_setorInsertGWT setInsert = new Set_setorInsertGWT();
//                if (setor != null) {
//                    Set_setorTGWT setT = setMap.get(setor.getId());
//                    setInsert.setSetorPai(setT);
//                } else {
//                }
//                setInsert.setModeloLoad(Set_setorConsultGWT.this);
//                setInsert.setVisible(true);
            }
        });
        contextMenu.add(insert);

        MenuItem remove = new MenuItem();
        remove.setText("Editar Setor");
        remove.setIcon(ICONS.edit());
        remove.addSelectionListener(new SelectionListener<MenuEvent>() {

            public void componentSelected(MenuEvent ce) {
                SetorTree selected = treeSetor.getSelectionModel().getSelectedItem();
                Set_setorUpdateDeleteGWT set_setorUpdateDeleteGWT = new Set_setorUpdateDeleteGWT();
                set_setorUpdateDeleteGWT.setModeloLoad(Set_setorConsultGWT.this);
                Set_setorNewTGWT setT = setMap.get(selected.getId());
                set_setorUpdateDeleteGWT.setSetorPai(setT);
                set_setorUpdateDeleteGWT.load(setT);
                set_setorUpdateDeleteGWT.setVisible(true);
            }
        });
        contextMenu.add(remove);
        treeSetor.setContextMenu(contextMenu);
    }

    public void setSet_setorTGWT(Set_setorNewTGWT set_setorTGWT) {
    }

}
