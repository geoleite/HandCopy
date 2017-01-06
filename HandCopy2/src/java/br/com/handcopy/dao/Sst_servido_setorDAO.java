package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.handcopy.transfer.*;

public class Sst_servido_setorDAO extends ObjectDAO { 
	 public Sst_servido_setorDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Sst_servido_setorT sst_servido_setorT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into handcopy2.sst_servido_setor  ( set_nr_id, ser_nr_id) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, sst_servido_setorT.getSet_nr_id());
			 pStmt.setObject(2, sst_servido_setorT.getSer_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Sst_servido_setorT sst_servido_setorT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update handcopy2.sst_servido_setor set - where  set_nr_id=? and ser_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, sst_servido_setorT.getSet_nr_id());
			 pStmt.setObject(2, sst_servido_setorT.getSer_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Sst_servido_setorT sst_servido_setorT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from handcopy2.sst_servido_setor where  set_nr_id=? and ser_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, sst_servido_setorT.getSet_nr_id());
			 pStmt.setObject(2, sst_servido_setorT.getSer_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Sst_servido_setorT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Sst_servido_setorT> objs = new Vector();
		 while (rs.next()) { 
 			 Sst_servido_setorT sst_servido_setorT = new Sst_servido_setorT();
			 sst_servido_setorT.setSet_nr_id(rs.getInt("set_nr_id"));
			 sst_servido_setorT.setSer_nr_id(rs.getInt("ser_nr_id"));
			 objs.add(sst_servido_setorT);
 		 }
 		 return objs; 
 	 }
	 public List<Sst_servido_setorT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from handcopy2.sst_servido_setor"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Sst_servido_setorT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Sst_servido_setorT> getByPK(Sst_servido_setorT sst_servido_setorT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from handcopy2.sst_servido_setor where  set_nr_id=? and ser_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, sst_servido_setorT.getSet_nr_id());
			 pStmt.setObject(2, sst_servido_setorT.getSer_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Sst_servido_setorT> getBySet_nr_id(Sst_servido_setorT sst_servido_setorT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from handcopy2.sst_servido_setor where  set_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, sst_servido_setorT.getSet_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Sst_servido_setorT> getBySer_nr_id(Sst_servido_setorT sst_servido_setorT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from handcopy2.sst_servido_setor where  ser_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, sst_servido_setorT.getSer_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
	/** Metodos FK */
	 public List<Sst_servido_setorT> getBySet_setor(Sst_servido_setorT sst_servido_setorT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from handcopy2.sst_servido_setor where set_setor.set_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, sst_servido_setorT.getSet_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	/** Metodos FK */
	 public List<Sst_servido_setorT> getBySer_servico(Sst_servido_setorT sst_servido_setorT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from handcopy2.sst_servido_setor where ser_servico.ser_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, sst_servido_setorT.getSer_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
 }