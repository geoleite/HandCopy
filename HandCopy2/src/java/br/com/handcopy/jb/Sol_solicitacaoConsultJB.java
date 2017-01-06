package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sol_solicitacaoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Sol_solicitacaoT sol_solicitacaoT = new Sol_solicitacaoT();

    public void setSol_solicitacaoT(Sol_solicitacaoT sol_solicitacaoT) {
        this.sol_solicitacaoT = sol_solicitacaoT;
    }

    public Sol_solicitacaoT getSol_solicitacaoT() {
        return sol_solicitacaoT;
    }
    private List<Sol_solicitacaoT> list;

    public List<Sol_solicitacaoT> getList() {
        return list;
    }

    public void setList(List<Sol_solicitacaoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

  
    public void consultarMinhasSolicitacoes() throws Exception {
        try {
            sol_solicitacaoT.setCol_nr_id(getUsuarioLogado().getUsu_nr_id());
            Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
            list = sol_solicitacaoDAO.getByCol_nr_id(sol_solicitacaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }    
    }
    public void consultarPorColaborador() throws Exception {
        try {
            Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
            list = sol_solicitacaoDAO.getByCol_nr_id(sol_solicitacaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult() throws Exception {
        try {
            Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
            list = sol_solicitacaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
            sol_solicitacaoDAO.delete(sol_solicitacaoT);
            setMsg("Exclusao efetuada com sucesso!");
            sol_solicitacaoT = new Sol_solicitacaoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "sol_solicitacaoInsert.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
