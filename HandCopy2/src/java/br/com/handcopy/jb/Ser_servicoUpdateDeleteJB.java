package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ser_servicoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ser_servicoT ser_servicoT = new Ser_servicoT();

  public void setSer_servicoT(Ser_servicoT ser_servicoT) {
    this.ser_servicoT = ser_servicoT;
  }

  public Ser_servicoT getSer_servicoT() {	
    return ser_servicoT;
  }

	
  private List<Ser_servicoT> list;

  public List<Ser_servicoT> getList() {
    return list;
  }
  
  public void setList(List<Ser_servicoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      ser_servicoT = new Ser_servicoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
        ser_servicoDAO.delete(ser_servicoT);	 
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
      Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
      List<Ser_servicoT> listTemp  = ser_servicoDAO.getByPK( ser_servicoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
        ser_servicoDAO.update(ser_servicoT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
      List<Ser_servicoT> listTemp  = ser_servicoDAO.getByPK( ser_servicoT);	 

      ser_servicoT= listTemp.size()>0?listTemp.get(0):new Ser_servicoT();
      
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
	  String page = "ser_servicoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ser_servicoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
