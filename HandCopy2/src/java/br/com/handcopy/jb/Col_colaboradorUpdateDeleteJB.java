package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Col_colaboradorUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Col_colaboradorT col_colaboradorT = new Col_colaboradorT();

  public void setCol_colaboradorT(Col_colaboradorT col_colaboradorT) {
    this.col_colaboradorT = col_colaboradorT;
  }

  public Col_colaboradorT getCol_colaboradorT() {	
    return col_colaboradorT;
  }

	
  private List<Col_colaboradorT> list;

  public List<Col_colaboradorT> getList() {
    return list;
  }
  
  public void setList(List<Col_colaboradorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      col_colaboradorT = new Col_colaboradorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
        col_colaboradorDAO.delete(col_colaboradorT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
      List<Col_colaboradorT> listTemp  = col_colaboradorDAO.getByPK( col_colaboradorT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

 

// Method de lookup
// 


  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
      List<Col_colaboradorT> listTemp  = col_colaboradorDAO.getByPK( col_colaboradorT);	 

      col_colaboradorT= listTemp.size()>0?listTemp.get(0):new Col_colaboradorT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p?gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "col_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "col_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
