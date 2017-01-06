package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import java.sql.Timestamp;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sol_solicitacaoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Sol_solicitacaoT sol_solicitacaoT = new Sol_solicitacaoT();

    public void setSol_solicitacaoT(Sol_solicitacaoT sol_solicitacaoT) {
        this.sol_solicitacaoT = sol_solicitacaoT;
    }

    public Sol_solicitacaoT getSol_solicitacaoT() {
        return sol_solicitacaoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        //consultCoc_cota_colaborador();

    }

    private Coc_cota_colaboradorT getCotaColaborador() throws Exception {
        Set_setorT setT = (Set_setorT) getSession().getAttribute(SETOR);
        Coc_cota_colaboradorT cocT = new Coc_cota_colaboradorT();
        cocT.setSer_nr_id(sol_solicitacaoT.getSer_nr_id());
        cocT.setSet_nr_id(setT.getSet_nr_id());
        cocT.setCol_nr_id(getUsuarioLogado().getUsu_nr_id());
        List<Coc_cota_colaboradorT> listCoc = getCoc_cota_colaboradorDAO().getByServicoSetorColaborador(cocT);
        return listCoc.size() > 0 ? listCoc.get(0) : null;
    }
    // M?todos de Eventos

    private String valideSolicitacao(Coc_cota_colaboradorT cocT) throws Exception {
        String result = null;
        sol_solicitacaoT.setCol_nr_id(cocT.getCol_nr_id());
        sol_solicitacaoT.setSet_nr_id(cocT.getSet_nr_id());
        sol_solicitacaoT.setCot_nr_id(cocT.getCot_nr_id());
        int totalSolicitado = getSol_solicitacaoDAO().getTotalSolicitadoColaborador(sol_solicitacaoT);
        if ((sol_solicitacaoT.getSol_nr_quantidade() + totalSolicitado) > cocT.getCoc_nr_saldo()) {
            int totalDisponivel = cocT.getCoc_nr_saldo() - totalSolicitado;
            result = "Falha ao realizar solicitacao. Esta solicitacao ultrapassa a cota do colaborador. Disponivel " + totalDisponivel;
        }
        return result;
    }

    private void addSession(Sol_solicitacaoT solT) {
        List<Sol_solicitacaoT> listSol = (List<Sol_solicitacaoT>)getSession().getAttribute(SOLICITACAO_IMPRESSAO);
        if (listSol == null) {
            listSol = new ArrayList<Sol_solicitacaoT>();
            getSession().setAttribute(SOLICITACAO_IMPRESSAO, listSol);
        }
        listSol.add(solT);
    }
    public void insert() throws Exception {

        try {
            Coc_cota_colaboradorT cocT = getCotaColaborador();
            if (cocT == null) {
                setMsg(ERROR, "Falha ao realizar cadastro, nao foi encontrado cota para este servico!");
            } else {
                String mensagem = valideSolicitacao(cocT);
                if (mensagem != null) {
                    setMsg(ERROR, mensagem);
                } else {
                    Req_requisicaoT reqT = new Req_requisicaoT();
                    reqT.setReq_dt_requisitado(new Timestamp(System.currentTimeMillis()));
                    reqT.setReq_tx_teriminal(getRequest().getRemoteAddr());
                    reqT.setReq_tx_identificador(System.currentTimeMillis()+"");
                    reqT.setCol_nr_id(sol_solicitacaoT.getCol_nr_id());
                    getReq_requisicaoDAO().insert(reqT);
                    Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
                    sol_solicitacaoT.setReq_nr_id(reqT.getReq_nr_id());
                    sol_solicitacaoT.setSol_tx_idterminal(reqT.getReq_tx_teriminal());
                    sol_solicitacaoT.setSol_dt_datahora(reqT.getReq_dt_requisitado());
                    sol_solicitacaoDAO.insert(sol_solicitacaoT);
                    addSession(sol_solicitacaoT);
                    setMsg(INFO, "Cadastro efetuado com sucesso!");
                    clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Coc_cota_colaboradorT> listcoc_cota_colaborador;

    public List<Coc_cota_colaboradorT> getListcoc_cota_colaborador() {
        return listcoc_cota_colaborador;
    }

    public void setListcoc_cota_colaborador(List<Coc_cota_colaboradorT> list) {
        this.listcoc_cota_colaborador = list;
    }

    public void consultCoc_cota_colaborador() throws Exception {
        try {
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
            listcoc_cota_colaborador = coc_cota_colaboradorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        sol_solicitacaoT = new Sol_solicitacaoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "sol_solicitacaoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
