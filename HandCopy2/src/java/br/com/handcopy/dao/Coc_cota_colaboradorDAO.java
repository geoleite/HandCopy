package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Coc_cota_colaboradorDAO extends ObjectDAO {

    public Coc_cota_colaboradorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.coc_cota_colaborador  ( col_nr_id, cot_nr_id, set_nr_id, ser_nr_id, coc_nr_saldo) values ( ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getCol_nr_id());
            pStmt.setObject(2, coc_cota_colaboradorT.getCot_nr_id());
            pStmt.setObject(3, coc_cota_colaboradorT.getSet_nr_id());
            pStmt.setObject(4, coc_cota_colaboradorT.getSer_nr_id());
            pStmt.setObject(5, coc_cota_colaboradorT.getCoc_nr_saldo());
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

    public void update(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.coc_cota_colaborador set  coc_nr_saldo=?  where  col_nr_id=? and cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getCoc_nr_saldo());
            pStmt.setObject(2, coc_cota_colaboradorT.getCol_nr_id());
            pStmt.setObject(3, coc_cota_colaboradorT.getCot_nr_id());
            pStmt.setObject(4, coc_cota_colaboradorT.getSet_nr_id());
            pStmt.setObject(5, coc_cota_colaboradorT.getSer_nr_id());
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

    public void delete(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.coc_cota_colaborador where  col_nr_id=? and cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getCol_nr_id());
            pStmt.setObject(2, coc_cota_colaboradorT.getCot_nr_id());
            pStmt.setObject(3, coc_cota_colaboradorT.getSet_nr_id());
            pStmt.setObject(4, coc_cota_colaboradorT.getSer_nr_id());
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

    private List<Coc_cota_colaboradorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Coc_cota_colaboradorT> objs = new Vector();
        while (rs.next()) {
            Coc_cota_colaboradorT coc_cota_colaboradorT = new Coc_cota_colaboradorT();
            coc_cota_colaboradorT.setCol_nr_id(rs.getInt("col_nr_id"));
            coc_cota_colaboradorT.setCot_nr_id(rs.getInt("cot_nr_id"));
            coc_cota_colaboradorT.setSet_nr_id(rs.getInt("set_nr_id"));
            coc_cota_colaboradorT.setSer_nr_id(rs.getInt("ser_nr_id"));
            coc_cota_colaboradorT.setCoc_nr_saldo(rs.getInt("coc_nr_saldo"));
            objs.add(coc_cota_colaboradorT);
        }
        return objs;
    }

    public List<Coc_cota_colaboradorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Coc_cota_colaboradorT> list = resultSetToObjectTransfer(rs);
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

    public int getTotalCotaDefinicasColaborador(Coc_cota_colaboradorT cocT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(coc_nr_saldo) from handcopy2.coc_cota_colaborador where ser_nr_id=? and set_nr_id=? and col_nr_id<>?";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, cocT.getSer_nr_id());
            pStmt.setInt(2, cocT.getSet_nr_id());
            pStmt.setInt(3, cocT.getCol_nr_id());
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

    public List<Coc_cota_colaboradorT> getByPK(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador where  col_nr_id=? and cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getCol_nr_id());
            pStmt.setObject(2, coc_cota_colaboradorT.getCot_nr_id());
            pStmt.setObject(3, coc_cota_colaboradorT.getSet_nr_id());
            pStmt.setObject(4, coc_cota_colaboradorT.getSer_nr_id());
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

    public List<Coc_cota_colaboradorT> getByCol_nr_id(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador where col_nr_id = ? order by ser_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getCol_nr_id());
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

    public List<Coc_cota_colaboradorT> getByCot_nr_id(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador where  cot_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getCot_nr_id());
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

    public List<Coc_cota_colaboradorT> getByServicoSetorColaborador(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador where set_nr_id = ? and ser_nr_id=? and col_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getSet_nr_id());
            pStmt.setObject(2, coc_cota_colaboradorT.getSer_nr_id());
            pStmt.setObject(3, coc_cota_colaboradorT.getCol_nr_id());
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
    
    public List<Coc_cota_colaboradorT> getBySet_nr_id(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getSet_nr_id());
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

    public List<Coc_cota_colaboradorT> getBySer_nr_id(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador where  ser_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getSer_nr_id());
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

    public List<Coc_cota_colaboradorT> getByCoc_nr_saldo(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.coc_cota_colaborador where  coc_nr_saldo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coc_cota_colaboradorT.getCoc_nr_saldo());
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
