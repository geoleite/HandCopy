package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sst_servido_setorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Sst_servido_setorT sst_servido_setorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sst_servido_setorDAO sst_servido_setorDAO =  getSst_servido_setorDAO();
      sst_servido_setorDAO.insert(sst_servido_setorT);	 
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
  public List<Sst_servido_setorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
      return sst_servido_setorDAO.getAll();	 
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
  public boolean delete(Sst_servido_setorT sst_servido_setorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sst_servido_setorT)) {
        Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
        sst_servido_setorDAO.delete(sst_servido_setorT);	 
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
  public boolean exist(Sst_servido_setorT sst_servido_setorT) throws Exception {
   try {
	
      Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
      List<Sst_servido_setorT> listTemp  = sst_servido_setorDAO.getByPK(sst_servido_setorT);	 

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
  public boolean update(Sst_servido_setorT sst_servido_setorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sst_servido_setorT)) {
        Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
        sst_servido_setorDAO.update(sst_servido_setorT);	 
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
  public Sst_servido_setorT findbyid(Sst_servido_setorT sst_servido_setorT) throws Exception {
    try {
      Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
      List<Sst_servido_setorT> listTemp  = sst_servido_setorDAO.getByPK( sst_servido_setorT);	 

      return listTemp.size()>0?listTemp.get(0):new Sst_servido_setorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
