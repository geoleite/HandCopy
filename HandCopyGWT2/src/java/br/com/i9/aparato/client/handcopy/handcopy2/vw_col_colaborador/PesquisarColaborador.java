/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.vw_col_colaborador;

import br.com.easynet.gwt.client.BaseGWT;


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
public class PesquisarColaborador extends BaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Vw_col_colaboradorDAOGWT vw_col_colaboradorDao = new Vw_col_colaboradorDAOGWT();
    private Vw_col_colaboradorTGWT vw_col_colaboradorTGWT;

    public PesquisarColaborador() {

        getDataNORTH().setSplit(false);
        getDataSOUTH().setHidden(false);
        getCpBotton().setVisible(false);
        getCpBotton().setHideCollapseTool(false);

        getToolBarMaster().setHeight(20);
        remove(getCpTop());
        remove(getCpLeft());
        remove(getCpRight());
        getCpMaster().setTopComponent(getToolBarMaster());
        //getCpTop().setHeight(20);

        getCpBotton().setVisible(false);
        getCpTop().setHeaderVisible(false);
        getDataSOUTH().setHidden(true);

        this.remove(getCpBotton());

        setHeading("Pesquisar Colaborador");
        this.setSize("600", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Vw_col_colaboradorTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_col_colaboradorTGWT>>(currency);
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
        column.setId("col_tx_nome");
        column.setHeader("Nome");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("col_tx_login");
        column.setHeader("Login");
        column.setWidth(150);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);



        column = new ColumnConfig();
        column.setId("imgSelecionar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getSelecionarRender());
        configs.add(column);

        load();

    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getSelecionarRender() {
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

                        vw_col_colaboradorTGWT.setCol_nr_id(model.getCol_nr_id());
                        vw_col_colaboradorTGWT.setCol_tx_email(model.getCol_tx_email());
                        vw_col_colaboradorTGWT.setCol_tx_login(model.getCol_tx_login());
                        vw_col_colaboradorTGWT.setCol_tx_nome(model.getCol_tx_nome());
                        vw_col_colaboradorTGWT.setCol_tx_status(model.getCol_tx_status());
                        PesquisarColaborador.this.setVisible(false);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Selecionar Colaborador.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    public void load() {
        vw_col_colaboradorDao.consultarTodos();
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

    /**
     * @return the vw_col_colaboradorTGWT
     */
    public Vw_col_colaboradorTGWT getVw_col_colaboradorTGWT() {
        return vw_col_colaboradorTGWT;
    }

    /**
     * @param vw_col_colaboradorTGWT the vw_col_colaboradorTGWT to set
     */
    public void setVw_col_colaboradorTGWT(Vw_col_colaboradorTGWT vw_col_colaboradorTGWT) {
        this.vw_col_colaboradorTGWT = vw_col_colaboradorTGWT;
    }
}
