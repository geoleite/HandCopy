/*
 * EasyNet JDragon
 */
package br.com.i9.aparato.client.handcopy.handcopy2.req_requisicao;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;


import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao.MinhasSolicitacoesGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao.Sol_solicitacaoInsertGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class Req_requisicaoConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Req_requisicaoDAOGWT req_requisicaoDao = new Req_requisicaoDAOGWT();
    private List<ColumnConfig> configsSol = new ArrayList<ColumnConfig>();
    private Sol_solicitacaoDAOGWT sol_solicitacaoDao = new Sol_solicitacaoDAOGWT();
    private Ser_servicoDAOGWT serDao = new Ser_servicoDAOGWT();
    private HashMap<Integer, Ser_servicoTGWT> serMap = new HashMap<Integer, Ser_servicoTGWT>();
    private BorderLayoutData dataNorte;
    private BorderLayoutData dataSul;
    private ContentPanel cpNorte = new ContentPanel();
    private ContentPanel cpSul = new ContentPanel();

    public Req_requisicaoConsultGWT() {
        setHeaderVisible(false);
        Info.display("DEBUG", "ponto0");
        getCpMaster().setLayout(new BorderLayout());
        dataNorte = new BorderLayoutData(LayoutRegion.NORTH, 300);
        dataSul = new BorderLayoutData(LayoutRegion.SOUTH, 300);
        dataNorte.setCollapsible(true);
        dataSul.setCollapsible(true);
        dataSul.setSplit(true);
        dataNorte.setMargins(new Margins(5, 5, 0, 5));
        dataSul.setMargins(new Margins(5, 5, 0, 5));
        getCpMaster().add(cpNorte, dataNorte);
        getCpMaster().add(cpSul, dataSul);

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Req_requisicaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Req_requisicaoTGWT>>(currency);
        /*
        GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
        public String render(Stock model, String property, ColumnData config, int rowIndex,
        int colIndex, ListStore<Stock> store) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
        }
        };
        GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
        public String render(Stock model, String property, ColumnData config, int rowIndex,
        int colIndex, ListStore<Stock> store) {
        return numberRenderer.render(null, property, model.get(property));
        }
        };
         */
        
        SummaryColumnConfig column = null;

        column = new SummaryColumnConfig("req_tx_identificador", "Identificador", 120);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig("req_tx_teriminal", "Terminal", 200);
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig("req_dt_requisitado", "Data/Hora", 100);
        column.setDateTimeFormat(DateTimeFormat.getFormat("HH:MM dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        Info.display("DEBUG", "ponto1");
        load();
        //configColunasSol();
    }

    private void configColunasSol() {
        GridCellRenderer<Sol_solicitacaoTGWT> changeServico = new GridCellRenderer<Sol_solicitacaoTGWT>() {

            public Object render(Sol_solicitacaoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Sol_solicitacaoTGWT> store, Grid<Sol_solicitacaoTGWT> grid) {
                return serMap.get(model.getSer_nr_id()).getSer_tx_nome();
            }
        };

        SummaryColumnConfig column = null;

        column = new SummaryColumnConfig("ser_nr_id", "Servico", 100);
        column.setHidden(true);
        column.setRenderer(changeServico);
        column.setAlignment(HorizontalAlignment.LEFT);
        configsSol.add(column);

        column = new SummaryColumnConfig("sol_dt_datahora", "Data/Hora", 100);
        column.setDateTimeFormat(DateTimeFormat.getFormat("HH:MM dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configsSol.add(column);

        column = new SummaryColumnConfig("sol_tx_idterminal", "Terminal", 100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configsSol.add(column);

        SummaryColumnConfig<Double> quantidade = new SummaryColumnConfig<Double>("sol_nr_quantidade", "Quant.", 60);
        quantidade.setSummaryType(SummaryType.SUM);
        quantidade.setSummaryRenderer(new SummaryRenderer() {

            public String render(Number value, Map<String, Number> data) {
                return "<b>" + value.intValue() + " unid.<b>";
            }
        });
        //quantidade.setEditor(new CellEditor(new NumberField()));
        configsSol.add(quantidade);

        //estimate.setEditor(new CellEditor(new NumberField()));
//        column = new ColumnConfig();
//        column.setId("sol_nr_quantidade");
//        column.setHeader("Quant.");
//        column.setWidth(80);
//        column.setAlignment(HorizontalAlignment.LEFT);

    }

    public void setVisible(boolean vs) {
        super.setVisible(vs);
        if (vs) {
            load();
        }
    }

    public void btnNovoAction(ButtonEvent be) {
        Sol_solicitacaoInsertGWT sol_solicitacaoInsertGWT = new Sol_solicitacaoInsertGWT();
        sol_solicitacaoInsertGWT.setVisible(true);
    }

    private GridCellRenderer<Req_requisicaoTGWT> getEditarRender() {
        return new GridCellRenderer<Req_requisicaoTGWT>() {

            public Object render(final Req_requisicaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Req_requisicaoTGWT> store, Grid<Req_requisicaoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Req_requisicaoUpdateDeleteGWT req_requisicaoUpdateDeleteGWT = new Req_requisicaoUpdateDeleteGWT();
                        req_requisicaoUpdateDeleteGWT.setReq_requisicaoConsult(Req_requisicaoConsultGWT.this);
                        req_requisicaoUpdateDeleteGWT.load(model);
                        req_requisicaoUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    public void load() {
        req_requisicaoDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Req_requisicaoTGWT> list = req_requisicaoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }
                    GroupingStore<Req_requisicaoTGWT> store = new GroupingStore<Req_requisicaoTGWT>();
                    for (int i = 0; i < list.getCount(); i++) {
                        store.add(list.getAt(i));
                    }
                    //store.groupBy("req_tx_identificador");

                    final ColumnModel cm = new ColumnModel(configs);
                    GroupSummaryView view = new GroupSummaryView();
                    view.setShowGroupedColumn(false);
                    view.setForceFit(true);
                    view.setGroupRenderer(new GridGroupRenderer() {

                        public String render(GroupColumnData data) {
                            //Info.display("DEBUHG", "ponto1 " + data.text);
                            //String servico = serMap.get(Integer.parseInt(data.group)).getSer_tx_nome();
                            String f = cm.getColumnById(data.field).getHeader();
                            String l = data.models.size() == 1 ? "Item" : "Items";
                            return f + ": " + data;
                            //return data.text;
                        }
                    });


                    Grid<Req_requisicaoTGWT> grid = new Grid<Req_requisicaoTGWT>(store, cm);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    grid.setView(view);
                    grid.getView().setShowDirtyCells(false);
                    grid.setLoadMask(true);
                    grid.getSelectionModel().addListener(Events.SelectionChange,
                            new Listener<SelectionChangedEvent<Req_requisicaoTGWT>>() {

                                public void handleEvent(SelectionChangedEvent<Req_requisicaoTGWT> be) {
                                    if (be.getSelection().size() > 0) {
                                        Info.display("DEBUG", be.getSelectedItem().getReq_tx_identificador());
                                        loadSol();
//                                        MinhasSolicitacoesGWT minhasSolicitacoesGWT = new MinhasSolicitacoesGWT();
//                                        getCpMaster().add(minhasSolicitacoesGWT);
                                    } else {
                                        //formBindings.unbind();
                                    }
                                }
                            });

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    Info.display("DEUBG", "ponto2");
                    cpNorte.add(grid);
                    //getCpMaster().add(grid);
                    //getCpMaster().layout();
                    cpNorte.layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void loadSol() {
        sol_solicitacaoDao.consultarMinhasSolicitacoes();
        serDao.consultarTodos();
        Timer timerServico = new Timer() {

            @Override
            public void run() {
                ListStore<Ser_servicoTGWT> listSer = serDao.getList();
                if (listSer == null) {
                    schedule(500);
                } else {
                    for (int i = 0; i < listSer.getCount(); i++) {
                        serMap.put(listSer.getAt(i).getSer_nr_id(), listSer.getAt(i));
                    }
                }
            }
        };
        timerServico.schedule(500);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Sol_solicitacaoTGWT> list = sol_solicitacaoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    GroupingStore<Sol_solicitacaoTGWT> store = new GroupingStore<Sol_solicitacaoTGWT>();
                    for (int i = 0; i < list.getCount(); i++) {
                        store.add(list.getAt(i));
                    }

                    store.groupBy("ser_nr_id");
                    final ColumnModel cm = new ColumnModel(configsSol);
                    GroupSummaryView view = new GroupSummaryView();
                    view.setShowGroupedColumn(false);
                    view.setForceFit(true);
                    view.setGroupRenderer(new GridGroupRenderer() {

                        public String render(GroupColumnData data) {
                            //Info.display("DEBUHG", "ponto1 " + data.text);
                            String servico = serMap.get(Integer.parseInt(data.group)).getSer_tx_nome();
                            String f = cm.getColumnById(data.field).getHeader();
                            String l = data.models.size() == 1 ? "Item" : "Items";
                            return f + ": " + servico + " (" + data.models.size() + " " + l + ")";
                            //return data.text;
                        }
                    });


//                    AggregationRowConfig<Sol_solicitacaoTGWT> averages = new AggregationRowConfig<Sol_solicitacaoTGWT>();
//                    averages.setHtml("name", "Total");
//
//                    // with summary type and format
//                    averages.setSummaryType("sol_nr_quantidade", SummaryType.SUM);
//                    averages.setSummaryFormat("sol_nr_quantidade", NumberFormat.getDecimalFormat());
//                    cm.addAggregationRow(averages);

                    EditorGrid<Sol_solicitacaoTGWT> grid = new EditorGrid<Sol_solicitacaoTGWT>(store, cm);
                    grid.setView(view);
                    grid.getView().setShowDirtyCells(false);
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    //getCpMaster().add(grid);
                    cpSul.add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }
}
