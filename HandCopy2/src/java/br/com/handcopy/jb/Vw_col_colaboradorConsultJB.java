package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.handcopy.transfer.Set_setorT;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Vw_col_colaboradorConsultJB extends SystemBase {

    // Atributos e propriedades
    private Vw_col_colaboradorT vw_col_colaboradorT = new Vw_col_colaboradorT();
    private Set_setorT set_setorT = new Set_setorT();

    public void setVw_col_colaboradorT(Vw_col_colaboradorT vw_col_colaboradorT) {
        this.vw_col_colaboradorT = vw_col_colaboradorT;
    }

    public Vw_col_colaboradorT getVw_col_colaboradorT() {
        return vw_col_colaboradorT;
    }
    private List<Vw_col_colaboradorT> list;

    public List<Vw_col_colaboradorT> getList() {
        return list;
    }

    public void setList(List<Vw_col_colaboradorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
    }

    public void consultSubordinados() throws Exception {
        /*
        try {
        String tipoPerfil = (String) getSession().getAttribute(TIPO_PERFIL);
        if (GESTOR.equals(tipoPerfil)) {
        Sec_secretariaT secT = (Sec_secretariaT) getSession().getAttribute(SECRETARIA);
        if (secT == null) {
        setMsg(ERROR, "Colaborador nao e o gestor da secretaria!");
        return;
        } else {
        list = getVw_col_colaboradorDAO().getBySecretaria(secT.getSec_nr_id());
        }
        } else if (DIRETOR.equals(tipoPerfil)) {
        Dir_diretoriaT dirT = (Dir_diretoriaT) getSession().getAttribute(DIRETORIA);
        if (dirT == null) {
        setMsg(ERROR, "Colaborador nao e o diretor!");
        return;
        } else {
        list = getVw_col_colaboradorDAO().getByDiretoria(dirT.getDir_nr_id());
        }
        } else if (CHEFE.equals(tipoPerfil)) {
        Sca_secaoT scaT = (Sca_secaoT) getSession().getAttribute(SECAO);
        if (scaT == null) {
        setMsg(ERROR, "Colaborador nao e o Chefe!");
        return;
        } else {
        list = getVw_col_colaboradorDAO().getBySecao(scaT.getSca_nr_id());
        }
        }
        } catch (Exception e) {
        } finally {
        }

         */
    }

    public void consult() throws Exception {
        try {
            //Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
            //list = vw_col_colaboradorDAO.getAll();
            set_setorT = (Set_setorT) getSession().getAttribute(SETOR);
            consultarBySetorNome();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarBySetorNome() throws Exception {
        try {
            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
            String setores = getTodosSetoresFilhos(set_setorT);
            list = vw_col_colaboradorDAO.getBySetoresNome(setores, vw_col_colaboradorT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarByNome() throws Exception {
        try {
            set_setorT = (Set_setorT) getSession().getAttribute(SETOR);
            consultarBySetorNome();
//            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
//            list = vw_col_colaboradorDAO.getByCol_tx_nome(vw_col_colaboradorT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarBySetor() throws Exception {
        try {
            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
            String setores = getTodosSetoresFilhos(set_setorT);
            list = vw_col_colaboradorDAO.getBySetores(setores);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
            vw_col_colaboradorDAO.delete(vw_col_colaboradorT);
            setMsg("Exclusao efetuada com sucesso!");
            vw_col_colaboradorT = new Vw_col_colaboradorT();
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
            String page = "vw_col_colaboradorInsert.jsp";// defina aqui a p?gina que deve ser chamada
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

    /**
     * @return the set_setorT
     */
    public Set_setorT getSet_setorT() {
        return set_setorT;
    }

    /**
     * @param set_setorT the set_setorT to set
     */
    public void setSet_setorT(Set_setorT set_setorT) {
        this.set_setorT = set_setorT;
    }
}
