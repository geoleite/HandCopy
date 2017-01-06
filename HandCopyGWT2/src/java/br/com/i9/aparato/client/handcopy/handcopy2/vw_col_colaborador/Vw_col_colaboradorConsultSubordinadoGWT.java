
/*
 * EasyNet JDragon
 *
package br.com.i9.aparato.client.handcopy.handcopy.vw_col_colaborador;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.aparato.client.handcopy.handcopy.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy.dao.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Ser_servicoDAOGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

public class Vw_col_colaboradorConsultSubordinadoGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Vw_col_colaboradorDAOGWT vw_col_colaboradorDao = new Vw_col_colaboradorDAOGWT();
    private Ser_servicoDAOGWT serDao = new Ser_servicoDAOGWT();
    private Cot_cotaDAOGWT cotDao  = new Cot_cotaDAOGWT();
    private FieldSet fsServicos = new FieldSet();
    private HashMap<Integer, Cot_cotaTGWT> cotMap = new HashMap<Integer, Cot_cotaTGWT>();

    public Vw_col_colaboradorConsultSubordinadoGWT() {
        setBodyBorder(false);
        setFrame(false);
        setHeaderVisible(false);
        getDataNORTH().setSize(100);
        add(getCpTop(), getDataNORTH());
        getToolBarMaster().setHeight(25);
        fsServicos.setLayout(new TableLayout(2));
        fsServicos.setHeading("Cotas por Servicos");
        getCpTop().add(fsServicos);

        LabelField lfCabec = new LabelField("Servico");
        fsServicos.add(lfCabec);
        lfCabec = new LabelField("Saldo");
        fsServicos.add(lfCabec);

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Vw_col_colaboradorTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_col_colaboradorTGWT>>(currency);
        

        GridCellRenderer<Vw_col_colaboradorTGWT> changeStatus = new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            public Object render(Vw_col_colaboradorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {
                return "A".equals(model.getCol_tx_status()) ? "Ativo" : "Inativo";
            }
        };

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("col_tx_nome");
        column.setHeader("Nome");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("col_tx_login");
        column.setHeader("Login");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("col_tx_email");
        column.setHeader("Email");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("col_tx_status");
        column.setHeader("Status");
        column.setWidth(100);
        column.setRenderer(changeStatus);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgCotas");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getDefinirContaRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgPerfil");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getPerfilRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgSenha");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getRedefinirSenhaRender());
        configs.add(column);

        load();
        
    }

    private void loadCotas() {
        cotDao.consultarByOrgaoSession();
        Timer timer = new Timer() {
            @Override
            public void run() {
                ListStore<Cot_cotaTGWT> list = cotDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    for (int i = 0; i < list.getCount(); i++) {
                        Cot_cotaTGWT cotT = list.getAt(i);
                        cotMap.put(cotT.getSer_nr_id(), cotT);
                    }
                    loadServicos();
                }
            }
        };
        timer.schedule(500);
    }

    private void loadServicos() {
        serDao.consultarOrgaoSession();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Ser_servicoTGWT> list = serDao.getList();
                if (list == null) {
                    schedule(500);
                } else {                    
                    for (int i = 0; i < list.getCount(); i++) {
                        Ser_servicoTGWT serT = list.getAt(i);
                        LabelField lf = new LabelField(serT.getSer_tx_nome());
                        //lf.setStyleName("font-style: oblique");
                        fsServicos.add(lf);
                        Cot_cotaTGWT cotT = cotMap.get(serT.getSer_nr_id());
                        lf = new LabelField(cotT.getCot_nr_saldo() + "");
                        //lf.setStyleName("font-style: oblique");
                        fsServicos.add(lf);
                    }
                    getCpTop().layout();
                }
            }
        };
        timer.schedule(500);
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getEditarRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            private boolean init;

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_col_colaboradorTGWT>>() {

                        public void handleEvent(GridEvent<Vw_col_colaboradorTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Vw_col_colaboradorUpdateDeleteGWT vw_col_colaboradorUpdateDeleteGWT = new Vw_col_colaboradorUpdateDeleteGWT();
                        //vw_col_colaboradorUpdateDeleteGWT.setVw_col_colaboradorConsult(Vw_col_colaboradorConsultGWT.this);
                        vw_col_colaboradorUpdateDeleteGWT.load(model);
                        vw_col_colaboradorUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getDefinirContaRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            private boolean init;

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_col_colaboradorTGWT>>() {

                        public void handleEvent(GridEvent<Vw_col_colaboradorTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Cot_cotaConsultGWT cot_cotaConsultGWT = new Cot_cotaConsultGWT();
                        //cot_cotaConsultGWT.setOrg_orgaoTGWT(cbOrgao.getValue());
                        cot_cotaConsultGWT.setVw_col_colaboradorTGWT(model);
                        cot_cotaConsultGWT.loadServicos();
                        cot_cotaConsultGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Definir Cotas do Usuario.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getRedefinirSenhaRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            private boolean init;

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_col_colaboradorTGWT>>() {

                        public void handleEvent(GridEvent<Vw_col_colaboradorTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Redefinir Senha.");
                b.setIcon(ICONS.chave());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getPerfilRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            private boolean init;

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_col_colaboradorTGWT>>() {

                        public void handleEvent(GridEvent<Vw_col_colaboradorTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        //Cot_cotaConsultGWT cot_cotaConsultGWT = new Cot_cotaConsultGWT();
                        //cot_cotaConsultGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar Perfil Colaborador.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    public void load() {
        vw_col_colaboradorDao.consultSubordinados();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Vw_col_colaboradorTGWT> list = vw_col_colaboradorDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Vw_col_colaboradorTGWT> grid = new Grid<Vw_col_colaboradorTGWT>(list, cm);
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

 /*
 */