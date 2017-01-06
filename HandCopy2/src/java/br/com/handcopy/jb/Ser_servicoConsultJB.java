package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ser_servicoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Ser_servicoT ser_servicoT = new Ser_servicoT();
    private Set_setorT set_setorT = new Set_setorT();
    private List<Set_setorT> listSet = new ArrayList<Set_setorT>();

    public void setSer_servicoT(Ser_servicoT ser_servicoT) {
        this.ser_servicoT = ser_servicoT;
    }

    public Ser_servicoT getSer_servicoT() {
        return ser_servicoT;
    }
    private List<Ser_servicoT> list;

    public List<Ser_servicoT> getList() {
        return list;
    }

    public void setList(List<Ser_servicoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
            list = ser_servicoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarColaborador() throws Exception {
        try {
            set_setorT = (Set_setorT)getSession().getAttribute(SETOR);
            Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
            list = ser_servicoDAO.getBySet_nr_id(set_setorT.getSet_nr_id());
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarByNaoSetor() throws Exception {
        try {
            Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
            list = ser_servicoDAO.getByNaoSet_nr_id(set_setorT.getSet_nr_id());
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    private void getSetoresFilhos(Set_setorT setT) throws Exception {
        List<Set_setorT> listTemp = getSet_setorDAO().getAllFilhos(setT);
        listSet.addAll(listTemp);
        for (Set_setorT setTemp : listTemp) {
            getSetoresFilhos(setTemp);
        }
    }

    public void consultarBySetor() throws Exception {
        try {
            Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
            /*
            listSet.add(set_setorT);
            getSetoresFilhos(set_setorT);
            StringBuffer param = new StringBuffer();
            param.append("(");
            for (Set_setorT set_setorT : listSet) {
            param.append(set_setorT.getSet_nr_id()).append(", ");
            }
            param.append(",");
            String paramSetores = param.toString().replaceAll(", ,", ")");
             */
            list = ser_servicoDAO.getBySet_nr_id(set_setorT.getSet_nr_id());
            //list = ser_servicoDAO.getBySet_nr_id(paramSetores);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
            ser_servicoDAO.delete(ser_servicoT);
            setMsg("Exclusao efetuada com sucesso!");
            ser_servicoT = new Ser_servicoT();
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
            String page = "ser_servicoInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
