/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client;

import br.com.easyportal.gwt.client.accordionModel.AMenuHandlerAccordion;
import br.com.easyportal.gwt.client.admin.portal.portal.sis_sistema.Sis_sistemaConsultGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.relatorio.Rel_UsuariosCadastrados;
import br.com.i9.aparato.client.handcopy.handcopy2.relatorio.Rel_UsuariosRequisicoes;
import br.com.i9.aparato.client.handcopy.handcopy2.relatorio.Rel_UsuariosRequisicoesPeriodo;
import br.com.i9.aparato.client.handcopy.handcopy2.relatorio.Rel_UsuariosSaldo;
import br.com.i9.aparato.client.handcopy.handcopy2.req_requisicao.Req_requisicaoConsultGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoConsultGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.ser_servico.Ser_servicoConsultSetorGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.set_setor.Set_setorConsultGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao.MinhasSolicitacoesGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.sol_solicitacao.Sol_solicitacaoInsertGWT;
import br.com.i9.aparato.client.handcopy.handcopy2.vw_col_colaborador.Vw_col_colaboradorConsultGWT;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class AdminHandCopyAccordion extends AMenuHandlerAccordion {

    private HashMap<String, TabItem> itens = new HashMap<String, TabItem>();

    public AdminHandCopyAccordion() {
        setSystem("HANDCOPY");
    }

    @Override
    public void actionEventMenu(Object me, String acao) {
        TabItem tabItem = null;
        tabItem = itens.get(acao);
        if (tabItem == null) {
            tabItem = new TabItem();
            tabItem.setClosable(true);
            tabItem.setLayout(new FitLayout());
            ContentPanel cp = new ContentPanel();
            cp.setFrame(false);
            cp.setBorders(false);
            cp.setHeaderVisible(false);
            cp.setBodyBorder(false);
            cp.setLayout(new FitLayout());
            if ("HANDCOPY.setor".equalsIgnoreCase(acao)) {
                tabItem.setText("Setores");
                cp.add(getSetores());
            } else if ("HANDCOPY.Servico".equalsIgnoreCase(acao)) {
                tabItem.setText("Servicos");
                cp.add(getServico());
            } else if ("HANDCOPY.AssociarSetorServico".equalsIgnoreCase(acao)) {
                tabItem.setText("Servicos Setor");
                cp.add(getServicoSetor());
            } else if ("HANDCOPY.Colaborador".equalsIgnoreCase(acao)) {
                tabItem.setText("Usuarios");
                cp.add(getVW_Colaborador());
            } else if ("HANDCOPY.Subordinados".equalsIgnoreCase(acao)) {
                tabItem.setText("Usuarios");
                cp.add(getVW_Colaborador());
            } else if ("HANDCOPY.MinhasSolicitacoes".equalsIgnoreCase(acao)) {
                tabItem.setText("Solicitacoes");
                cp.add(getMinhasSolicitacoes());
            } else if ("HANDCOPY.Requisicoes".equalsIgnoreCase(acao)) {
                tabItem.setText("Requisicoes");
                cp.add(getRequisicoes());
            } else if ("HANDCOPY.UsuCadRel".equalsIgnoreCase(acao)) {
                //tabItem.setText("Usuarios Cadastrados");
                //cp.add(getMinhasSolicitacoes());
                relUsuariosCadastrados();
                return;
            } else if ("HANDCOPY.UsuReqPeriodoRel".equalsIgnoreCase(acao)) {
                //tabItem.setText("Usuarios Cadastrados");
                //cp.add(getMinhasSolicitacoes());
                relUsuariosRequisicoesPeriodo();
                return;
            } else if ("HANDCOPY.UsuRequisicoesRel".equalsIgnoreCase(acao)) {
                //tabItem.setText("Usuarios Cadastrados");
                //cp.add(getMinhasSolicitacoes());
                relUsuariosRequisicoes();
                return;
            } else if ("HANDCOPY.UsuSaldoRel".equalsIgnoreCase(acao)) {
                //tabItem.setText("Usuarios Cadastrados");
                //cp.add(getMinhasSolicitacoes());
                relUsuariosSaldo();
                return;
            } else if ("HANDCOPY.NovaSolicitacao".equalsIgnoreCase(acao)) {
                Sol_solicitacaoInsertGWT sol_solicitacaoInsertGWT = new Sol_solicitacaoInsertGWT();
                sol_solicitacaoInsertGWT.setVisible(true);
                return;
            } else {
                MessageBox.alert("Opcão ainda não implementada", "Em breve esta opção estará disponível!", null);
            }
            if (cp != null) {
                tabItem.add(cp);
                //Adiciona o tabitem se não existir no tabPanel
                getPortalAccordionGWT().getTabPanel().add(tabItem);
                itens.put(acao, tabItem);
            }
        } else {
            TabItem tabTemp = getPortalAccordionGWT().getTabPanel().getItemByItemId(acao);
            if (tabTemp == null) {
                getPortalAccordionGWT().getTabPanel().add(tabItem);
            }
        }
        getPortalAccordionGWT().getTabPanel().setSelection(tabItem);
        //getPortalAccordionGWT().setHeight(com.google.gwt.user.client.Window.getClientHeight()-60);
        getPortalAccordionGWT().layout();
    }

    private void relUsuariosCadastrados() {
        Rel_UsuariosCadastrados rel = new Rel_UsuariosCadastrados();
        rel.setVisible(true);
    }
    private void relUsuariosSaldo() {
        Rel_UsuariosSaldo rel = new Rel_UsuariosSaldo();
        rel.setVisible(true);
    }

    private void relUsuariosRequisicoes() {
        Rel_UsuariosRequisicoes rel = new Rel_UsuariosRequisicoes();
        rel.setVisible(true);
    }
    private void relUsuariosRequisicoesPeriodo() {
        new Rel_UsuariosRequisicoesPeriodo();
    }
    
    private ContentPanel getServicoSetor() {
        return new Ser_servicoConsultSetorGWT();
    }

    private ContentPanel getRequisicoes() {
        return new Req_requisicaoConsultGWT();
    }

    private ContentPanel getMinhasSolicitacoes() {
        return new MinhasSolicitacoesGWT();
    }

    private ContentPanel getSetores() {
        return new Set_setorConsultGWT();
    }

    private ContentPanel getServico() {
        return new Ser_servicoConsultGWT();
    }

    private ContentPanel getVW_Colaborador() {
        return new Vw_col_colaboradorConsultGWT();
    }
}