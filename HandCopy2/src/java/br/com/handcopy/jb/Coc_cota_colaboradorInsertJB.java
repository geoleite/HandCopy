package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Coc_cota_colaboradorInsertJB extends SystemBase {

    // Atributos e propriedades
    private Coc_cota_colaboradorT coc_cota_colaboradorT = new Coc_cota_colaboradorT();

    public void setCoc_cota_colaboradorT(Coc_cota_colaboradorT coc_cota_colaboradorT) {
        this.coc_cota_colaboradorT = coc_cota_colaboradorT;
    }

    public Coc_cota_colaboradorT getCoc_cota_colaboradorT() {
        return coc_cota_colaboradorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M?todos de Eventos
    public void insert() throws Exception {
        try {
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
            coc_cota_colaboradorDAO.insert(coc_cota_colaboradorT);
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
    private List<Cot_cotaT> listcot_cota;

    public List<Cot_cotaT> getListcot_cota() {
        return listcot_cota;
    }

    public void setListcot_cota(List<Cot_cotaT> list) {
        this.listcot_cota = list;
    }

    public void consultCot_cota() throws Exception {
        try {
            Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
            listcot_cota = cot_cotaDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        coc_cota_colaboradorT = new Coc_cota_colaboradorT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "coc_cota_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
