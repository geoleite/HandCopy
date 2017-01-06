/*
 * EasyNet JDragon
 */
package br.com.i9.aparato.client.handcopy.handcopy2.coc_cota_colaborador;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

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
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Coc_cota_colaboradorConsultGWT extends ConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Coc_cota_colaboradorDAOGWT coc_cota_colaboradorDao = new Coc_cota_colaboradorDAOGWT();
    private Coc_cota_colaboradorTGWT coc_cota_colaboradorTGWT;
    private Ser_servicoDAOGWT serDao = new Ser_servicoDAOGWT();
    private Cot_cotaDAOGWT cotDao = new Cot_cotaDAOGWT();
    private HashMap<Integer, Ser_servicoTGWT> serMap = new HashMap<Integer, Ser_servicoTGWT>();
    private HashMap<Integer, Cot_cotaTGWT> cotMap = new HashMap<Integer, Cot_cotaTGWT>();

    public Coc_cota_colaboradorConsultGWT() {
        setHeading("Cotas do Usuario");
        setMaximizable(false);
        setMinimizable(false);
        setResizable(false);

        getCpMaster().setTopComponent(new LabelField(""));
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Coc_cota_colaboradorTGWT>> numberRenderer = new NumberCellRenderer<Grid<Coc_cota_colaboradorTGWT>>(currency);
        /*
        GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
        public String render(Stock model, String property, ColumnData config, int rowIndex,
        int colIndex, ListStore<Stock> store) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
        }
        };
         */
        GridCellRenderer<Coc_cota_colaboradorTGWT> changeServico = new GridCellRenderer<Coc_cota_colaboradorTGWT>() {

            public Object render(Coc_cota_colaboradorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Coc_cota_colaboradorTGWT> store, Grid<Coc_cota_colaboradorTGWT> grid) {
                return serMap.get(model.getSer_nr_id()).getSer_tx_nome();
            }
        };

        GridCellRenderer<Coc_cota_colaboradorTGWT> changeCotaServico = new GridCellRenderer<Coc_cota_colaboradorTGWT>() {

            public Object render(Coc_cota_colaboradorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Coc_cota_colaboradorTGWT> store, Grid<Coc_cota_colaboradorTGWT> grid) {
                Cot_cotaTGWT cotT = cotMap.get(model.getCot_nr_id());
                return cotT.getCot_nr_saldo();
            }
        };

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("ser_nr_id");
        column.setHeader("Servico");
        column.setWidth(200);
        column.setRenderer(changeServico);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ser_nr_id");
        column.setHeader("Cota Serv.");
        column.setWidth(100);
        column.setRenderer(changeCotaServico);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("coc_nr_saldo");
        column.setHeader("Cota Col.");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);        
    }

    public void btnNovoAction(ButtonEvent be) {
        Coc_cota_colaboradorInsertGWT coc_cota_colaboradorInsertGWT = new Coc_cota_colaboradorInsertGWT();
        coc_cota_colaboradorInsertGWT.setCoc_cota_colaboradorConsult(this);
        coc_cota_colaboradorInsertGWT.setModal(true);
        coc_cota_colaboradorInsertGWT.show();
    }

    private GridCellRenderer<Coc_cota_colaboradorTGWT> getEditarRender() {
        return new GridCellRenderer<Coc_cota_colaboradorTGWT>() {

            public Object render(final Coc_cota_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Coc_cota_colaboradorTGWT> store, Grid<Coc_cota_colaboradorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Coc_cota_colaboradorUpdateDeleteGWT coc_cota_colaboradorUpdateDeleteGWT = new Coc_cota_colaboradorUpdateDeleteGWT();
                        coc_cota_colaboradorUpdateDeleteGWT.setCoc_cota_colaboradorConsult(Coc_cota_colaboradorConsultGWT.this);
                        coc_cota_colaboradorUpdateDeleteGWT.load(model);
                        coc_cota_colaboradorUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar cota do usuario.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    public void load() {
        coc_cota_colaboradorDao.consultarByColaborador(coc_cota_colaboradorTGWT);
        Timer timer = new Timer() {

            public void run() {
                final ListStore<Coc_cota_colaboradorTGWT> list = coc_cota_colaboradorDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    if (list.getCount() > 0) {
                        cotDao.consultarTodos();
                        Timer timeCota = new Timer() {
                            @Override
                            public void run() {
                                ListStore<Cot_cotaTGWT> listCot = cotDao.getList();
                                if (listCot == null) {
                                    schedule(500);
                                } else {
                                    for (int i = 0; i < listCot.getCount(); i++) {
                                        Cot_cotaTGWT cotT = listCot.getAt(i);
                                        cotMap.put(cotT.getCot_nr_id(), cotT);
                                    }
                                }
                            }
                        };
                        timeCota.schedule(500);
                        serDao.consultarTodos();
                        Timer timer = new Timer() {

                            @Override
                            public void run() {
                                ListStore<Ser_servicoTGWT> listSer = serDao.getList();
                                if (listSer == null) {
                                    schedule(500);
                                } else {
                                    for (int i = 0; i < listSer.getCount(); i++) {
                                        serMap.put(listSer.getAt(i).getSer_nr_id(), listSer.getAt(i));
                                    }
                                    List lista = getCpMaster().getItems();
                                    if (lista.size() > 0) {
                                        getCpMaster().removeAll();
                                    }

                                    ColumnModel cm = new ColumnModel(configs);
                                    Grid<Coc_cota_colaboradorTGWT> grid = new Grid<Coc_cota_colaboradorTGWT>(list, cm);
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
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the coc_cota_colaboradorTGWT
     */
    public Coc_cota_colaboradorTGWT getCoc_cota_colaboradorTGWT() {
        return coc_cota_colaboradorTGWT;
    }

    /**
     * @param coc_cota_colaboradorTGWT the coc_cota_colaboradorTGWT to set
     */
    public void setCoc_cota_colaboradorTGWT(Coc_cota_colaboradorTGWT coc_cota_colaboradorTGWT) {
        this.coc_cota_colaboradorTGWT = coc_cota_colaboradorTGWT;
    }
}
