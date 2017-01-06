/*
 * EasyNet JDragon
 */
package br.com.i9.aparato.client.handcopy.handcopy2.sst_servido_setor;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
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

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
/**
 *
 * @author geoleite
 */
public class Sst_servido_setorConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Sst_servido_setorDAOGWT sst_servido_setorDao = new Sst_servido_setorDAOGWT();
    public Sst_servido_setorConsultGWT() {
        
            this.setSize("500", "400");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Sst_servido_setorTGWT>> numberRenderer = new NumberCellRenderer<Grid<Sst_servido_setorTGWT>>(currency);
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
            column.setId("set_nr_id");
            column.setHeader("Set_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ser_nr_id");
            column.setHeader("Ser_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);



	    column = new ColumnConfig();
            column.setId("imgEditar");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getEditarRender());
            configs.add(column);

	load();

    }
    public void btnNovoAction(ButtonEvent be) {
        Sst_servido_setorInsertGWT sst_servido_setorInsertGWT = new Sst_servido_setorInsertGWT();
        sst_servido_setorInsertGWT.setSst_servido_setorConsult(this);
        sst_servido_setorInsertGWT.setModal(true);
        sst_servido_setorInsertGWT.show();

    }
    private GridCellRenderer<Sst_servido_setorTGWT> getEditarRender() {
        return new GridCellRenderer<Sst_servido_setorTGWT>() {

            private boolean init;

            public Object render(final Sst_servido_setorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Sst_servido_setorTGWT> store, Grid<Sst_servido_setorTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Sst_servido_setorTGWT>>() {

                        public void handleEvent(GridEvent<Sst_servido_setorTGWT> be) {
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
                        Sst_servido_setorUpdateDeleteGWT sst_servido_setorUpdateDeleteGWT = new Sst_servido_setorUpdateDeleteGWT();
                        sst_servido_setorUpdateDeleteGWT.setSst_servido_setorConsult(Sst_servido_setorConsultGWT.this);
                        sst_servido_setorUpdateDeleteGWT.load(model);
                        sst_servido_setorUpdateDeleteGWT.show();
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
    sst_servido_setorDao.consultarTodos();
    Timer timer = new Timer() {
            public void run() {
                ListStore<Sst_servido_setorTGWT> list = sst_servido_setorDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Sst_servido_setorTGWT> grid = new Grid<Sst_servido_setorTGWT>(list, cm);
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

