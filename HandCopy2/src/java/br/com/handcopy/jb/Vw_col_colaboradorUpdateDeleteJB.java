package br.com.handcopy.jb;

import br.com.easynet.criptografia.MD5;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.handcopy.transfer.Col_colaboradorT;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Vw_col_colaboradorUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Vw_col_colaboradorT vw_col_colaboradorT = new Vw_col_colaboradorT();

    public void setVw_col_colaboradorT(Vw_col_colaboradorT vw_col_colaboradorT) {
        this.vw_col_colaboradorT = vw_col_colaboradorT;
    }

    public Vw_col_colaboradorT getVw_col_colaboradorT() {
        return vw_col_colaboradorT;
    }
    private List<Vw_col_colaboradorT> list;

    public List<Vw_col_colaboradorT> getList() {
        return list;
    }

    public void setList(List<Vw_col_colaboradorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void clear() throws Exception {

        vw_col_colaboradorT = new Vw_col_colaboradorT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
                //vw_col_colaboradorDAO.delete(vw_col_colaboradorT);
                Col_colaboradorT colT = new Col_colaboradorT();
                colT.setCol_nr_id(vw_col_colaboradorT.getCol_nr_id());
                getCol_colaboradorDAO().delete(colT);
                Usu_usuarioT usuT = new Usu_usuarioT();
                usuT.setUsu_nr_id(vw_col_colaboradorT.getCol_nr_id());
                getUsu_usuarioDAO().delete(usuT);
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

    public void deleteUsuario() throws Exception {
        try {
            if (exist()) {
//                Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
//                //vw_col_colaboradorDAO.delete(vw_col_colaboradorT);
//                Col_colaboradorT colT = new Col_colaboradorT();
//                colT.setCol_nr_id(vw_col_colaboradorT.getCol_nr_id());
//                getCol_colaboradorDAO().delete(colT);
                Usu_usuarioT usuT = new Usu_usuarioT();
                usuT.setUsu_nr_id(vw_col_colaboradorT.getCol_nr_id());
                getUsu_usuarioDAO().delete(usuT);
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
            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
            List<Vw_col_colaboradorT> listTemp = vw_col_colaboradorDAO.getByPK(vw_col_colaboradorT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void updateSenha() throws Exception {
        try {
            if (exist()) {
                Usu_usuarioT usuT = new Usu_usuarioT();
                usuT.setUsu_nr_id(vw_col_colaboradorT.getCol_nr_id());
                usuT.setUsu_tx_senha(MD5.criptografar(vw_col_colaboradorT.getCol_tx_senha()));
                getUsu_usuarioDAO().updateSenha(usuT);

                setMsg("Senha alterada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao alterar senha!");
        } finally {
            try {
                getUsu_usuarioDAO().getDAOFactory().close();
            } catch (Exception e) {
            }
            close();
        }
    }

    public void update() throws Exception {
        try {
            if (exist()) {
                Usu_usuarioT usuT = new Usu_usuarioT();
                usuT.setUsu_nr_id(vw_col_colaboradorT.getCol_nr_id());
                usuT.setUsu_tx_nome(vw_col_colaboradorT.getCol_tx_nome());
                usuT.setUsu_tx_login(vw_col_colaboradorT.getCol_tx_login());
                usuT.setUsu_tx_email(vw_col_colaboradorT.getCol_tx_email());
                usuT.setUsu_tx_status(vw_col_colaboradorT.getCol_tx_status());
                getUsu_usuarioDAO().updateDados(usuT);
                setMsg("Alteracao efetuada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            try {
                getUsu_usuarioDAO().getDAOFactory().close();
            } catch (Exception e) {
            }
            close();
        }
    }

// Method de lookup
// 
    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
            List<Vw_col_colaboradorT> listTemp = vw_col_colaboradorDAO.getByPK(vw_col_colaboradorT);
            vw_col_colaboradorT = listTemp.size() > 0 ? listTemp.get(0) : new Vw_col_colaboradorT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void findbyLogin() throws Exception {
        try {
            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
            List<Vw_col_colaboradorT> listTemp = vw_col_colaboradorDAO.getByCol_tx_login(vw_col_colaboradorT);
            vw_col_colaboradorT = listTemp.size() > 0 ? listTemp.get(0) : new Vw_col_colaboradorT();

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
            String page = "vw_col_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "vw_col_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
