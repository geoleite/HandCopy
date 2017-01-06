package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import java.util.ArrayList;
import java.util.Vector;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Set_setorConsultJB extends SystemBase {

    // Atributos e propriedades
    private Set_setorT set_setorT = new Set_setorT();

    public void setSet_setorT(Set_setorT set_setorT) {
        this.set_setorT = set_setorT;
    }

    public Set_setorT getSet_setorT() {
        return set_setorT;
    }
    private List<Set_setorT> list;

    public List<Set_setorT> getList() {
        return list;
    }

    public void setList(List<Set_setorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        set_setorT = (Set_setorT) getSession().getAttribute(SETOR);
    }



    public void obtendoSetorRaizColaborador() throws Exception {
        try {
            Set_setorT setT = verificaSetorEPai(set_setorT);

            if (setT != null) {
                list = new Vector<Set_setorT>();
                list.add(setT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void obtendoSetoresFilhos(Set_setorT setT) throws Exception {
        if (setT != null) {
            List<Set_setorT> filhos = getSet_setorDAO().getAllFilhos(setT);
            if (list == null) {
                list = new ArrayList<Set_setorT>();
            }
            list.addAll(filhos);
            for (Set_setorT setTTemp : filhos) {
                obtendoSetoresFilhos(setTTemp);
            }
        }
    }

    public void consult() throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();

            if (set_setorT != null) {
                list = new ArrayList<Set_setorT>();
                list.add(set_setorT);
                obtendoSetoresFilhos(set_setorT);
            } else {
                list = set_setorDAO.getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarSetorSemPai() throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();
            list = set_setorDAO.getAllSemPai();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarSetoresFilhos() throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();
            list = set_setorDAO.getAllFilhos(set_setorT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();
            set_setorDAO.delete(set_setorT);
            setMsg("Exclusao efetuada com sucesso!");
            set_setorT = new Set_setorT();
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
            String page = "set_setorInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
