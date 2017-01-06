/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.*;
import br.com.i9.aparato.client.handcopy.handcopy2.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.relatorio.Rel_TicketSolicitacao;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.Timer;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Sol_solicitacaoInsertGWT extends CadastrarBaseGWT {

    private Sol_solicitacaoConsultGWT sol_solicitacaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Sol_solicitacaoDAOGWT sol_solicitacaoDao = new Sol_solicitacaoDAOGWT();
    private Ser_servicoDAOGWT serDao = new Ser_servicoDAOGWT();
    private ComboBox<Ser_servicoTGWT> cbServico = new ComboBox<Ser_servicoTGWT>();
    private NumberField[] nfQnts = null;
    private Ser_servicoTGWT[] servicos;
    private Set_setorDAOGWT setDao = new Set_setorDAOGWT();
    private Coc_cota_colaboradorDAOGWT cocDao = new Coc_cota_colaboradorDAOGWT();
    private HashMap<Integer, Coc_cota_colaboradorTGWT> treeCoc = new HashMap<Integer, Coc_cota_colaboradorTGWT>();
    private int contEnviar = 0;
    private int contEnviado = 0;
    private ContentPanel cpCabecalho = new ContentPanel();
    private ContentPanel cpGrid = new ContentPanel();
    private LabelField lfEmpresa = new LabelField();
    private LabelField lfSetor = new LabelField();

    public Sol_solicitacaoInsertGWT() {

        setModal(true);
        setHeading("Solicitacao de Servicos");
        this.setSize("450", "350");
        getCpMaster().setLayout(new TableLayout(1));
        TableLayout tlCabec = new TableLayout(1);
        tlCabec.setCellPadding(3);
        cpCabecalho.setWidth(getWidth()-10);
        cpCabecalho.setLayout(tlCabec);
        cpCabecalho.setHeaderVisible(false);
        cpCabecalho.setBodyBorder(false);
        cpCabecalho.setFrame(false);
        cpCabecalho.setBorders(false);
        cpCabecalho.add(lfEmpresa);
        //cpCabecalho.add(new LabelField("Setor:"));
        cpCabecalho.add(lfSetor);
        getCpMaster().add(cpCabecalho);

        TableLayout tl = new TableLayout(3);
        tl.setCellPadding(3);
        cpGrid.setWidth(getWidth()-10);
        cpGrid.setLayout(tl);
        cpGrid.setHeaderVisible(false);
        cpGrid.setBodyBorder(false);
        cpGrid.setFrame(false);
        cpGrid.setBorders(false);
        cpGrid.add(new LabelField("Serviços Disponíveis"));
        cpGrid.add(new LabelField("Definir Quantidade"));
        cpGrid.add(new LabelField("Saldo"));
        getCpMaster().add(cpGrid);
/*
        getCpMaster().add(new LabelField("Servico:"));
        getCpMaster().add(cbServico);
        cbServico.setDisplayField("ser_tx_nome");
        cbServico.setWidth("250");
        cbServico.setEmptyText("Selecione um Servico");
        cbServico.setTypeAhead(true);
        cbServico.setTriggerAction(ComboBox.TriggerAction.ALL);

        getCpMaster().add(new LabelField("Quantidade:"));
        getCpMaster().add(sol_nr_quantidade);
        sol_nr_quantidade.setValue("0");
*/
        loadCotasAtualizadas();
        loadSetorRaiz();
    }

    private void loadSetor() {
        setDao.obtendoSetorColaborador();
        Timer timer = new Timer() {

            @Override
            public void run() {
                Set_setorTGWT setT = setDao.getSet_setorT();
                if (setT == null) {
                    schedule(500);
                } else {
                    lfSetor.setText("Setor: "+ setT.getSet_tx_nome());
                    cpCabecalho.layout();
                }
            }
        };
        timer.schedule(500);
    }

    private void loadSetorRaiz() {
        setDao.obtendoSetorRaizColaborador();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Set_setorTGWT> list = setDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    if (list.getCount() > 0) {
                        Set_setorTGWT setT = list.getAt(0);
                        lfEmpresa.setText(setT.getSet_tx_nome());
                        loadSetor();
                    }
                }
            }
        };
        timer.schedule(500);
    }

    private void loadCotasAtualizadas() {
        cocDao.consultarMeusSaldosAtualizados();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Coc_cota_colaboradorTGWT> list = cocDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    for (int i = 0; i < list.getCount(); i++) {
                        Coc_cota_colaboradorTGWT cocT = list.getAt(i);
                        treeCoc.put(cocT.getSer_nr_id(), cocT);
                    }
                    loadServicos();
                }
            }
        };
        timer.schedule(500);
    }

    private void loadServicos() {
        serDao.consultarColaborador();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Ser_servicoTGWT> list = serDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    nfQnts = new NumberField[list.getCount()];
                    servicos = new Ser_servicoTGWT[list.getCount()];
                    for (int i = 0; i < list.getCount(); i++) {
                        Ser_servicoTGWT serT = list.getAt(i);
                        servicos[i] = serT;
                        cpGrid.add(new LabelField(serT.getSer_tx_nome()));
                        NumberField nfSer = new NumberField();
                        nfQnts[i] = nfSer;
                        nfSer.setValue(0);
                        nfSer.setTitle("Defina a quantidade desejada para o servico " + serT.getSer_tx_nome() + " ou informe 0 para não solicitar o servico!");
                        cpGrid.add(nfSer);
                        String valor = "0";
                        Coc_cota_colaboradorTGWT cocT = treeCoc.get(serT.getSer_nr_id());
                        if (cocT != null) {
                            valor = cocT.getCoc_nr_saldo() + "";
                        }
                        cpGrid.add(new LabelField(valor));
                    }
                    //cbServico.setStore(list);
                    //cbServico.getListView().refresh();
                    Sol_solicitacaoInsertGWT.this.layout();
                }
            }
        };
        timer.schedule(500);
    }

    private boolean validarQuantidades() {
        contEnviar = 0;
        for (int i = 0; i < nfQnts.length; i++) {
            NumberField numberField = nfQnts[i];
            Ser_servicoTGWT serT = servicos[i];
            Coc_cota_colaboradorTGWT cocT = treeCoc.get(serT.getSer_nr_id());
            int valor = numberField.getValue().intValue();
            if (valor < 0 || valor > cocT.getCoc_nr_saldo()) {
                return false;
            } else if (valor > 0) {
                contEnviar++;
            }
        }
        return true;
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (!validarQuantidades()) {
            MessageBox.alert("Falha", "As quantidades solicitadas para os servicos  devem ser maior que zero e menor ou igual ao saldo atual.", null);
        } else {
            for (int i = 0; i < nfQnts.length; i++) {
                NumberField numberField = nfQnts[i];
                Ser_servicoTGWT serT = servicos[i];
                Coc_cota_colaboradorTGWT cocT = treeCoc.get(serT.getSer_nr_id());
                int valor = numberField.getValue().intValue();
                if (valor > 0) {
                    if (valor <= cocT.getCoc_nr_saldo()) {                        
                        Sol_solicitacaoTGWT sol_solicitacaoT = new Sol_solicitacaoTGWT();
                        sol_solicitacaoT.setSer_nr_id(serT.getSer_nr_id());
                        sol_solicitacaoT.setSol_nr_quantidade(valor);
                        sol_solicitacaoDao.inserir(sol_solicitacaoT);
                        Timer timer = new Timer() {

                            public void run() {
                                String msg = sol_solicitacaoDao.getMsg();
                                if (msg == null) {
                                    schedule(500);
                                } else {
                                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                        MessageBox.alert("Problemas", msg, null);
                                    } else {
                                        contEnviado++;
                                        Info.display("Resultado", msg);
                                        btnLimpartAction(null);
                                        //sol_solicitacaoConsult.load();
                                        setVisible(false);
                                        
                                        if (contEnviar == contEnviado) {
                                            Rel_TicketSolicitacao relTicket = new Rel_TicketSolicitacao();
                                            relTicket.setVisible(true);
                                        }
                                    }
                                }
                            }
                        };
                        timer.schedule(500);
                    } else {
                        MessageBox.alert("Falha", "A quantidade solicitada para o servico " + serT.getSer_tx_nome() + " deve ser maior que zero e menor ou igual ao saldo atual.", null);
                    }
                }
            }
        }
