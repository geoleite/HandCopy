package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ser_servicoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ser_servicoT ser_servicoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ser_servicoDAO ser_servicoDAO =  getSer_servicoDAO();
      ser_servicoDAO.insert(ser_servicoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Ser_servicoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
      return ser_servicoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  /**
   * Deletar um registro
   */	
  public boolean delete(Ser_servicoT ser_servicoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ser_servicoT)) {
        Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
        ser_servicoDAO.delete(ser_servicoT);	 
        return true;
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Verifica se o objeto existe na base
   */
  public boolean exist(Ser_servicoT ser_servicoT) throws Exception {
   try {
	
      Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
      List<Ser_servicoT> listTemp  = ser_servicoDAO.getByPK(ser_servicoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alterac?o na tabela
   */	
  public boolean update(Ser_servicoT ser_servicoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ser_servicoT)) {
        Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
        ser_servicoDAO.update(ser_servicoT);	 
	return true;        
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }   

  /**
   * Obt?m os dados de um registro
   */	
  public Ser_servicoT findbyid(Ser_servicoT ser_servicoT) throws Exception {
    try {
      Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
      List<Ser_servicoT> listTemp  = ser_servicoDAO.getByPK( ser_servicoT);	 

      return listTemp.size()>0?listTemp.get(0):new Ser_servicoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
