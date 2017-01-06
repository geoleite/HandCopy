package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Set_setorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Set_setorT set_setorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Set_setorDAO set_setorDAO =  getSet_setorDAO();
      set_setorDAO.insert(set_setorT);	 
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
  public List<Set_setorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Set_setorDAO set_setorDAO = getSet_setorDAO();
      return set_setorDAO.getAll();	 
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
  public boolean delete(Set_setorT set_setorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(set_setorT)) {
        Set_setorDAO set_setorDAO = getSet_setorDAO();
        set_setorDAO.delete(set_setorT);	 
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
  public boolean exist(Set_setorT set_setorT) throws Exception {
   try {
	
      Set_setorDAO set_setorDAO = getSet_setorDAO();
      List<Set_setorT> listTemp  = set_setorDAO.getByPK(set_setorT);	 

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
  public boolean update(Set_setorT set_setorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(set_setorT)) {
        Set_setorDAO set_setorDAO = getSet_setorDAO();
        set_setorDAO.update(set_setorT);	 
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
  public Set_setorT findbyid(Set_setorT set_setorT) throws Exception {
    try {
      Set_setorDAO set_setorDAO = getSet_setorDAO();
      List<Set_setorT> listTemp  = set_setorDAO.getByPK( set_setorT);	 

      return listTemp.size()>0?listTemp.get(0):new Set_setorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