//        Ser_servicoTGWT serT = cbServico.getValue();
//        Sol_solicitacaoTGWT sol_solicitacaoT = new Sol_solicitacaoTGWT();
//        sol_solicitacaoT.setSer_nr_id(serT.getSer_nr_id());
//
//        //sol_solicitacaoT.setSol_tx_idterminal(sol_tx_idterminal.getValue());
//        sol_solicitacaoT.setSol_nr_quantidade(Integer.parseInt(sol_nr_quantidade.getValue()));
//
//        sol_solicitacaoDao.inserir(sol_solicitacaoT);
//        Timer timer = new Timer() {
//
//            public void run() {
//                String msg = sol_solicitacaoDao.getMsg();
//                if (msg == null) {
//                    schedule(500);
//                } else {
//                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
//                        MessageBox.alert("Problemas", msg, null);
//                    } else {
//                        Info.display("Resultado", msg);
//                        btnLimpartAction(null);
//                        //sol_solicitacaoConsult.load();
//                        setVisible(false);
//                    }
//                }
//            }
//        };
//        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        //sol_nr_quantidade.setValue("0");
        for (int i = 0; nfQnts != null && i < nfQnts.length; i++) {
            nfQnts[i].setValue(0);
        }
    }

    /**
     * @return the sol_solicitacaoConsult
     */
    public Sol_solicitacaoConsultGWT getSol_solicitacaoConsult() {
        return sol_solicitacaoConsult;
    }

    /**
     * @param sol_solicitacaoConsult the sol_solicitacaoConsult to set
     */
    public void setSol_solicitacaoConsult(Sol_solicitacaoConsultGWT sol_solicitacaoConsult) {
        this.sol_solicitacaoConsult = sol_solicitacaoConsult;
    }
}
