package br.com.i9.aparato.client.handcopy.handcopy2.vw_col_colaborador;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.dao.Per_perfilDAOGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.dao.Pu_per_usuDAOGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.transfer.Pu_per_usuTGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.transfer.Usu_usuarioTGWT;
import br.com.i9.aparato.client.Constantes;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Set_setorDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Set_setorTGWT;

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
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

public class Vw_col_colaboradorUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Vw_col_colaboradorConsultGWT vw_col_colaboradorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Vw_col_colaboradorDAOGWT vw_col_colaboradorDao = new Vw_col_colaboradorDAOGWT();
    private Vw_col_colaboradorTGWT vw_col_colaboradorT;
    private TextField<String> col_tx_nome = new TextField<String>();
    private TextField<String> col_tx_login = new TextField<String>();
    private CheckBox col_tx_status = new CheckBox();
    private TextField<String> col_tx_email = new TextField<String>();
    private Set_setorDAOGWT setDao = new Set_setorDAOGWT();
    private Set_setorTGWT setT = new Set_setorTGWT();
    private ComboBox<Set_setorTGWT> cbSetor = new ComboBox<Set_setorTGWT>();
    private CheckBox chAdministrador = new CheckBox();
    private CheckBox chGestor = new CheckBox();
    private CheckBox chDiretor = new CheckBox();
    private CheckBox chChefe = new CheckBox();
    private CheckBox chColaborador = new CheckBox();
    private Per_perfilDAOGWT perDao = new Per_perfilDAOGWT();

    public Vw_col_colaboradorUpdateDeleteGWT() {
        this.setSize("400", "350");
        setMinimizable(false);
        setMaximizable(false);
        setHeading("Alterar Usuario");

        getCpMaster().setLayout(new TableLayout(1));

        definindoColaborador();
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
        getCpMaster().add(fs);
    }

    private void definindoPerfis() {

        //Info.display("DEBUG", "ponto " + vw_col_colaboradorT.get("col_nr_id"));
        Usu_usuarioTGWT usuT = new Usu_usuarioTGWT();
        usuT.setUsu_nr_id(vw_col_colaboradorT.getCol_nr_id());
        perDao.perfisUsuario(usuT);
        //Info.display("DEBUG", "depois " + vw_col_colaboradorTGWT.get("col_nr_id"));
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Per_perfilTGWT> list = perDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    for (int i = 0; i < list.getCount(); i++) {
                        Per_perfilTGWT perT = list.getAt(i);
                        switch (perT.getPer_nr_id()) {
                            case Constantes.ADMINISTRADOR:
                                chAdministrador.setValue(true);
                                break;
                            case Constantes.GESTOR:
                                chGestor.setValue(true);
                                break;
                            case Constantes.DIRETOR:
                                chDiretor.setValue(true);
                                break;
                            case Constantes.CHEFE:
                                chChefe.setValue(true);
                                break;
                            case Constantes.COLABORADOR:
                                chColaborador.setValue(true);
                                break;
                        }
                        getCpMaster().layout();
                    }
                }
            }
        };
        timer.schedule(500);
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

    public void load(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
        this.vw_col_colaboradorT = vw_col_colaboradorT;
        col_tx_nome.setValue(vw_col_colaboradorT.getCol_tx_nome());
        col_tx_login.setValue(vw_col_colaboradorT.getCol_tx_login());
        col_tx_status.setValue("A".equals(vw_col_colaboradorT.getCol_tx_status()));
        col_tx_email.setValue(vw_col_colaboradorT.getCol_tx_email());
        definindoPerfis();
    }

    public void btnUpdateAction(ButtonEvent ce) {
        vw_col_colaboradorT.setCol_tx_nome(col_tx_nome.getValue());
        vw_col_colaboradorT.setCol_tx_login(col_tx_login.getValue());
        vw_col_colaboradorT.setCol_tx_status(col_tx_status.getValue() ? "A" : "I");
        vw_col_colaboradorT.setCol_tx_email(col_tx_email.getValue());

        vw_col_colaboradorDao.alterar(vw_col_colaboradorT);
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
                        Pu_per_usuDAOGWT puDao = new Pu_per_usuDAOGWT();                        
                        Pu_per_usuTGWT puT = new Pu_per_usuTGWT();
                        puT.setUsu_nr_id(vw_col_colaboradorT.getCol_nr_id());
                        puDao.excluirByUsuario(puT);
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
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        vw_col_colaboradorDao.excluir(vw_col_colaboradorT);
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
                        vw_col_colaboradorConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public Vw_col_colaboradorConsultGWT getVw_col_colaboradorConsult() {
        return vw_col_colaboradorConsult;
    }

    public void setVw_col_colaboradorConsult(Vw_col_colaboradorConsultGWT vw_col_colaboradorConsult) {
        this.vw_col_colaboradorConsult = vw_col_colaboradorConsult;
    }
}
