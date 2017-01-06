package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.criptografia.MD5;
import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.transfer.Pu_per_usuT;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.jdragon.dao.Util;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Vw_col_colaboradorInsertJB extends SystemBase {

    // Atributos e propriedades
    private Vw_col_colaboradorT vw_col_colaboradorT = new Vw_col_colaboradorT();

    public void setVw_col_colaboradorT(Vw_col_colaboradorT vw_col_colaboradorT) {
        this.vw_col_colaboradorT = vw_col_colaboradorT;
    }

    public Vw_col_colaboradorT getVw_col_colaboradorT() {
        return vw_col_colaboradorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }
/*
    public void insertServicosCotasIniciais()  {
        try {
            Set_setorT setT = getSet_setorDAO().getBySca_nr_id(vw_col_colaboradorT.getSca_nr_id());
            Ser_servicoT serT = new Ser_servicoT();
            serT.setOrg_nr_id(orgT.getOrg_nr_id());
            List<Ser_servicoT> listSet = getSer_servicoDAO().getByOrg_nr_id(serT);
            for (Ser_servicoT ser_servicoT : listSet) {
                Cot_cotaT cotT = new Cot_cotaT();
                cotT.setCol_nr_id(vw_col_colaboradorT.getCol_nr_id());
                cotT.setSer_nr_id(ser_servicoT.getSer_nr_id());
                cotT.setCot_nr_saldo(0);
                getCot_cotaDAO().insert(cotT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 */

    public void insert() throws Exception {
        Usu_usuarioDAO usuDao= null;
        Col_colaboradorDAO colDao = null;
        Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
        Pu_per_usuT puT = new Pu_per_usuT();
        try {

            usu_usuarioT.setUsu_tx_nome(vw_col_colaboradorT.getCol_tx_nome());
            usu_usuarioT.setUsu_tx_login(vw_col_colaboradorT.getCol_tx_login());
            usu_usuarioT.setUsu_tx_status(vw_col_colaboradorT.getCol_tx_status());
            usu_usuarioT.setUsu_tx_senha(MD5.criptografar(vw_col_colaboradorT.getCol_tx_senha()));
            usu_usuarioT.setUsu_tx_email(vw_col_colaboradorT.getCol_tx_email());

            usuDao = super.getUsu_usuarioDAO();
            if (usuDao.getByUsu_tx_login(usu_usuarioT).size()>0) {
                setMsg(ERROR, "Falha ao realizar cadastro: Nao foi possivel cadastrar o usuario devido ao login ja esta sendo utilizado! ");
                return;
            }
            usuDao.insert(usu_usuarioT);

            //Definindo o perfil padrao para o usuário
            
            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            puT.setPer_nr_id(59);// codigo do perfil padrao
            getPu_per_usuDAO().insert(puT);

            vw_col_colaboradorT.setCol_nr_id(usu_usuarioT.getUsu_nr_id());
            Col_colaboradorT colT = new Col_colaboradorT();
            colT.setCol_nr_id(usu_usuarioT.getUsu_nr_id());
            colDao = getCol_colaboradorDAO();
            colDao.insert(colT);
            
            //insertServicosCotasIniciais();
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            try {
                getPu_per_usuDAO().delete(null);
            } catch (Exception ex) {
            }
            usuDao.delete(usu_usuarioT);
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro: " + e.getMessage());
        } finally {
            try {
                getUsu_usuarioDAO().close();
            } catch (Exception e) {
            }
            close();
        }
    }

// Method de lookup
// 
    public void clear() throws Exception {

        vw_col_colaboradorT = new Vw_col_colaboradorT();
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
