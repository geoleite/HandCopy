package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Coc_cota_colaboradorUpdateDeleteJB extends SystemBase {

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

    public void clear() throws Exception {

        coc_cota_colaboradorT = new Coc_cota_colaboradorT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
                coc_cota_colaboradorDAO.delete(coc_cota_colaboradorT);
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
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
            List<Coc_cota_colaboradorT> listTemp = coc_cota_colaboradorDAO.getByPK(coc_cota_colaboradorT);

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
                Cot_cotaT cotT = new Cot_cotaT();
                cotT.setCot_nr_id(coc_cota_colaboradorT.getCot_nr_id());

                List<Cot_cotaT> listCot = getCot_cotaDAO().getByCot_nr_id(cotT);
                cotT = listCot.size() > 0 ? listCot.get(0) : null;
                if (cotT != null) {
                    int totalServicoSetor = getCoc_cota_colaboradorDAO().getTotalCotaDefinicasColaborador(coc_cota_colaboradorT);
                    if ( (totalServicoSetor + coc_cota_colaboradorT.getCoc_nr_saldo()) <= cotT.getCot_nr_saldo() ) {
                        Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
                        coc_cota_colaboradorDAO.update(coc_cota_colaboradorT);
                        setMsg("Alteracao efetuada com sucesso!");
                    } else {
                        setMsg("Falha ao definir cota do colaborador! O valor definido supera ao definido para o setor. Valor disponivel=" +
                                (cotT.getCot_nr_saldo()-totalServicoSetor));
                    }
                }
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

    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
            List<Coc_cota_colaboradorT> listTemp = coc_cota_colaboradorDAO.getByPK(coc_cota_colaboradorT);

            coc_cota_colaboradorT = listTemp.size() > 0 ? listTemp.get(0) : new Coc_cota_colaboradorT();

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
            String page = "coc_cota_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
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
