/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.vw_col_colaborador;

import br.com.easynet.gwt.client.BaseGWT;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easyportal.gwt.client.i18n.EasyLabels;
import br.com.i9.aparato.client.Constantes;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.Vw_col_colaboradorDAOGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Vw_col_colaboradorTGWT;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class AlterarSenhaGWT extends BaseGWT {

    private EasyLabels easyLabels = GWT.create(EasyLabels.class);
    //private LabelField lblSenha = new LabelField(easyLabels.pass() + ":");
    private LabelField lblSenhaNew = new LabelField(easyLabels.newPass() + ":");
    private LabelField lblSenhaConfirm = new LabelField(easyLabels.confirmPass() + ":");
    //private TextField<String> pass = new TextField<String>();
    private TextField<String> passNew = new TextField<String>();
    private TextField<String> passConfirm = new TextField<String>();
//    private PasswordTextBox pass = new PasswordTextBox();
//    private PasswordTextBox passNew = new PasswordTextBox();
//    private PasswordTextBox passConfirm = new PasswordTextBox();
    private Button btnOk = new Button(easyLabels.alter());
    private Button btnClose = new Button(easyLabels.close());
    private MessageBox mbProgress = new MessageBox();
    private Vw_col_colaboradorTGWT colT;
    private Vw_col_colaboradorDAOGWT colDao = new Vw_col_colaboradorDAOGWT();

    public AlterarSenhaGWT() {
        setModal(true);
        setHeading(easyLabels.alterPass());
        setSize(300, 150);
        remove(getCpTop());
        remove(getCpBotton());
        remove(getCpLeft());
        remove(getCpRight());

        //pass.setPassword(true);
        passNew.setPassword(true);
        passConfirm.setPassword(true);

        getCpMaster().setLayout(new TableLayout(2));
        //getCpMaster().add(lblSenha);
        //getCpMaster().add(pass);
        getCpMaster().add(lblSenhaNew);
        getCpMaster().add(passNew);
        getCpMaster().add(lblSenhaConfirm);
        getCpMaster().add(passConfirm);
        getCpMaster().addButton(btnOk);
        getCpMaster().addButton(btnClose);
        btnOk.setIcon(ICONS.aplicar());

        btnOk.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                btnOkAction(be);
            }
        });

        btnClose.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                setVisible(false);
            }
        });


    }

    private boolean valideSenha() {
        String senha = passNew.getValue();
        String confSenha = passConfirm.getValue();
        if (senha == null || senha.trim().length() < 4) {
            MessageBox.alert("Erro", "Senha nao pode ser em branco, e deve possui mais que 4 caracteres.", null);
        } else if (!senha.equals(confSenha)) {
            MessageBox.alert("Erro", "Senha nao confirmada.", null);
        } else {
            return true;
        }
        passNew.setValue("");
        passConfirm.setValue("");
        return false;
    }

    public void btnOkAction(ButtonEvent sender) {
        colT.setCol_tx_senha(passNew.getValue());
        colT.setCol_tx_confsenha(passConfirm.getValue());
        if (valideSenha()) {
            colDao.alterarSenha(colT);
            Timer timer = new Timer() {

                @Override
                public void run() {
                    String msg = colDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                        }
                    }
                }
            };

            timer.schedule(500);
        }

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
