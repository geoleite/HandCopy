/*
 * EasyNet JDragon
 */
package br.com.i9.aparato.client.handcopy.handcopy2.ser_servico;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Ser_servicoDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Sst_servido_setorDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoInsertGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoUpdateDeleteGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Ser_servicoTGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Set_setorTGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Sst_servido_setorTGWT;

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
import com.extjs.gxt.ui.client.widget.MessageBox;
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
public class Ser_servicoConsultAddSetorGWT extends ConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Ser_servicoDAOGWT ser_servicoDao = new Ser_servicoDAOGWT();
    private Sst_servido_setorDAOGWT sstDao = new Sst_servido_setorDAOGWT();
    private Set_setorTGWT set_setorTGWT;
    private Ser_servicoConsultSetorGWT ser_servicoConsultSetorGWT;

    public Ser_servicoConsultAddSetorGWT() {
        getToolBarMaster().removeAll();
        setModal(true);
        setHeading("Adicionar Servico ao setor");
        this.setSize("450", "300");
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
        column.setWidth(350);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);



        column = new ColumnConfig();
        column.setId("imgAdd");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getAddRender());
        configs.add(column);

    }

    private GridCellRenderer<Ser_servicoTGWT> getAddRender() {
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
                        Sst_servido_setorTGWT sstT = new Sst_servido_setorTGWT();
                        sstT.setSer_nr_id(model.getSer_nr_id());
                        sstT.setSet_nr_id(set_setorTGWT.getSet_nr_id());
                        sstDao.inserir(sstT);
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
                                        ser_servicoConsultSetorGWT.load();
                                    }
                                }
                            }
                        };
                        timer.schedule(500);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Adiconar servico ao setor.");
                b.setIcon(ICONS.add());

                return b;
            }
        };
    }

    public void load() {
        ser_servicoDao.consultarByNaoSetor(set_setorTGWT.getSet_nr_id());
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

    /**
     * @return the ser_servicoConsultSetorGWT
     */
    public Ser_servicoConsultSetorGWT getSer_servicoConsultSetorGWT() {
        return ser_servicoConsultSetorGWT;
    }

    /**
     * @param ser_servicoConsultSetorGWT the ser_servicoConsultSetorGWT to set
     */
    public void setSer_servicoConsultSetorGWT(Ser_servicoConsultSetorGWT ser_servicoConsultSetorGWT) {
        this.ser_servicoConsultSetorGWT = ser_servicoConsultSetorGWT;
    }
}
