package br.com.i9.aparato.client.handcopy.handcopy2.vw_col_colaborador;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.i9.aparato.client.IModeloLoad;
import br.com.i9.aparato.client.handcopy.handcopy2.coc_cota_colaborador.Coc_cota_colaboradorConsultGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.set_setor.SelecionarSetorGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao.Sol_solicitacaoConsultGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Set_setorTGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

public class Vw_col_colaboradorConsultGWT extends CPConsultarBaseGWT implements IModeloLoad {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Vw_col_colaboradorDAOGWT vw_col_colaboradorDao = new Vw_col_colaboradorDAOGWT();
    private TextField<String> tfFind = new TextField<String>();
    private Button btnFind = new Button("Pesquisar");
    private SelecionarSetorGWT selSetor = new SelecionarSetorGWT();
    private Set_setorTGWT set_setorTGWT;
    private Sec_setor_colaboradorDAOGWT secDao = new Sec_setor_colaboradorDAOGWT();

    public Vw_col_colaboradorConsultGWT() {

        setBodyBorder(false);
        setFrame(false);
        setHeaderVisible(false);
        getDataNORTH().setSize(80);
        add(getCpTop(), getDataNORTH());
        getToolBarMaster().setHeight(25);

        getCpTop().setLayout(new FormLayout(FormPanel.LabelAlign.LEFT));
        tfFind.setFieldLabel("Nome");
        getCpTop().add(tfFind);
        getCpTop().addButton(btnFind);
        getCpTop().setButtonAlign(HorizontalAlignment.CENTER);
        btnFind.setIcon(ICONS.find());
        selSetor.setModeloLoad(this);
        add(getCpLeft(), getDataWEST());
        getDataWEST().setHidden(false);
        getDataWEST().setSize(250);
        getCpLeft().setVisible(true);
        getCpLeft().setLayout(new FitLayout());
        getCpLeft().setHeaderVisible(false);
        getCpLeft().add(selSetor);


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
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

//        column = new ColumnConfig();
//        column.setId("col_tx_email");
//        column.setHeader("Email");
//        column.setWidth(200);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);

        column = new ColumnConfig();
        column.setId("col_tx_status");
        column.setHeader("Status");
        column.setWidth(70);
        column.setRenderer(changeStatus);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgCotas");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getDefinirCotaRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgSolicitacoes");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getConsultarSolicitacoesRender());
        configs.add(column);

