package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cot_cotaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cot_cotaT cot_cotaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cot_cotaDAO cot_cotaDAO =  getCot_cotaDAO();
      cot_cotaDAO.insert(cot_cotaT);	 
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
  public List<Cot_cotaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
      return cot_cotaDAO.getAll();	 
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
  public boolean delete(Cot_cotaT cot_cotaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cot_cotaT)) {
        Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
        cot_cotaDAO.delete(cot_cotaT);	 
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
  public boolean exist(Cot_cotaT cot_cotaT) throws Exception {
   try {
	
      Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
      List<Cot_cotaT> listTemp  = cot_cotaDAO.getByPK(cot_cotaT);	 

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
  public boolean update(Cot_cotaT cot_cotaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cot_cotaT)) {
        Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
        cot_cotaDAO.update(cot_cotaT);	 
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
  public Cot_cotaT findbyid(Cot_cotaT cot_cotaT) throws Exception {
    try {
      Cot_cotaDAO cot_cotaDAO = getCot_cotaDAO();
      List<Cot_cotaT> listTemp  = cot_cotaDAO.getByPK( cot_cotaT);	 

      return listTemp.size()>0?listTemp.get(0):new Cot_cotaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
