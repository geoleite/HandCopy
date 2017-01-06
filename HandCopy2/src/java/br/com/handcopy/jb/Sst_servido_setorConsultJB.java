package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sst_servido_setorConsultJB extends SystemBase {

  // Atributos e propriedades
    private Sst_servido_setorT sst_servido_setorT = new Sst_servido_setorT();

  public void setSst_servido_setorT(Sst_servido_setorT sst_servido_setorT) {
    this.sst_servido_setorT = sst_servido_setorT;
  }

  public Sst_servido_setorT getSst_servido_setorT() {	
    return sst_servido_setorT;
  }


	
  private List<Sst_servido_setorT> list;

  public List<Sst_servido_setorT> getList() {
    return list;
  }
  
  public void setList(List<Sst_servido_setorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
      list = sst_servido_setorDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
      sst_servido_setorDAO.delete(sst_servido_setorT);	 
      setMsg("Exclusao efetuada com sucesso!");
      sst_servido_setorT = new Sst_servido_setorT();
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
	  String page = "sst_servido_setorInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
