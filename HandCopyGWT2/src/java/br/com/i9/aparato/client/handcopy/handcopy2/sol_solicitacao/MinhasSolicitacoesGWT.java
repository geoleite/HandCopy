/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;


import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
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
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class MinhasSolicitacoesGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Sol_solicitacaoDAOGWT sol_solicitacaoDao = new Sol_solicitacaoDAOGWT();
    private Ser_servicoDAOGWT serDao = new Ser_servicoDAOGWT();
    private HashMap<Integer, Ser_servicoTGWT> serMap = new HashMap<Integer, Ser_servicoTGWT>();
    private Button btnRefresh = new Button("Refresh");

    public MinhasSolicitacoesGWT() {
        setHeaderVisible(false);
        this.setSize("600", "400");
        //getCpMaster().setTopComponent(new LabelField(""));
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Sol_solicitacaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Sol_solicitacaoTGWT>>(currency);
        getToolBarMaster().add(btnRefresh);
        btnRefresh.setIcon(ICONS.update());
        btnRefresh.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });
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
        GridCellRenderer<Sol_solicitacaoTGWT> changeServico = new GridCellRenderer<Sol_solicitacaoTGWT>() {

            public Object render(Sol_solicitacaoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Sol_solicitacaoTGWT> store, Grid<Sol_solicitacaoTGWT> grid) {
                return serMap.get(model.getSer_nr_id()).getSer_tx_nome();
            }
        };


        SummaryColumnConfig column = null;

        column = new SummaryColumnConfig("ser_nr_id", "Servico", 100);
        column.setHidden(true);
//        column.setId("ser_nr_id");
//        column.setHeader("Servico");
//        column.setWidth(100);
        column.setRenderer(changeServico);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig("sol_dt_datahora", "Data/Hora", 100);
//        column.setId("sol_dt_datahora");
//        column.setHeader("Data/Hora");
//        column.setWidth(100);
        column.setDateTimeFormat(DateTimeFormat.getFormat("HH:MM dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig("sol_tx_idterminal", "Terminal", 100);
//        column.setId("sol_tx_idterminal");
//        column.setHeader("Terminal");
//        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        SummaryColumnConfig<Double> quantidade = new SummaryColumnConfig<Double>("sol_nr_quantidade", "Quant.", 60);
        quantidade.setSummaryType(SummaryType.SUM);
        quantidade.setSummaryRenderer(new SummaryRenderer() {

            public String render(Number value, Map<String, Number> data) {
                return "<b>" + value.intValue() + " unid.<b>";
            }
        });
        //quantidade.setEditor(new CellEditor(new NumberField()));
        configs.add(quantidade);

        //estimate.setEditor(new CellEditor(new NumberField()));
//        column = new ColumnConfig();
//        column.setId("sol_nr_quantidade");
//        column.setHeader("Quant.");
//        column.setWidth(80);
//        column.setAlignment(HorizontalAlignment.LEFT);
        load();
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

    public void load() {
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
                    final ColumnModel cm = new ColumnModel(configs);
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

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }
}
