package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Set_setorDAO extends ObjectDAO {

    public Set_setorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into handcopy2.set_setor  ( set_tx_nome, set_tx_status, set_nr_idsetorpai) values ( ? , ? , ?  )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_nome());
            pStmt.setObject(2, set_setorT.getSet_tx_status());
            pStmt.setObject(3, set_setorT.getSet_nr_idsetorpai());
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

    public void update(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update handcopy2.set_setor set  set_tx_nome=?, set_tx_status=?, set_nr_idsetorpai=?  where  set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_nome());
            pStmt.setObject(2, set_setorT.getSet_tx_status());
            pStmt.setObject(3, set_setorT.getSet_nr_idsetorpai());
            pStmt.setObject(4, set_setorT.getSet_nr_id());
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

    public void delete(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from handcopy2.set_setor where  set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
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

    private List<Set_setorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Set_setorT> objs = new Vector();
        while (rs.next()) {
            Set_setorT set_setorT = new Set_setorT();
            set_setorT.setSet_nr_id(rs.getInt("set_nr_id"));
            set_setorT.setSet_tx_nome(rs.getString("set_tx_nome"));
            set_setorT.setSet_tx_status(rs.getString("set_tx_status"));
            set_setorT.setSet_nr_idsetorpai(rs.getInt("set_nr_idsetorpai"));
            objs.add(set_setorT);
        }
        return objs;
    }

    public List<Set_setorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Set_setorT> list = resultSetToObjectTransfer(rs);
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

    public List<Set_setorT> getAllSemPai() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where set_nr_idsetorpai=0 order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Set_setorT> list = resultSetToObjectTransfer(rs);
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

    public List<Set_setorT> getAllFilhos(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where set_nr_idsetorpai=? order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Set_setorT> list = resultSetToObjectTransfer(rs);
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

    public List<Set_setorT> getByPK(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where  set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
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

    public List<Set_setorT> getBySet_nr_id(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
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

    public List<Set_setorT> getBySet_tx_nome(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where  Upper(set_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + set_setorT.getSet_tx_nome() + '%');
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

    public List<Set_setorT> getBySet_tx_status(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where  Upper(set_tx_status) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + set_setorT.getSet_tx_status() + '%');
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

    public List<Set_setorT> getBySet_nr_idsetorpai(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where  set_nr_idsetorpai = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_idsetorpai());
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
    public List<Set_setorT> getBySet_setor(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from handcopy2.set_setor where set_setor.set_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
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
