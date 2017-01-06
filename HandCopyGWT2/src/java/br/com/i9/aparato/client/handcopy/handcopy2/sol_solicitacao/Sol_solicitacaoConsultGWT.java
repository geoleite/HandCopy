/*
 * EasyNet JDragon
 */
package br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;


import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
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
import java.util.Date;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class Sol_solicitacaoConsultGWT extends ConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Sol_solicitacaoDAOGWT sol_solicitacaoDao = new Sol_solicitacaoDAOGWT();
    private Ser_servicoDAOGWT serDao = new Ser_servicoDAOGWT();
    private Vw_col_colaboradorTGWT colT = new Vw_col_colaboradorTGWT();
    private HashMap<Integer, Ser_servicoTGWT> serMap = new HashMap<Integer, Ser_servicoTGWT>();

    public Sol_solicitacaoConsultGWT() {
        setModal(true);
        setHeading("Historico de Solicitacoes");
        this.setSize("650", "400");
        getCpMaster().setTopComponent(new LabelField(""));
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Sol_solicitacaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Sol_solicitacaoTGWT>>(currency);
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

        column = new SummaryColumnConfig("ser_nr_id", "Servico", 150);
        column.setHidden(true);
        column.setRenderer(changeServico);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig("sol_dt_datahora", "Data/Hora", 100);
        column.setDateTimeFormat(DateTimeFormat.getFormat("HH:MM dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig("sol_tx_idterminal", "Terminal", 100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig("sol_nr_quantidade", "Quant.", 80);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setSummaryType(SummaryType.SUM);
        column.setSummaryRenderer(new SummaryRenderer() {

            public String render(Number value, Map<String, Number> data) {
                return "<b>" + value.intValue() + " unid.<b>";
            }
        });
        configs.add(column);

        column = new SummaryColumnConfig("btnExcluir", "", 30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getBtnExcluir());
        configs.add(column);

    }

    private GridCellRenderer<Sol_solicitacaoTGWT> getBtnExcluir() {
        return new GridCellRenderer<Sol_solicitacaoTGWT>() {

            public Object render(final Sol_solicitacaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Sol_solicitacaoTGWT> store, Grid<Sol_solicitacaoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        MessageBox.confirm("Aviso", "Confirma o remocao do colaborador do setor?", new Listener<MessageBoxEvent>() {

                            public void handleEvent(MessageBoxEvent be) {

                                if ("Yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                    sol_solicitacaoDao.excluir(model);
                                    Timer timer = new Timer() {

                                        public void run() {
                                            String msg = sol_solicitacaoDao.getMsg();
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
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Excluir solicitacao do Usuario.");
                b.setIcon(ICONS.delete());

                return b;
            }
        };
    }

    public void btnNovoAction(ButtonEvent be) {
    }

    public void load() {
        Sol_solicitacaoTGWT solT = new Sol_solicitacaoTGWT();
        solT.setCol_nr_id(colT.getCol_nr_id());
        sol_solicitacaoDao.consultarPorColaborador(solT);
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


                    Grid<Sol_solicitacaoTGWT> grid = new Grid<Sol_solicitacaoTGWT>(store, cm);
                    grid.setView(view);
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

    /**
     * @return the colT
     */
    public Vw_col_colaboradorTGWT getColT() {
        return colT;
    }

    /**
     * @param colT the colT to set
     */
    public void setColT(Vw_col_colaboradorTGWT colT) {
        this.colT = colT;
    }
}
