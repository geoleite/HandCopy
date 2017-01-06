package br.com.handcopy.bl;

import br.com.handcopy.dao.Vw_col_colaboradorDAO;
import br.com.handcopy.transfer.Vw_col_colaboradorT;
import br.com.easynet.bl.BusinessBase;
import br.com.jdragon.dao.*;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import java.util.List;
import javax.sql.DataSource;

public class SystemBusinessBase extends BusinessBase {

    private int typeDatabase = DAOFactory.POSTGRESQL;
    private String url = "jdbc:postgresql://127.0.0.1:5432/aparato";
    private String user = "postgres";
    private String pass = "postgres";
    private DAOFactory dao;
    private String datasourceName = "java:comp/env/jdbc/NOME_CONEXAO";

    public DAOFactory getDAO() throws Exception {
        if (dao != null) {
            return dao;
        }
        return getDAO(typeDatabase, url, user, pass);
    }

    public DAOFactory getDAODataSource() throws Exception {

        DataSource ds = getDataSource(datasourceName);
        return DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
    }

    public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
        if (dao != null) {
            return dao;
        }
        return DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
    }

    public void close() {
        try {
            dao.close();
            dao = null;
        } catch (Exception e) {
        }
    }

    /**
     * M�todo para validar a seguranca
     */
    public boolean valide(String metodo) throws Exception {
        // Logica da seguranca
        return true;
    }

    public Col_colaboradorDAO getCol_colaboradorDAO() throws Exception {
        dao = getDAO();
        return new Col_colaboradorDAO(dao);
    }

    public Cot_cotaDAO getCot_cotaDAO() throws Exception {
        dao = getDAO();
        return new Cot_cotaDAO(dao);
    }

    public Sec_setor_colaboradorDAO getSec_setor_colaboradorDAO() throws Exception {
        dao = getDAO();
        return new Sec_setor_colaboradorDAO(dao);
    }

    public Ser_servicoDAO getSer_servicoDAO() throws Exception {
        dao = getDAO();
        return new Ser_servicoDAO(dao);
    }

    public Set_setorDAO getSet_setorDAO() throws Exception {
        dao = getDAO();
        return new Set_setorDAO(dao);
    }

    public Sst_servido_setorDAO getSst_servido_setorDAO() throws Exception {
        dao = getDAO();
        return new Sst_servido_setorDAO(dao);
    }

    public Col_colaboradorT findbyIdCol_colaborador(Col_colaboradorT col_colaboradorT) throws Exception {
        try {
            Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();

            List<Col_colaboradorT> listTemp = col_colaboradorDAO.getByPK(col_colaboradorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cot_cotaT findbyIdCot_cota(Cot_cotaT cot_cotaT) throws Exception {
        try {
            Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();

            List<Cot_cotaT> listTemp = cot_cotaDAO.getByPK(cot_cotaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Sec_setor_colaboradorT findbyIdSec_setor_colaborador(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        try {
            Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();

            List<Sec_setor_colaboradorT> listTemp = sec_setor_colaboradorDAO.getByPK(sec_setor_colaboradorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ser_servicoT findbyIdSer_servico(Ser_servicoT ser_servicoT) throws Exception {
        try {
            Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();

            List<Ser_servicoT> listTemp = ser_servicoDAO.getByPK(ser_servicoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Set_setorT findbyIdSet_setor(Set_setorT set_setorT) throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();

            List<Set_setorT> listTemp = set_setorDAO.getByPK(set_setorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Sst_servido_setorT findbyIdSst_servido_setor(Sst_servido_setorT sst_servido_setorT) throws Exception {
        try {
            Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();

            List<Sst_servido_setorT> listTemp = sst_servido_setorDAO.getByPK(sst_servido_setorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_col_colaboradorDAO getVw_col_colaboradorDAO() throws Exception {
        dao = getDAO();
        return new Vw_col_colaboradorDAO(dao);
    }

    public Vw_col_colaboradorT findbyIdVw_col_colaborador(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        try {
            Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();

            List<Vw_col_colaboradorT> listTemp = vw_col_colaboradorDAO.getByPK(vw_col_colaboradorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Coc_cota_colaboradorDAO getCoc_cota_colaboradorDAO() throws Exception {
        dao = getDAO();
        return new Coc_cota_colaboradorDAO(dao);
    }

    public Sol_solicitacaoDAO getSol_solicitacaoDAO() throws Exception {
        dao = getDAO();
        return new Sol_solicitacaoDAO(dao);
    }

    public Coc_cota_colaboradorT findbyIdCoc_cota_colaborador(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        try {
            Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();

            List<Coc_cota_colaboradorT> listTemp = coc_cota_colaboradorDAO.getByPK(coc_cota_colaboradorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Sol_solicitacaoT findbyIdSol_solicitacao(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        try {
            Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();

            List<Sol_solicitacaoT> listTemp = sol_solicitacaoDAO.getByPK(sol_solicitacaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Req_requisicaoDAO getReq_requisicaoDAO() throws Exception {
        dao = getDAO();
        return new Req_requisicaoDAO(dao);
    }

    public Req_requisicaoT findbyIdReq_requisicao(Req_requisicaoT req_requisicaoT) throws Exception {
        try {
            Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();

            List<Req_requisicaoT> listTemp = req_requisicaoDAO.getByPK(req_requisicaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
}
