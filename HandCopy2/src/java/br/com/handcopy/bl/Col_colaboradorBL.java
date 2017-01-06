package br.com.handcopy.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Col_colaboradorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Col_colaboradorT col_colaboradorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Col_colaboradorDAO col_colaboradorDAO =  getCol_colaboradorDAO();
      col_colaboradorDAO.insert(col_colaboradorT);	 
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
  public List<Col_colaboradorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
      return col_colaboradorDAO.getAll();	 
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
  public boolean delete(Col_colaboradorT col_colaboradorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(col_colaboradorT)) {
        Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
        col_colaboradorDAO.delete(col_colaboradorT);	 
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
  public boolean exist(Col_colaboradorT col_colaboradorT) throws Exception {
   try {
	
      Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
      List<Col_colaboradorT> listTemp  = col_colaboradorDAO.getByPK(col_colaboradorT);	 

      return listTemp.size()>0;      
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
  public Col_colaboradorT findbyid(Col_colaboradorT col_colaboradorT) throws Exception {
    try {
      Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
      List<Col_colaboradorT> listTemp  = col_colaboradorDAO.getByPK( col_colaboradorT);	 

      return listTemp.size()>0?listTemp.get(0):new Col_colaboradorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
