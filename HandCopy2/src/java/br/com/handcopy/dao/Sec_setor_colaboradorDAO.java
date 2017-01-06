package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Sec_setor_colaboradorDAO extends ObjectDAO {

    public Sec_setor_colaboradorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.sec_setor_colaborador  ( set_nr_id, col_nr_id, sec_dt_alocado) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sec_setor_colaboradorT.getSet_nr_id());
            pStmt.setObject(2, sec_setor_colaboradorT.getCol_nr_id());
            java.sql.Date dt3 = new java.sql.Date(sec_setor_colaboradorT.getSec_dt_alocado().getTime());
            pStmt.setObject(3, dt3);
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

    public void update(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.sec_setor_colaborador set  sec_dt_alocado=?  where  set_nr_id=? and col_nr_id=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(sec_setor_colaboradorT.getSec_dt_alocado().getTime());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, sec_setor_colaboradorT.getSet_nr_id());
            pStmt.setObject(3, sec_setor_colaboradorT.getCol_nr_id());
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

    public void delete(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.sec_setor_colaborador where  set_nr_id=? and col_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sec_setor_colaboradorT.getSet_nr_id());
            pStmt.setObject(2, sec_setor_colaboradorT.getCol_nr_id());
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

    private List<Sec_setor_colaboradorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Sec_setor_colaboradorT> objs = new Vector();
        while (rs.next()) {
            Sec_setor_colaboradorT sec_setor_colaboradorT = new Sec_setor_colaboradorT();
            sec_setor_colaboradorT.setSet_nr_id(rs.getInt("set_nr_id"));
            sec_setor_colaboradorT.setCol_nr_id(rs.getInt("col_nr_id"));
            sec_setor_colaboradorT.setSec_dt_alocado(rs.getDate("sec_dt_alocado"));
            objs.add(sec_setor_colaboradorT);
        }
        return objs;
    }

    public List<Sec_setor_colaboradorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sec_setor_colaborador";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Sec_setor_colaboradorT> list = resultSetToObjectTransfer(rs);
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

    public List<Sec_setor_colaboradorT> getByPK(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sec_setor_colaborador where  set_nr_id=? and col_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sec_setor_colaboradorT.getSet_nr_id());
            pStmt.setObject(2, sec_setor_colaboradorT.getCol_nr_id());
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

    public List<Sec_setor_colaboradorT> getBySet_nr_id(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sec_setor_colaborador where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sec_setor_colaboradorT.getSet_nr_id());
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

    public List<Sec_setor_colaboradorT> getByCol_nr_id(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sec_setor_colaborador where  col_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sec_setor_colaboradorT.getCol_nr_id());
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

    public List<Sec_setor_colaboradorT> getBySec_dt_alocado(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sec_setor_colaborador where  sec_dt_alocado = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(sec_setor_colaboradorT.getSec_dt_alocado().getTime());
            pStmt.setObject(1, dt1);
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
    public List<Sec_setor_colaboradorT> getBySet_setor(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sec_setor_colaborador where set_setor.set_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sec_setor_colaboradorT.getSet_nr_id());
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
    public List<Sec_setor_colaboradorT> getByCol_colaborador(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.sec_setor_colaborador where col_colaborador.col_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sec_setor_colaboradorT.getCol_nr_id());
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
