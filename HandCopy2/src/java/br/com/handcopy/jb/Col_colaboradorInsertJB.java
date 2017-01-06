package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Col_colaboradorInsertJB extends SystemBase {

  // Atributos e propriedades
    private Col_colaboradorT col_colaboradorT = new Col_colaboradorT();

  public void setCol_colaboradorT(Col_colaboradorT col_colaboradorT) {
    this.col_colaboradorT = col_colaboradorT;
  }

  public Col_colaboradorT getCol_colaboradorT() {	
    return col_colaboradorT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Col_colaboradorDAO col_colaboradorDAO =  getCol_colaboradorDAO();
      col_colaboradorDAO.insert(col_colaboradorT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      col_colaboradorT = new Col_colaboradorT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "col_colaboradorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
