package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sst_servido_setorInsertJB extends SystemBase {

    // Atributos e propriedades
    private Sst_servido_setorT sst_servido_setorT = new Sst_servido_setorT();

    public void setSst_servido_setorT(Sst_servido_setorT sst_servido_setorT) {
        this.sst_servido_setorT = sst_servido_setorT;
    }

    public Sst_servido_setorT getSst_servido_setorT() {
        return sst_servido_setorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }


    private void insertCotasColaborador(Cot_cotaT cotT) throws Exception {
        Sec_setor_colaboradorT secT = new Sec_setor_colaboradorT();
        secT.setSet_nr_id(sst_servido_setorT.getSet_nr_id());
        
        List<Sec_setor_colaboradorT> listSec = getSec_setor_colaboradorDAO().getBySet_nr_id(secT);

        for (Sec_setor_colaboradorT sec_setor_colaboradorT : listSec) {
            
            Coc_cota_colaboradorT cocT = new Coc_cota_colaboradorT();
            cocT.setCoc_nr_saldo(0);
            cocT.setCol_nr_id(sec_setor_colaboradorT.getCol_nr_id());
            cocT.setCot_nr_id(cotT.getCot_nr_id());
            cocT.setSet_nr_id(sec_setor_colaboradorT.getSet_nr_id());
            cocT.setSer_nr_id(sst_servido_setorT.getSer_nr_id());
            getCoc_cota_colaboradorDAO().insert(cocT);
        }
    }
    // M?todos de Eventos
    public void insert() throws Exception {

        try {
            Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
            sst_servido_setorDAO.insert(sst_servido_setorT);
            Cot_cotaT cotT = new Cot_cotaT();
            cotT.setCot_nr_saldo(0);
            cotT.setSer_nr_id(sst_servido_setorT.getSer_nr_id());
            cotT.setSet_nr_id(sst_servido_setorT.getSet_nr_id());
            getCot_cotaDAO().insert(cotT);
            insertCotasColaborador(cotT);
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
    private List<Ser_servicoT> listser_servico;

    public List<Ser_servicoT> getListser_servico() {
        return listser_servico;
    }

    public void setListser_servico(List<Ser_servicoT> list) {
        this.listser_servico = list;
    }

    public void consultSer_servico() throws Exception {
        try {
            Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
            listser_servico = ser_servicoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        sst_servido_setorT = new Sst_servido_setorT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "sst_servido_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
