package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Col_colaboradorDAO extends ObjectDAO {

    public Col_colaboradorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Col_colaboradorT col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.col_colaborador  ( col_nr_id) values ( ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, col_colaboradorT.getCol_nr_id());
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

    public void delete(Col_colaboradorT col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.col_colaborador where  col_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, col_colaboradorT.getCol_nr_id());
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

    private List<Col_colaboradorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Col_colaboradorT> objs = new Vector();
        while (rs.next()) {
            Col_colaboradorT col_colaboradorT = new Col_colaboradorT();
            col_colaboradorT.setCol_nr_id(rs.getInt("col_nr_id"));
            objs.add(col_colaboradorT);
        }
        return objs;
    }

    public List<Col_colaboradorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.col_colaborador";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Col_colaboradorT> list = resultSetToObjectTransfer(rs);
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

    public List<Col_colaboradorT> getByPK(Col_colaboradorT col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.col_colaborador where  col_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, col_colaboradorT.getCol_nr_id());
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

    public List<Col_colaboradorT> getByCol_nr_id(Col_colaboradorT col_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.col_colaborador where  col_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, col_colaboradorT.getCol_nr_id());
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
