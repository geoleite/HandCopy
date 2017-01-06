/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.ser_servico;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.aparato.client.IModeloLoad;
import br.com.i9.aparato.client.handcopy.handcopy2.cot_cota.Cot_cotaUpdateDeleteGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Cot_cotaDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Ser_servicoDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Sst_servido_setorDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoInsertGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoUpdateDeleteGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.set_setor.SelecionarSetorGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Cot_cotaTGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Ser_servicoTGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Set_setorTGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Sst_servido_setorTGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Ser_servicoConsultSetorGWT extends CPConsultarBaseGWT implements IModeloLoad {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Ser_servicoDAOGWT ser_servicoDao = new Ser_servicoDAOGWT();
    private Sst_servido_setorDAOGWT sstDao = new Sst_servido_setorDAOGWT();
    private Cot_cotaDAOGWT cotDao = new Cot_cotaDAOGWT();
    private Set_setorTGWT set_setorTGWT;
    private SelecionarSetorGWT selSetor = new SelecionarSetorGWT();
    private Button btnRefresh = new Button("Atualizar");

    public Ser_servicoConsultSetorGWT() {
        btnRefresh.setIcon(ICONS.update());
        getToolBarMaster().add(btnRefresh);

        getBtnNovoSuper().setText("Associar Servico ao Setor");
        getBtnNovoSuper().setTitle("Associar Servico ao Setor.");
        setHeaderVisible(false);
        this.setSize("500", "400");
        add(getCpLeft(), getDataWEST());
        getDataWEST().setHidden(false);
        getDataWEST().setSize(250);
        getCpLeft().setVisible(true);
        getCpLeft().setLayout(new FitLayout());
        getCpLeft().setHeaderVisible(false);
        getCpLeft().add(selSetor);

        selSetor.setModeloLoad(this);
        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("ser_tx_nome");
        column.setHeader("Nome");
        column.setWidth(350);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgCotas");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getCotasRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgRem");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getRemoverRender());
        configs.add(column);

        btnRefresh.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });
    }

    private GridCellRenderer<Ser_servicoTGWT> getRemoverRender() {
        return new GridCellRenderer<Ser_servicoTGWT>() {

            public Object render(final Ser_servicoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ser_servicoTGWT> store, Grid<Ser_servicoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        MessageBox.confirm("Aviso", "Confirma o remocao do servico no setor?", new Listener<MessageBoxEvent>() {

                            public void handleEvent(MessageBoxEvent be) {

                                if ("Yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                    Sst_servido_setorTGWT sstT = new Sst_servido_setorTGWT();
                                    sstT.setSer_nr_id(model.getSer_nr_id());
                                    sstT.setSet_nr_id(set_setorTGWT.getSet_nr_id());
                                    sstDao.excluir(sstT);
                                    Timer timer = new Timer() {

                                        public void run() {
                                            String msg = sstDao.getMsg();
                                            if (msg == null) {
                                                schedule(500);
                                            } else {
                                                if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                                    MessageBox.alert("Problemas", msg, null);
                                                } else {
                                                    Info.display("Resultado", msg);
                                                    load();
                                                }
                                            }
                                        }
                                    };
                                    timer.schedule(500);
                                }
                            }
                        });
                        //Info.display("DEbug", model.getSer_tx_nome());
                        load();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Remover servico do setor.");
                b.setIcon(ICONS.delete());

                return b;
            }
        };
    }

    private GridCellRenderer<Ser_servicoTGWT> getCotasRender() {
        return new GridCellRenderer<Ser_servicoTGWT>() {

            public Object render(final Ser_servicoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ser_servicoTGWT> store, Grid<Ser_servicoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Cot_cotaTGWT cotT = new Cot_cotaTGWT();
                        cotT.setSer_nr_id(model.getSer_nr_id());
                        cotT.setSet_nr_id(set_setorTGWT.getSet_nr_id());
                        cotDao.pesquisarSetorServico(cotT);
                        Timer timer = new Timer() {

                            @Override
                            public void run() {
                                Cot_cotaTGWT cotTemp = cotDao.getCot_cotaT();
                                if (cotTemp == null) {
                                    schedule(500);
                                } else {
                                    Cot_cotaUpdateDeleteGWT cot_cotaUpdateDeleteGWT = new Cot_cotaUpdateDeleteGWT();
                                    cot_cotaUpdateDeleteGWT.setSer_servicoTGWT(model);
                                    cot_cotaUpdateDeleteGWT.setSet_setorTGWT(set_setorTGWT);
                                    cot_cotaUpdateDeleteGWT.load(cotTemp);
                                    cot_cotaUpdateDeleteGWT.setVisible(true);
                                }
                            }
                        };
                        timer.schedule(500);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Definir Cotas do servico para o setor.");
                b.setIcon(ICONS.update());

                return b;
            }
        };
    }

    public void btnNovoAction(ButtonEvent be) {
        if (set_setorTGWT == null) {
            MessageBox.alert("Falha", "E necessario selecionar um setor no componente ao lado.", null);
        } else {
            Ser_servicoConsultAddSetorGWT ser_servicoConsultAddSetorGWT = new Ser_servicoConsultAddSetorGWT();
            ser_servicoConsultAddSetorGWT.setSer_servicoConsultSetorGWT(this);
            ser_servicoConsultAddSetorGWT.setSet_setorTGWT(set_setorTGWT);
            ser_servicoConsultAddSetorGWT.load();
            ser_servicoConsultAddSetorGWT.setVisible(true);
        }
    }

    public void load() {
        Timer timerSetor = new Timer() {

            @Override
            public void run() {
                if (set_setorTGWT == null || set_setorTGWT.getSet_nr_id() == 0) {
                    schedule(500);
                } else {
                    ser_servicoDao.consultarBySetor(set_setorTGWT.getSet_nr_id());
                    Timer timer = new Timer() {

                        public void run() {
                            ListStore<Ser_servicoTGWT> list = ser_servicoDao.getList();
                            if (list == null) {
                                schedule(500);
                            } else {
                                List lista = getCpMaster().getItems();
                                if (lista.size() > 0) {
                                    getCpMaster().removeAll();
                                }

                                ColumnModel cm = new ColumnModel(configs);

                                Grid<Ser_servicoTGWT> grid = new Grid<Ser_servicoTGWT>(list, cm);
                                grid.setLoadMask(true);

                                grid.setStyleAttribute("borderTop", "none");
                                grid.setBorders(true);
                                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                                getCpMaster().add(grid);
                                getCpMaster().layout();
                            }
                        }
                    };
                    timer.schedule(500);
                }
            }
        };
        timerSetor.schedule(500);
    }

    /**
     * @return the set_setorTGWT
     */
    public Set_setorTGWT getSet_setorTGWT() {
        return set_setorTGWT;
    }

    /**
     * @param set_setorTGWT the set_setorTGWT to set
     */
    public void setSet_setorTGWT(Set_setorTGWT set_setorTGWT) {
        this.set_setorTGWT = set_setorTGWT;
    }
}
