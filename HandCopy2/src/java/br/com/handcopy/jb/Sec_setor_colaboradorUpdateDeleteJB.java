package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sec_setor_colaboradorUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Sec_setor_colaboradorT sec_setor_colaboradorT = new Sec_setor_colaboradorT();

    public void setSec_setor_colaboradorT(Sec_setor_colaboradorT sec_setor_colaboradorT) {
        this.sec_setor_colaboradorT = sec_setor_colaboradorT;
    }

    public Sec_setor_colaboradorT getSec_setor_colaboradorT() {
        return sec_setor_colaboradorT;
    }
    private List<Sec_setor_colaboradorT> list;

    public List<Sec_setor_colaboradorT> getList() {
        return list;
    }

    public void setList(List<Sec_setor_colaboradorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void clear() throws Exception {

        sec_setor_colaboradorT = new Sec_setor_colaboradorT();
    }

    public void delete() throws Exception {
        try {
            List<Sec_setor_colaboradorT> list = getSec_setor_colaboradorDAO().getByCol_nr_id(sec_setor_colaboradorT);
            sec_setor_colaboradorT = list.size()>0?list.get(0):sec_setor_colaboradorT;
            if (exist()) {
                Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
                sec_setor_colaboradorDAO.delete(sec_setor_colaboradorT);
                setMsg("Exclusao efetuada com sucesso!");
                clear();
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
            List<Sec_setor_colaboradorT> listTemp = sec_setor_colaboradorDAO.getByPK(sec_setor_colaboradorT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void update() throws Exception {
        try {
            if (exist()) {
                Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
                sec_setor_colaboradorDAO.update(sec_setor_colaboradorT);
                setMsg("Alteracao efetuada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
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
    private List<Col_colaboradorT> listcol_colaborador;

    public List<Col_colaboradorT> getListcol_colaborador() {
        return listcol_colaborador;
    }

    public void setListcol_colaborador(List<Col_colaboradorT> list) {
        this.listcol_colaborador = list;
    }

    public void consultCol_colaborador() throws Exception {
        try {
            Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
            listcol_colaborador = col_colaboradorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
            List<Sec_setor_colaboradorT> listTemp = sec_setor_colaboradorDAO.getByPK(sec_setor_colaboradorT);

            sec_setor_colaboradorT = listTemp.size() > 0 ? listTemp.get(0) : new Sec_setor_colaboradorT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a p?gina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "sec_setor_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "sec_setor_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
