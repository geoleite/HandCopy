package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Cot_cotaDAO extends ObjectDAO {

    private static String sinal = "sinal";

    public Cot_cotaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    private int getAutoincremento() throws Exception {
        String sql = "select max(cot_nr_id) from handcopy2.cot_cota";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int codigo = 0;
            if (rs.next()) {
                codigo = rs.getInt(1);
            }
            return codigo;

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                pstmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void insert(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.cot_cota  ( set_nr_id, ser_nr_id, cot_nr_saldo) values ( ? , ? , ?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getSet_nr_id());
            pStmt.setObject(2, cot_cotaT.getSer_nr_id());
            pStmt.setObject(3, cot_cotaT.getCot_nr_saldo());
            synchronized (sinal) {
                pStmt.execute();
                cot_cotaT.setCot_nr_id(getAutoincremento());
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

    public void update(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.cot_cota set  cot_nr_saldo=?  where  cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getCot_nr_saldo());
            pStmt.setObject(2, cot_cotaT.getCot_nr_id());
            pStmt.setObject(3, cot_cotaT.getSet_nr_id());
            pStmt.setObject(4, cot_cotaT.getSer_nr_id());
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

    public void delete(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.cot_cota where  cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getCot_nr_id());
            pStmt.setObject(2, cot_cotaT.getSet_nr_id());
            pStmt.setObject(3, cot_cotaT.getSer_nr_id());
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

    private List<Cot_cotaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cot_cotaT> objs = new Vector();
        while (rs.next()) {
            Cot_cotaT cot_cotaT = new Cot_cotaT();
            cot_cotaT.setCot_nr_id(rs.getInt("cot_nr_id"));
            cot_cotaT.setSet_nr_id(rs.getInt("set_nr_id"));
            cot_cotaT.setSer_nr_id(rs.getInt("ser_nr_id"));
            cot_cotaT.setCot_nr_saldo(rs.getInt("cot_nr_saldo"));
            objs.add(cot_cotaT);
        }
        return objs;
    }

    public List<Cot_cotaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cot_cotaT> list = resultSetToObjectTransfer(rs);
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

    public List<Cot_cotaT> getByPK(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota where  cot_nr_id=? and set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getCot_nr_id());
            pStmt.setObject(2, cot_cotaT.getSet_nr_id());
            pStmt.setObject(3, cot_cotaT.getSer_nr_id());
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

    public List<Cot_cotaT> getBySetorServico(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota where  set_nr_id=? and ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getSet_nr_id());
            pStmt.setObject(2, cot_cotaT.getSer_nr_id());
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

    public List<Cot_cotaT> getByCot_nr_id(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota where  cot_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getCot_nr_id());
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

    public int getTotalCotaDistribuida(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(cot_nr_saldo) from handcopy2.cot_cota where set_nr_id in (select set_nr_id from handcopy2.set_setor where set_nr_idsetorpai=?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getSet_nr_id());
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

    public List<Cot_cotaT> getBySet_nr_id(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getSet_nr_id());
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

    public List<Cot_cotaT> getBySer_nr_id(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota where  ser_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getSer_nr_id());
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

    public List<Cot_cotaT> getByCot_nr_saldo(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota where  cot_nr_saldo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getCot_nr_saldo());
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
    public List<Cot_cotaT> getBySst_servido_setor(Cot_cotaT cot_cotaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.cot_cota where sst_servido_setor.set_nr_id=? and sst_servido_setor.ser_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cot_cotaT.getSet_nr_id());
            pStmt.setObject(2, cot_cotaT.getSer_nr_id());
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
