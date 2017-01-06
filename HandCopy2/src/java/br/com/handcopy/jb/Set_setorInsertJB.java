package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Set_setorInsertJB extends SystemBase {

    // Atributos e propriedades
    private Set_setorT set_setorT = new Set_setorT();

    public void setSet_setorT(Set_setorT set_setorT) {
        this.set_setorT = set_setorT;
    }

    public Set_setorT getSet_setorT() {
        return set_setorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M?todos de Eventos
    public void insert() throws Exception {

        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();
            set_setorDAO.insert(set_setorT);
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Set_setorT> listset_setor;

    public List<Set_setorT> getListset_setor() {
        return listset_setor;
    }

    public void setListset_setor(List<Set_setorT> list) {
        this.listset_setor = list;
    }

    public void consultSet_setor() throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();
            listset_setor = set_setorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        set_setorT = new Set_setorT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "set_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
