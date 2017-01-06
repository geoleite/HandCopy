package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cot_cotaConsultJB extends SystemBase {

    // Atributos e propriedades
    private Cot_cotaT cot_cotaT = new Cot_cotaT();

    public void setCot_cotaT(Cot_cotaT cot_cotaT) {
        this.cot_cotaT = cot_cotaT;
    }

    public Cot_cotaT getCot_cotaT() {
        return cot_cotaT;
    }
    private List<Cot_cotaT> list;

    public List<Cot_cotaT> getList() {
        return list;
    }

    public void setList(List<Cot_cotaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
            list = cot_cotaDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
            cot_cotaDAO.delete(cot_cotaT);
            setMsg("Exclusao efetuada com sucesso!");
            cot_cotaT = new Cot_cotaT();
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
            String page = "cot_cotaInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
