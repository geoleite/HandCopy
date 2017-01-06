package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Ser_servicoDAO extends ObjectDAO {

    public Ser_servicoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ser_servicoT ser_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.ser_servico  ( ser_tx_nome) values ( ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ser_servicoT.getSer_tx_nome());
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

    public void update(Ser_servicoT ser_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.ser_servico set  ser_tx_nome=?  where  ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ser_servicoT.getSer_tx_nome());
            pStmt.setObject(2, ser_servicoT.getSer_nr_id());
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

    public void delete(Ser_servicoT ser_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.ser_servico where  ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ser_servicoT.getSer_nr_id());
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

    private List<Ser_servicoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ser_servicoT> objs = new Vector();
        while (rs.next()) {
            Ser_servicoT ser_servicoT = new Ser_servicoT();
            ser_servicoT.setSer_nr_id(rs.getInt("ser_nr_id"));
            ser_servicoT.setSer_tx_nome(rs.getString("ser_tx_nome"));
            objs.add(ser_servicoT);
        }
        return objs;
    }

    public List<Ser_servicoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.ser_servico order by ser_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ser_servicoT> list = resultSetToObjectTransfer(rs);
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

    public List<Ser_servicoT> getByPK(Ser_servicoT ser_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.ser_servico where  ser_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ser_servicoT.getSer_nr_id());
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

    public List<Ser_servicoT> getBySer_nr_id(Ser_servicoT ser_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.ser_servico where  ser_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ser_servicoT.getSer_nr_id());
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


    public List<Ser_servicoT> getBySet_nr_id(String setores) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer("select distinct ser.* from handcopy2.ser_servico ser where ser.ser_nr_id in (select ser_nr_id from handcopy2.sst_servido_setor  sst where sst.set_nr_id in  ");
            sql.append(setores);
            sql.append(" ) order by ser.ser_tx_nome");
            //String sql = "select ser.* from handcopy2.ser_servico ser, handcopy2.sst_servido_setor sst where  sst.set_nr_id = ? and sst.ser_nr_id=ser.ser_nr_id order by ser.ser_tx_nome";
            pStmt = con.prepareStatement(sql.toString());
            //pStmt.setObject(1, setNrId);
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
    public List<Ser_servicoT> getBySet_nr_id(int setNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ser.* from handcopy2.ser_servico ser, handcopy2.sst_servido_setor sst where  sst.set_nr_id = ? and sst.ser_nr_id=ser.ser_nr_id order by ser.ser_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, setNrId);
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

    public List<Ser_servicoT> getByNaoSet_nr_id(int setNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ser.* from handcopy2.ser_servico ser where ser.ser_nr_id not in (select ser_nr_id from handcopy2.sst_servido_setor sst where set_nr_id=?) order by ser.ser_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, setNrId);
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

    public List<Ser_servicoT> getBySer_tx_nome(Ser_servicoT ser_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.ser_servico where  Upper(ser_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ser_servicoT.getSer_tx_nome() + '%');
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
