/*
 * EasyNet JDragon
 */
package br.com.i9.aparato.client.handcopy.handcopy2.ser_servico;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Ser_servicoDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoInsertGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoUpdateDeleteGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Ser_servicoTGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Set_setorTGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Ser_servicoConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Ser_servicoDAOGWT ser_servicoDao = new Ser_servicoDAOGWT();
    private Button btnRefresh =  new Button("Atualizar");
    public Ser_servicoConsultGWT() {
        setHeaderVisible(false);
        btnRefresh.setIcon(ICONS.update());
        getToolBarMaster().add(btnRefresh);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Ser_servicoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ser_servicoTGWT>>(currency);
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

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("ser_tx_nome");
        column.setHeader("Nome");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);



        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        load();
        btnRefresh.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });
    }

    public void btnNovoAction(ButtonEvent be) {
        Ser_servicoInsertGWT ser_servicoInsertGWT = new Ser_servicoInsertGWT();
        ser_servicoInsertGWT.setSer_servicoConsult(this);
        ser_servicoInsertGWT.setModal(true);
        ser_servicoInsertGWT.show();

    }

    private GridCellRenderer<Ser_servicoTGWT> getEditarRender() {
        return new GridCellRenderer<Ser_servicoTGWT>() {

            private boolean init;

            public Object render(final Ser_servicoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ser_servicoTGWT> store, Grid<Ser_servicoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Ser_servicoTGWT>>() {

                        public void handleEvent(GridEvent<Ser_servicoTGWT> be) {
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
                        Ser_servicoUpdateDeleteGWT ser_servicoUpdateDeleteGWT = new Ser_servicoUpdateDeleteGWT();
                        ser_servicoUpdateDeleteGWT.setSer_servicoConsult(Ser_servicoConsultGWT.this);
                        ser_servicoUpdateDeleteGWT.load(model);
                        ser_servicoUpdateDeleteGWT.show();
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
        ser_servicoDao.consultarTodos();
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