//        column = new ColumnConfig();
//        column.setId("imgPerfil");
//        column.setWidth(30);
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setRenderer(getPerfilRender());
//        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);


        column = new ColumnConfig();
        column.setId("imgDel");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getExcluirRender());

        configs.add(column);
        column = new ColumnConfig();
        column.setId("imgSenha");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getRedefinirSenhaRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgDelUsuarios");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getExcluirUsuarioRender());
        configs.add(column);

        btnFind.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });
    }

    public void btnNovoAction(ButtonEvent be) {
        Vw_col_colaboradorInsertGWT vw_col_colaboradorInsertGWT = new Vw_col_colaboradorInsertGWT();
        vw_col_colaboradorInsertGWT.setVw_col_colaboradorConsult(this);
        vw_col_colaboradorInsertGWT.setModal(true);
        vw_col_colaboradorInsertGWT.show();
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getEditarRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Vw_col_colaboradorUpdateDeleteGWT vw_col_colaboradorUpdateDeleteGWT = new Vw_col_colaboradorUpdateDeleteGWT();
                        vw_col_colaboradorUpdateDeleteGWT.setVw_col_colaboradorConsult(Vw_col_colaboradorConsultGWT.this);
                        vw_col_colaboradorUpdateDeleteGWT.load(model);
                        vw_col_colaboradorUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados do Usuario.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getDefinirCotaRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Coc_cota_colaboradorConsultGWT cocConsult = new Coc_cota_colaboradorConsultGWT();
                        Coc_cota_colaboradorTGWT cocT = new Coc_cota_colaboradorTGWT();
                        cocT.setCol_nr_id(model.getCol_nr_id());
                        cocConsult.setCoc_cota_colaboradorTGWT(cocT);
                        cocConsult.load();
                        cocConsult.setModal(true);
                        cocConsult.setVisible(true);
//                        Cot_cotaConsultGWT cot_cotaConsultGWT = new Cot_cotaConsultGWT();
//                        //cot_cotaConsultGWT.setOrg_orgaoTGWT(cbOrgao.getValue());
//                        cot_cotaConsultGWT.setVw_col_colaboradorTGWT(model);
//                        cot_cotaConsultGWT.loadServicos();
//                        cot_cotaConsultGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Definir Cotas do Usuario.");
                b.setIcon(ICONS.aplicar());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getConsultarSolicitacoesRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Sol_solicitacaoConsultGWT sol_solicitacaoConsultGWT = new Sol_solicitacaoConsultGWT();
                        sol_solicitacaoConsultGWT.setColT(model);
                        sol_solicitacaoConsultGWT.load();
                        sol_solicitacaoConsultGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Historido de solicitacoes do Usuario.");
                b.setIcon(ICONS.list_items());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getRedefinirSenhaRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        AlterarSenhaGWT alterarSenhaGWT = new AlterarSenhaGWT();
                        alterarSenhaGWT.setColT(model);
                        alterarSenhaGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Redefinir Senha.");
                b.setIcon(ICONS.chave());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getExcluirRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        if (set_setorTGWT == null) {
                            MessageBox.alert("Aviso", "E necessario selecionar um setor para remover um usuario!", null);
                        } else {
                            MessageBox.confirm("Aviso", "Confirma o remocao do usuario do setor?", new Listener<MessageBoxEvent>() {

                                public void handleEvent(MessageBoxEvent be) {

                                    if ("Yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                        Sec_setor_colaboradorTGWT secT = new Sec_setor_colaboradorTGWT();
                                        secT.setCol_nr_id(model.getCol_nr_id());
                                        secT.setSet_nr_id(set_setorTGWT.getSet_nr_id());

                                        secDao.excluir(secT);
                                        Timer timer = new Timer() {

                                            public void run() {
                                                String msg = secDao.getMsg();
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
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Remover Usuario do Setor.");
                b.setIcon(ICONS.delete());

                return b;
            }
        };
    }

    private GridCellRenderer<Vw_col_colaboradorTGWT> getExcluirUsuarioRender() {
        return new GridCellRenderer<Vw_col_colaboradorTGWT>() {

            public Object render(final Vw_col_colaboradorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_col_colaboradorTGWT> store, Grid<Vw_col_colaboradorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        if (set_setorTGWT == null) {
                            MessageBox.alert("Aviso", "E necessario selecionar um setor para remover um usuario do sistema!", null);
                        } else {
                            MessageBox.confirm("Aviso", "Confirma o remocao do usuario do sistema?", new Listener<MessageBoxEvent>() {

                                public void handleEvent(MessageBoxEvent be) {

                                    if ("Yes".equalsIgnoreCase(be.getButtonClicked().getText())) {

//                                        Sec_setor_colaboradorTGWT secT = new Sec_setor_colaboradorTGWT();
//                                        secT.setCol_nr_id(model.getCol_nr_id());
//                                        secT.setSet_nr_id(set_setorTGWT.getSet_nr_id());
//
//                                        secDao.excluir(secT);
                                        vw_col_colaboradorDao.excluirUsuario(model);
                                        Timer timer = new Timer() {

                                            public void run() {
                                                String msg = secDao.getMsg();
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
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Remover Usuario do Sistema.");
                b.setIcon(ICONS.delete());

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

        String nome = tfFind.getValue();
        Vw_col_colaboradorTGWT colT = new Vw_col_colaboradorTGWT();
        colT.setCol_tx_nome(nome);
        if (set_setorTGWT == null) {
            if (nome != null && nome.trim().length() > 0) {
                vw_col_colaboradorDao.pesquisarNome(colT);
            } else {
                vw_col_colaboradorDao.consultarTodos();
            }
        } else {
            if (nome != null && nome.trim().length() > 0) {
                vw_col_colaboradorDao.pesquisarSetorNome(set_setorTGWT.getSet_nr_id(), colT);
            } else {
                vw_col_colaboradorDao.pesquisarSetor(set_setorTGWT.getSet_nr_id());
            }
        }

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

/*
 *
 */
