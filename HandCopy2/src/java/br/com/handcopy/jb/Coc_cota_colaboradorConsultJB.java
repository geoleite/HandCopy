package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import java.util.TreeMap;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Coc_cota_colaboradorConsultJB extends SystemBase {

    // Atributos e propriedades
    private Coc_cota_colaboradorT coc_cota_colaboradorT = new Coc_cota_colaboradorT();
 
    public void setCoc_cota_colaboradorT(Coc_cota_colaboradorT coc_cota_colaboradorT) {
        this.coc_cota_colaboradorT = coc_cota_colaboradorT;
    }

    public Coc_cota_colaboradorT getCoc_cota_colaboradorT() {
        return coc_cota_colaboradorT;
    }
    private List<Coc_cota_colaboradorT> list;

    public List<Coc_cota_colaboradorT> getList() {
        return list;
    }

    public void setList(List<Coc_cota_colaboradorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void consult() throws Exception {
        try {
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
            list = coc_cota_colaboradorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarMeusSaldosAtualizados() throws Exception{
        try {
            coc_cota_colaboradorT.setCol_nr_id(getUsuarioLogado().getUsu_nr_id());
            TreeMap<Integer, Sol_solicitacaoT> treeSol = new TreeMap<Integer, Sol_solicitacaoT>();
            Sol_solicitacaoT solT = new Sol_solicitacaoT();
            solT.setCol_nr_id(coc_cota_colaboradorT.getCol_nr_id());
            List<Sol_solicitacaoT> listSol = getSol_solicitacaoDAO().getQntSolicitadoByCol_nr_id(solT);
            for (Sol_solicitacaoT sol_solicitacaoT : listSol) {
                treeSol.put(sol_solicitacaoT.getSer_nr_id(), sol_solicitacaoT);
            }
            list = getCoc_cota_colaboradorDAO().getByCol_nr_id(coc_cota_colaboradorT);
            for (Coc_cota_colaboradorT cocT : list) {
                solT = treeSol.get(cocT.getSer_nr_id() );
                cocT.setCoc_nr_saldo(cocT.getCoc_nr_saldo() - (solT!= null?solT.getSol_nr_quantidade():0));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    public void consultarByColaborador() throws Exception {
        try {
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
            list = coc_cota_colaboradorDAO.getByCol_nr_id(coc_cota_colaboradorT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
            coc_cota_colaboradorDAO.delete(coc_cota_colaboradorT);
            setMsg("Exclusao efetuada com sucesso!");
            coc_cota_colaboradorT = new Coc_cota_colaboradorT();
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
            String page = "coc_cota_colaboradorInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
