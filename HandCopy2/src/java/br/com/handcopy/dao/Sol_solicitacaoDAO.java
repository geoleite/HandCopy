package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Sol_solicitacaoDAO extends ObjectDAO {

    public Sol_solicitacaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.sol_solicitacao  ( col_nr_id, cot_nr_id, set_nr_id, ser_nr_id, sol_dt_datahora, sol_tx_idterminal, sol_nr_quantidade, req_nr_id) values ( ? , ? , ? , ? , ? , ? , ?, ?  )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getCol_nr_id());
            pStmt.setObject(2, sol_solicitacaoT.getCot_nr_id());
            pStmt.setObject(3, sol_solicitacaoT.getSet_nr_id());
            pStmt.setObject(4, sol_solicitacaoT.getSer_nr_id());
            pStmt.setObject(5, sol_solicitacaoT.getSol_dt_datahora());
            pStmt.setObject(6, sol_solicitacaoT.getSol_tx_idterminal());
            pStmt.setObject(7, sol_solicitacaoT.getSol_nr_quantidade());
            pStmt.setObject(8, sol_solicitacaoT.getReq_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.sol_solicitacao set  sol_dt_datahora=?, sol_tx_idterminal=?, sol_nr_quantidade=?  where  sol_nr_id=? and col_nr_id=? and cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSol_dt_datahora());
            pStmt.setObject(2, sol_solicitacaoT.getSol_tx_idterminal());
            pStmt.setObject(3, sol_solicitacaoT.getSol_nr_quantidade());
            pStmt.setObject(4, sol_solicitacaoT.getSol_nr_id());
            pStmt.setObject(5, sol_solicitacaoT.getCol_nr_id());
            pStmt.setObject(6, sol_solicitacaoT.getCot_nr_id());
            pStmt.setObject(7, sol_solicitacaoT.getSet_nr_id());
            pStmt.setObject(8, sol_solicitacaoT.getSer_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.sol_solicitacao where  sol_nr_id=? and col_nr_id=? and cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSol_nr_id());
            pStmt.setObject(2, sol_solicitacaoT.getCol_nr_id());
            pStmt.setObject(3, sol_solicitacaoT.getCot_nr_id());
            pStmt.setObject(4, sol_solicitacaoT.getSet_nr_id());
            pStmt.setObject(5, sol_solicitacaoT.getSer_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Sol_solicitacaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Sol_solicitacaoT> objs = new Vector();
        while (rs.next()) {
            Sol_solicitacaoT sol_solicitacaoT = new Sol_solicitacaoT();
            sol_solicitacaoT.setSol_nr_id(rs.getInt("sol_nr_id"));
            sol_solicitacaoT.setCol_nr_id(rs.getInt("col_nr_id"));
            sol_solicitacaoT.setCot_nr_id(rs.getInt("cot_nr_id"));
            sol_solicitacaoT.setSet_nr_id(rs.getInt("set_nr_id"));
            sol_solicitacaoT.setSer_nr_id(rs.getInt("ser_nr_id"));
            sol_solicitacaoT.setReq_nr_id(rs.getInt("req_nr_id"));
            sol_solicitacaoT.setSol_dt_datahora(rs.getTimestamp("sol_dt_datahora"));
            sol_solicitacaoT.setSol_tx_idterminal(rs.getString("sol_tx_idterminal"));
            sol_solicitacaoT.setSol_nr_quantidade(rs.getInt("sol_nr_quantidade"));
            objs.add(sol_solicitacaoT);
        }
        return objs;
    }

    public List<Sol_solicitacaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Sol_solicitacaoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public int getTotalSolicitadoColaborador(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(sol_nr_quantidade) from handcopy2.sol_solicitacao where col_nr_id=? and cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getCol_nr_id());
            pStmt.setObject(2, sol_solicitacaoT.getCot_nr_id());
            pStmt.setObject(3, sol_solicitacaoT.getSet_nr_id());
            pStmt.setObject(4, sol_solicitacaoT.getSer_nr_id());
            rs = pStmt.executeQuery();
            int valor = 0;
            if (rs.next()) {
                valor = rs.getInt(1);
            }
            return valor;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }
    public List<Sol_solicitacaoT> getByPK(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  sol_nr_id=? and col_nr_id=? and cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSol_nr_id());
            pStmt.setObject(2, sol_solicitacaoT.getCol_nr_id());
            pStmt.setObject(3, sol_solicitacaoT.getCot_nr_id());
            pStmt.setObject(4, sol_solicitacaoT.getSet_nr_id());
            pStmt.setObject(5, sol_solicitacaoT.getSer_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getBySol_nr_id(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  sol_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSol_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getByCol_nr_id(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where col_nr_id = ? order by sol_dt_datahora desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getCol_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getQntSolicitadoByCol_nr_id(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select 0 as req_nr_id, 0 as cot_nr_id, 0 as sol_nr_id, 0 as col_nr_id, 0 set_nr_id, now() as sol_dt_datahora, '' as sol_tx_idterminal, sol.ser_nr_id, sum(sol_nr_quantidade) as sol_nr_quantidade from handcopy2.sol_solicitacao sol where sol.col_nr_id=? group by sol.ser_nr_id ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getCol_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getByCot_nr_id(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  cot_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getCot_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getBySet_nr_id(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSet_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getBySer_nr_id(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  ser_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSer_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getBySol_dt_datahora(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  sol_dt_datahora = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSol_dt_datahora());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getBySol_tx_idterminal(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  Upper(sol_tx_idterminal) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + sol_solicitacaoT.getSol_tx_idterminal() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Sol_solicitacaoT> getBySol_nr_quantidade(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where  sol_nr_quantidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getSol_nr_quantidade());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    /** Metodos FK */
    public List<Sol_solicitacaoT> getByCoc_cota_colaborador(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sol_solicitacao where coc_cota_colaborador.col_nr_id=? and coc_cota_colaborador.cot_nr_id=? and coc_cota_colaborador.set_nr_id=? and coc_cota_colaborador.ser_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sol_solicitacaoT.getCol_nr_id());
            pStmt.setObject(2, sol_solicitacaoT.getCot_nr_id());
            pStmt.setObject(3, sol_solicitacaoT.getSet_nr_id());
            pStmt.setObject(4, sol_solicitacaoT.getSer_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
}
