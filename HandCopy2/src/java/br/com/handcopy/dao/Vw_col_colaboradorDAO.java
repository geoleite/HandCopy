package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;
import br.com.handcopy.transfer.Vw_col_colaboradorT;

public class Vw_col_colaboradorDAO extends ObjectDAO {

    public Vw_col_colaboradorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.vw_col_colaborador  ( col_tx_nome, col_tx_login, col_tx_status, col_tx_email) values ( ? , ? , ? , ?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_col_colaboradorT.getCol_tx_nome());
            pStmt.setObject(2, vw_col_colaboradorT.getCol_tx_login());
            pStmt.setObject(3, vw_col_colaboradorT.getCol_tx_status());
            pStmt.setObject(4, vw_col_colaboradorT.getCol_tx_email());
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

    public void update(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.vw_col_colaborador set  col_tx_nome=?, col_tx_login=?, col_tx_status=?, col_tx_email=? where - ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_col_colaboradorT.getCol_tx_nome());
            pStmt.setObject(2, vw_col_colaboradorT.getCol_tx_login());
            pStmt.setObject(3, vw_col_colaboradorT.getCol_tx_status());
            pStmt.setObject(4, vw_col_colaboradorT.getCol_tx_email());
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

    public void delete(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.vw_col_colaborador where -";
            pStmt = con.prepareStatement(sql);
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

    private List<Vw_col_colaboradorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_col_colaboradorT> objs = new Vector();
        while (rs.next()) {
            Vw_col_colaboradorT vw_col_colaboradorT = new Vw_col_colaboradorT();
            vw_col_colaboradorT.setCol_tx_nome(rs.getString("col_tx_nome"));
            vw_col_colaboradorT.setCol_tx_login(rs.getString("col_tx_login"));
            vw_col_colaboradorT.setCol_tx_status(rs.getString("col_tx_status"));
            vw_col_colaboradorT.setCol_tx_email(rs.getString("col_tx_email"));
            vw_col_colaboradorT.setCol_nr_id(rs.getInt("col_nr_id"));
            objs.add(vw_col_colaboradorT);
        }
        return objs;
    }

    public List<Vw_col_colaboradorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.vw_col_colaborador";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Vw_col_colaboradorT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_col_colaboradorT> getByPK(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.vw_col_colaborador where col_nr_id = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_col_colaboradorT.getCol_nr_id());
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

    public List<Vw_col_colaboradorT> getBySetoresNome(String setores, Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer("select distinct col.* from handcopy2.vw_col_colaborador col, handcopy2.sec_setor_colaborador sec where sec.set_nr_id in (");
            sql.append(setores).append(") and sec.col_nr_id=col.col_nr_id and upper(col.col_tx_nome) like upper(?) order by col.col_tx_nome");
            //String sql = "select col.* from handcopy2.vw_col_colaborador col, handcopy2.sec_setor_colaborador sec where sec.set_nr_id in (1,5,6,7, 12,13,14) and sec.col_nr_id=col.col_nr_id order by col.col_tx_nome ";
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, '%' + vw_col_colaboradorT.getCol_tx_nome() + '%');
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

    public List<Vw_col_colaboradorT> getBySetores(String setores) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer("select distinct col.* from handcopy2.vw_col_colaborador col, handcopy2.sec_setor_colaborador sec where sec.set_nr_id in (");
            sql.append(setores).append(") and sec.col_nr_id=col.col_nr_id order by col.col_tx_nome");
            pStmt = con.prepareStatement(sql.toString());
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

    public List<Vw_col_colaboradorT> getByCol_tx_nome(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.vw_col_colaborador where  Upper(col_tx_nome) like Upper(?) order by col_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_col_colaboradorT.getCol_tx_nome() + '%');
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

    public List<Vw_col_colaboradorT> getByCol_tx_login(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.vw_col_colaborador where  Upper(col_tx_login) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_col_colaboradorT.getCol_tx_login() + '%');
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

    public List<Vw_col_colaboradorT> getByCol_tx_status(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy.vw_col_colaborador where  Upper(col_tx_status) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_col_colaboradorT.getCol_tx_status() + '%');
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

    public List<Vw_col_colaboradorT> getByCol_tx_email(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy.vw_col_colaborador where  Upper(col_tx_email) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_col_colaboradorT.getCol_tx_email() + '%');
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
