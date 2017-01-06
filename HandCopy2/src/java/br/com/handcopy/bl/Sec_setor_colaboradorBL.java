package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sec_setor_colaboradorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sec_setor_colaboradorDAO sec_setor_colaboradorDAO =  getSec_setor_colaboradorDAO();
      sec_setor_colaboradorDAO.insert(sec_setor_colaboradorT);	 
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
  public List<Sec_setor_colaboradorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
      return sec_setor_colaboradorDAO.getAll();	 
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
  public boolean delete(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sec_setor_colaboradorT)) {
        Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
        sec_setor_colaboradorDAO.delete(sec_setor_colaboradorT);	 
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
  public boolean exist(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
   try {
	
      Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
      List<Sec_setor_colaboradorT> listTemp  = sec_setor_colaboradorDAO.getByPK(sec_setor_colaboradorT);	 

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
  public boolean update(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sec_setor_colaboradorT)) {
        Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
        sec_setor_colaboradorDAO.update(sec_setor_colaboradorT);	 
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
  public Sec_setor_colaboradorT findbyid(Sec_setor_colaboradorT sec_setor_colaboradorT) throws Exception {
    try {
      Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
      List<Sec_setor_colaboradorT> listTemp  = sec_setor_colaboradorDAO.getByPK( sec_setor_colaboradorT);	 

      return listTemp.size()>0?listTemp.get(0):new Sec_setor_colaboradorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
