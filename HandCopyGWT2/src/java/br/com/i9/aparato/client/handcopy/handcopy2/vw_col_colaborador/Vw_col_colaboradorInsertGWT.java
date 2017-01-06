/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.vw_col_colaborador;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.dao.Pu_per_usuDAOGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.transfer.Pu_per_usuTGWT;
import br.com.i9.aparato.client.Constantes;
import br.com.i9.aparato.client.IModeloLoad;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Set_setorDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.set_setor.SelecionarSetorGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Set_setorTGWT;
import com.extjs.gxt.charts.client.model.Legend;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Timer;

public class Vw_col_colaboradorInsertGWT extends CadastrarBaseGWT implements IModeloLoad {

    private Vw_col_colaboradorConsultGWT vw_col_colaboradorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Vw_col_colaboradorDAOGWT vw_col_colaboradorDao = new Vw_col_colaboradorDAOGWT();
    private TextField<String> col_tx_nome = new TextField<String>();
    private TextField<String> col_tx_login = new TextField<String>();
    private CheckBox col_tx_status = new CheckBox();
    private TextField<String> col_tx_email = new TextField<String>();
    private Set_setorDAOGWT setDao = new Set_setorDAOGWT();
    private Set_setorTGWT set_setorTGWT;
    private Vw_col_colaboradorTGWT vw_col_colaboradorTGWT = new Vw_col_colaboradorTGWT();
    private ComboBox<Set_setorTGWT> cbSetor = new ComboBox<Set_setorTGWT>();
    private TextField<String> tfSenha = new TextField<String>();
    private TextField<String> tfConfSenha = new TextField<String>();
    private CheckBox chAdministrador = new CheckBox();
    private CheckBox chGestor = new CheckBox();
    private CheckBox chDiretor = new CheckBox();
    private CheckBox chChefe = new CheckBox();
    private CheckBox chColaborador = new CheckBox();
    private SelecionarSetorGWT selSetor = new SelecionarSetorGWT();
    private Sec_setor_colaboradorDAOGWT secDao = new Sec_setor_colaboradorDAOGWT();
    private Vw_col_colaboradorTGWT colT;

    public Vw_col_colaboradorInsertGWT() {

        add(getCpLeft(), getDataWEST());
        getDataWEST().setHidden(false);
        getDataWEST().setSize(250);
        getCpLeft().setVisible(true);
        getCpLeft().setLayout(new FitLayout());
        getCpLeft().setHeaderVisible(false);
        selSetor.setModeloLoad(this);
        getCpLeft().add(selSetor);


        setMinimizable(false);
        setMaximizable(false);
        setSize("600", "400");
        setHeading("Cadastrar Usuario");

        getCpMaster().setLayout(new TableLayout(1));
        definindoColaborador();
        definindoPerfis();
    }

    private void definindoColaborador() {
        FieldSet fs = new FieldSet();
        fs.setHeading("Dados Usuario");
        fs.setLayout(new TableLayout(2));

        fs.add(new LabelField("Nome:"));
        fs.add(col_tx_nome);
        col_tx_nome.setWidth("250");
        col_tx_nome.setAllowBlank(false);

        fs.add(new LabelField("Login:"));
        fs.add(col_tx_login);
        col_tx_login.setAllowBlank(false);


        fs.add(new LabelField("Status:"));
        fs.add(col_tx_status);
        col_tx_status.setValue(true);
        col_tx_status.setBoxLabel("Ativo");

        fs.add(new LabelField("Email:"));
        fs.add(col_tx_email);
        col_tx_email.setWidth("250");
        col_tx_email.setAllowBlank(false);

        fs.add(new LabelField("Senha:"));
        fs.add(tfSenha);
        tfSenha.setWidth("250");
        tfSenha.setAllowBlank(false);

        fs.add(new LabelField("Conf. Senha:"));
        fs.add(tfConfSenha);
        tfConfSenha.setWidth("250");
        tfConfSenha.setAllowBlank(false);

        tfSenha.setPassword(true);
        tfConfSenha.setPassword(true);
        getCpMaster().add(fs);
    }

    private void definindoPerfis() {
        FieldSet fs = new FieldSet();
        fs.setLayout(new TableLayout(2));
        fs.setHeading("Defina o Perfil do Usuario");
        fs.add(chAdministrador);
        fs.add(chGestor);
        fs.add(chDiretor);
        fs.add(chChefe);
        fs.add(chColaborador);

        chAdministrador.setBoxLabel("Administrador HandCopy");
        chGestor.setBoxLabel("Gestor HandCopy");
        chDiretor.setBoxLabel("Diretor HandCopy");
        chChefe.setBoxLabel("Chefe HandCopy");
        chColaborador.setBoxLabel("Usuario HandCopy");
        getCpMaster().add(fs);
    }

