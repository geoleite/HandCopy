package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Req_requisicaoDAO extends ObjectDAO {

    private static String sinal = "sinal";
    public Req_requisicaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    private int getAutoIncremento() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(req_nr_id) from handcopy2.req_requisicao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void insert(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.req_requisicao  ( req_tx_identificador, req_tx_teriminal, req_dt_requisitado, col_nr_id) values ( ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, req_requisicaoT.getReq_tx_identificador());
            pStmt.setObject(2, req_requisicaoT.getReq_tx_teriminal());
            pStmt.setObject(3, req_requisicaoT.getReq_dt_requisitado());
            pStmt.setObject(4, req_requisicaoT.getCol_nr_id());
            synchronized (sinal) {
                pStmt.execute();
                req_requisicaoT.setReq_nr_id(getAutoIncremento());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void update(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.req_requisicao set  req_tx_identificador=?, req_tx_teriminal=?, req_dt_requisitado=?  where  req_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, req_requisicaoT.getReq_tx_identificador());
            pStmt.setObject(2, req_requisicaoT.getReq_tx_teriminal());
            pStmt.setObject(3, req_requisicaoT.getReq_dt_requisitado());
            pStmt.setObject(4, req_requisicaoT.getReq_nr_id());
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

    public void delete(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.req_requisicao where  req_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, req_requisicaoT.getReq_nr_id());
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

    private List<Req_requisicaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Req_requisicaoT> objs = new Vector();
        while (rs.next()) {
            Req_requisicaoT req_requisicaoT = new Req_requisicaoT();
            req_requisicaoT.setReq_nr_id(rs.getInt("req_nr_id"));
            req_requisicaoT.setCol_nr_id(rs.getInt("col_nr_id"));
            req_requisicaoT.setReq_tx_identificador(rs.getString("req_tx_identificador"));
            req_requisicaoT.setReq_tx_teriminal(rs.getString("req_tx_teriminal"));
            req_requisicaoT.setReq_dt_requisitado(rs.getTimestamp("req_dt_requisitado"));
            objs.add(req_requisicaoT);
        }
        return objs;
    }

    public List<Req_requisicaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.req_requisicao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Req_requisicaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Req_requisicaoT> getByPK(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.req_requisicao where  req_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, req_requisicaoT.getReq_nr_id());
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

    public List<Req_requisicaoT> getByReq_nr_id(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.req_requisicao where  req_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, req_requisicaoT.getReq_nr_id());
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

    public List<Req_requisicaoT> getByCol_nr_id(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.req_requisicao where  col_nr_id = ? order by req_dt_requisitado desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, req_requisicaoT.getCol_nr_id());
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

    public List<Req_requisicaoT> getByReq_tx_identificador(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.req_requisicao where  Upper(req_tx_identificador) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + req_requisicaoT.getReq_tx_identificador() + '%');
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

    public List<Req_requisicaoT> getByReq_tx_teriminal(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.req_requisicao where  Upper(req_tx_teriminal) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + req_requisicaoT.getReq_tx_teriminal() + '%');
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

    public List<Req_requisicaoT> getByReq_dt_requisitado(Req_requisicaoT req_requisicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.req_requisicao where  req_dt_requisitado = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, req_requisicaoT.getReq_dt_requisitado());
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
