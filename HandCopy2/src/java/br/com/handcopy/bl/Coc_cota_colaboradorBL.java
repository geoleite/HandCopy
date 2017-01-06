package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Coc_cota_colaboradorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Coc_cota_colaboradorDAO coc_cota_colaboradorDAO =  getCoc_cota_colaboradorDAO();
      coc_cota_colaboradorDAO.insert(coc_cota_colaboradorT);	 
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
  public List<Coc_cota_colaboradorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
      return coc_cota_colaboradorDAO.getAll();	 
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
  public boolean delete(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(coc_cota_colaboradorT)) {
        Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
        coc_cota_colaboradorDAO.delete(coc_cota_colaboradorT);	 
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
  public boolean exist(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
   try {
	
      Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
      List<Coc_cota_colaboradorT> listTemp  = coc_cota_colaboradorDAO.getByPK(coc_cota_colaboradorT);	 

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
  public boolean update(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(coc_cota_colaboradorT)) {
        Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
        coc_cota_colaboradorDAO.update(coc_cota_colaboradorT);	 
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
  public Coc_cota_colaboradorT findbyid(Coc_cota_colaboradorT coc_cota_colaboradorT) throws Exception {
    try {
      Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
      List<Coc_cota_colaboradorT> listTemp  = coc_cota_colaboradorDAO.getByPK( coc_cota_colaboradorT);	 

      return listTemp.size()>0?listTemp.get(0):new Coc_cota_colaboradorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
