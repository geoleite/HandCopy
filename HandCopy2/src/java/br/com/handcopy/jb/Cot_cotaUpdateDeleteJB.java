package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cot_cotaUpdateDeleteJB extends SystemBase {

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
        //
        consultSst_servido_setor();

    }

    public void clear() throws Exception {

        cot_cotaT = new Cot_cotaT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
                cot_cotaDAO.delete(cot_cotaT);
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
            Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
            List<Cot_cotaT> listTemp = cot_cotaDAO.getByPK(cot_cotaT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;
    }

    private String valideCota() throws Exception {
        String mensagem = null;
        Set_setorT setT = new Set_setorT();
        setT.setSet_nr_id(cot_cotaT.getSet_nr_id());
        List<Set_setorT> listSet = getSet_setorDAO().getByPK(setT);
        if (listSet.size() > 0) {
            Cot_cotaT cotT = new Cot_cotaT();
            setT = listSet.get(0);
            cotT.setSet_nr_id(setT.getSet_nr_idsetorpai());
            cotT.setSer_nr_id(cot_cotaT.getSer_nr_id());
            List<Cot_cotaT> listCot = getCot_cotaDAO().getBySetorServico(cotT);
            if (listCot.size() > 0) {
                cotT = listCot.get(0);
                int cotaSetorPai = cotT.getCot_nr_saldo();
                int totalDistribuido = getCot_cotaDAO().getTotalCotaDistribuida(cotT);
                if ((totalDistribuido + cot_cotaT.getCot_nr_saldo()) > cotaSetorPai) {
                    mensagem = "Falha ao definir cota do setor. O valor definido é maior que o permitido, que no momento é " + (cotaSetorPai - totalDistribuido);
                }
            }
        }
        return mensagem;
    }

    public void update() throws Exception {
        try {
            if (exist()) {
                String mensagem = valideCota();
                if (mensagem != null) {
                    setMsg(ERROR, mensagem);
                } else {
                    Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
                    cot_cotaDAO.update(cot_cotaT);
                    setMsg("Alteracao efetuada com sucesso!");
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
    private List<Sst_servido_setorT> listsst_servido_setor;

    public List<Sst_servido_setorT> getListsst_servido_setor() {
        return listsst_servido_setor;
    }

    public void setListsst_servido_setor(List<Sst_servido_setorT> list) {
        this.listsst_servido_setor = list;
    }

    public void consultSst_servido_setor() throws Exception {
        try {
            Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
            listsst_servido_setor = sst_servido_setorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE|
    public void findbyidSetorServico() throws Exception {
        try {
            Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
            List<Cot_cotaT> listTemp = cot_cotaDAO.getBySetorServico(cot_cotaT);

            cot_cotaT = listTemp.size() > 0 ? listTemp.get(0) : new Cot_cotaT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void findbyid() throws Exception {
        try {
            Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
            List<Cot_cotaT> listTemp = cot_cotaDAO.getByPK(cot_cotaT);

            cot_cotaT = listTemp.size() > 0 ? listTemp.get(0) : new Cot_cotaT();

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
            String page = "cot_cotaConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cot_cotaConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