    private boolean valideSenha() {
        String senha = tfSenha.getValue();
        String confSenha = tfConfSenha.getValue();
        if (senha == null || senha.trim().length() < 4) {
            MessageBox.alert("Erro", "Senha nao pode ser em branco, e deve possui mais que 4 caracteres.", null);
        } else if (!senha.equals(confSenha)) {
            MessageBox.alert("Erro", "Senha nao confirmada.", null);
        } else {
            return true;
        }
        tfSenha.setValue("");
        tfConfSenha.setValue("");
        return false;
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (set_setorTGWT == null) {
            MessageBox.alert("Falha", "E necessario selecionar um setor no componente ao lado.", null);
        } else {
            if (valideSenha()) {
                vw_col_colaboradorTGWT = new Vw_col_colaboradorTGWT();
                vw_col_colaboradorTGWT.setCol_tx_nome(col_tx_nome.getValue());
                vw_col_colaboradorTGWT.setCol_tx_login(col_tx_login.getValue());
                vw_col_colaboradorTGWT.setCol_tx_status(col_tx_status.getValue() ? "A" : "I");
                vw_col_colaboradorTGWT.setCol_tx_email(col_tx_email.getValue());
                vw_col_colaboradorTGWT.setCol_tx_senha(tfSenha.getValue());
                vw_col_colaboradorTGWT.setCol_tx_confsenha(tfConfSenha.getValue());
                vw_col_colaboradorDao.inserir(vw_col_colaboradorTGWT);
                Timer timer = new Timer() {

                    public void run() {
                        String msg = vw_col_colaboradorDao.getMsg();
                        if (msg == null) {
                            schedule(500);
                        } else {
                            if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                MessageBox.alert("Problemas", msg, null);
                            } else {
                                Info.display("Resultado", msg);
                                vw_col_colaboradorDao.pesquisarbyLogin(vw_col_colaboradorTGWT);

                                Timer timer = new Timer() {

                                    @Override
                                    public void run() {
                                        colT = vw_col_colaboradorDao.getVw_col_colaboradorT();
                                        if (colT == null) {
                                            schedule(500);
                                        } else {
                                            Sec_setor_colaboradorTGWT secT = new Sec_setor_colaboradorTGWT();
                                            secT.setCol_nr_id(colT.getCol_nr_id());
                                            secT.setSet_nr_id(set_setorTGWT.getSet_nr_id());
                                            secDao.inserir(secT);
                                            Timer timer = new Timer() {

                                                @Override
                                                public void run() {
                                                    String msg = secDao.getMsg();
                                                    if (msg == null) {
                                                        schedule(500);
                                                    } else {
                                                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                                            vw_col_colaboradorDao.excluir(vw_col_colaboradorTGWT);
                                                            MessageBox.alert("Problemas", msg, null);
                                                        } else {
                                                            Pu_per_usuDAOGWT puDao = new Pu_per_usuDAOGWT();
                                                            Pu_per_usuTGWT puT = new Pu_per_usuTGWT();
                                                            puT.setUsu_nr_id(colT.getCol_nr_id());
                                                            if (chAdministrador.getValue()) {
                                                                puT.setPer_nr_id(Constantes.ADMINISTRADOR);
                                                                puDao.inserir(puT);
                                                            }
                                                            if (chGestor.getValue()) {
                                                                puT.setPer_nr_id(Constantes.GESTOR);
                                                                puDao.inserir(puT);
                                                            }
                                                            if (chDiretor.getValue()) {
                                                                puT.setPer_nr_id(Constantes.DIRETOR);
                                                                puDao.inserir(puT);
                                                            }
                                                            if (chChefe.getValue()) {
                                                                puT.setPer_nr_id(Constantes.CHEFE);
                                                                puDao.inserir(puT);
                                                            }
                                                            if (chColaborador.getValue()) {
                                                                puT.setPer_nr_id(Constantes.COLABORADOR);
                                                                puDao.inserir(puT);
                                                            }
                                                            vw_col_colaboradorConsult.load();
                                                            btnLimpartAction(null);
                                                            setVisible(false);
                                                        }
                                                    }
                                                }
                                            };
                                            timer.schedule(500);
                                        }
                                    }
                                };

                                timer.schedule(500);

                                setVisible(false);
                            }
                        }
                    }
                };

                timer.schedule(500);
            }
        }
    }

    public void btnLimpartAction(ButtonEvent ce) {
        col_tx_nome.setValue("");
        col_tx_login.setValue("");
        col_tx_status.setValue(true);
        col_tx_email.setValue("");
        tfSenha.setValue("");
        tfConfSenha.setValue("");
    }

    public Vw_col_colaboradorConsultGWT getVw_col_colaboradorConsult() {
        return vw_col_colaboradorConsult;
    }

    public void setVw_col_colaboradorConsult(Vw_col_colaboradorConsultGWT vw_col_colaboradorConsult) {
        this.vw_col_colaboradorConsult = vw_col_colaboradorConsult;
    }

    public void load() {
    }

    public void setSet_setorTGWT(Set_setorTGWT set_setorTGWT) {
        this.set_setorTGWT = set_setorTGWT;
    }
}
/*
 */
