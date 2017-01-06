package br.com.handcopy.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_col_colaboradorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Vw_col_colaboradorDAO vw_col_colaboradorDAO =  getVw_col_colaboradorDAO();
      vw_col_colaboradorDAO.insert(vw_col_colaboradorT);	 
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
  public List<Vw_col_colaboradorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
      return vw_col_colaboradorDAO.getAll();	 
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
  public boolean delete(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(vw_col_colaboradorT)) {
        Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
        vw_col_colaboradorDAO.delete(vw_col_colaboradorT);	 
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
  public boolean exist(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
   try {
	
      Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
      List<Vw_col_colaboradorT> listTemp  = vw_col_colaboradorDAO.getByPK(vw_col_colaboradorT);	 

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
  public boolean update(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(vw_col_colaboradorT)) {
        Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
        vw_col_colaboradorDAO.update(vw_col_colaboradorT);	 
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
  public Vw_col_colaboradorT findbyid(Vw_col_colaboradorT vw_col_colaboradorT) throws Exception {
    try {
      Vw_col_colaboradorDAO vw_col_colaboradorDAO = getVw_col_colaboradorDAO();
      List<Vw_col_colaboradorT> listTemp  = vw_col_colaboradorDAO.getByPK( vw_col_colaboradorT);	 

      return listTemp.size()>0?listTemp.get(0):new Vw_col_colaboradorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
