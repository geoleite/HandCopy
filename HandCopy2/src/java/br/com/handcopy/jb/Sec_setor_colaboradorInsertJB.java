package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import java.util.Date;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sec_setor_colaboradorInsertJB extends SystemBase {

    // Atributos e propriedades
    private Sec_setor_colaboradorT sec_setor_colaboradorT = new Sec_setor_colaboradorT();

    public void setSec_setor_colaboradorT(Sec_setor_colaboradorT sec_setor_colaboradorT) {
        this.sec_setor_colaboradorT = sec_setor_colaboradorT;
    }

    public Sec_setor_colaboradorT getSec_setor_colaboradorT() {
        return sec_setor_colaboradorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    private void insertCotasColaborador() throws Exception {
        Cot_cotaT cotT = new Cot_cotaT();
        cotT.setSet_nr_id(sec_setor_colaboradorT.getSet_nr_id());
        List<Cot_cotaT> listCot = getCot_cotaDAO().getBySet_nr_id(cotT);
        for (Cot_cotaT cot_cotaT : listCot) {
            Coc_cota_colaboradorT cocT = new Coc_cota_colaboradorT();
            cocT.setCoc_nr_saldo(0);
            cocT.setCol_nr_id(sec_setor_colaboradorT.getCol_nr_id());
            cocT.setCot_nr_id(cot_cotaT.getCot_nr_id());
            cocT.setSet_nr_id(sec_setor_colaboradorT.getSet_nr_id());
            cocT.setSer_nr_id(cot_cotaT.getSer_nr_id());
            getCoc_cota_colaboradorDAO().insert(cocT);
        }
    }

    public void insert() throws Exception {
        try {
            Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
            sec_setor_colaboradorT.setSec_dt_alocado(new Date());
            sec_setor_colaboradorDAO.insert(sec_setor_colaboradorT);
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            insertCotasColaborador();
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

    public void clear() throws Exception {

        sec_setor_colaboradorT = new Sec_setor_colaboradorT();
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
