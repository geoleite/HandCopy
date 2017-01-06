package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sol_solicitacaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sol_solicitacaoDAO sol_solicitacaoDAO =  getSol_solicitacaoDAO();
      sol_solicitacaoDAO.insert(sol_solicitacaoT);	 
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
  public List<Sol_solicitacaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
      return sol_solicitacaoDAO.getAll();	 
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
  public boolean delete(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sol_solicitacaoT)) {
        Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
        sol_solicitacaoDAO.delete(sol_solicitacaoT);	 
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
  public boolean exist(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
   try {
	
      Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
      List<Sol_solicitacaoT> listTemp  = sol_solicitacaoDAO.getByPK(sol_solicitacaoT);	 

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
  public boolean update(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sol_solicitacaoT)) {
        Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
        sol_solicitacaoDAO.update(sol_solicitacaoT);	 
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
  public Sol_solicitacaoT findbyid(Sol_solicitacaoT sol_solicitacaoT) throws Exception {
    try {
      Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
      List<Sol_solicitacaoT> listTemp  = sol_solicitacaoDAO.getByPK( sol_solicitacaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Sol_solicitacaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
