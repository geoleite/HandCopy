package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Col_colaboradorConsultJB extends SystemBase {

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
      list = col_colaboradorDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Col_colaboradorDAO col_colaboradorDAO = getCol_colaboradorDAO();
      col_colaboradorDAO.delete(col_colaboradorT);	 
      setMsg("Exclusao efetuada com sucesso!");
      col_colaboradorT = new Col_colaboradorT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "col_colaboradorInsert.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
