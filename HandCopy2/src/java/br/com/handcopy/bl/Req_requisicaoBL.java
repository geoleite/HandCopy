package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Req_requisicaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Req_requisicaoT req_requisicaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Req_requisicaoDAO req_requisicaoDAO =  getReq_requisicaoDAO();
      req_requisicaoDAO.insert(req_requisicaoT);	 
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
  public List<Req_requisicaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
      return req_requisicaoDAO.getAll();	 
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
  public boolean delete(Req_requisicaoT req_requisicaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(req_requisicaoT)) {
        Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
        req_requisicaoDAO.delete(req_requisicaoT);	 
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
  public boolean exist(Req_requisicaoT req_requisicaoT) throws Exception {
   try {
	
      Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
      List<Req_requisicaoT> listTemp  = req_requisicaoDAO.getByPK(req_requisicaoT);	 

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
  public boolean update(Req_requisicaoT req_requisicaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(req_requisicaoT)) {
        Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
        req_requisicaoDAO.update(req_requisicaoT);	 
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
  public Req_requisicaoT findbyid(Req_requisicaoT req_requisicaoT) throws Exception {
    try {
      Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
      List<Req_requisicaoT> listTemp  = req_requisicaoDAO.getByPK( req_requisicaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Req_requisicaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
