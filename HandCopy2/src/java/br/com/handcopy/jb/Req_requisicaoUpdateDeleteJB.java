package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Req_requisicaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Req_requisicaoT req_requisicaoT = new Req_requisicaoT();

  public void setReq_requisicaoT(Req_requisicaoT req_requisicaoT) {
    this.req_requisicaoT = req_requisicaoT;
  }

  public Req_requisicaoT getReq_requisicaoT() {	
    return req_requisicaoT;
  }

	
  private List<Req_requisicaoT> list;

  public List<Req_requisicaoT> getList() {
    return list;
  }
  
  public void setList(List<Req_requisicaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      req_requisicaoT = new Req_requisicaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
        req_requisicaoDAO.delete(req_requisicaoT);	 
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
      Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
      List<Req_requisicaoT> listTemp  = req_requisicaoDAO.getByPK( req_requisicaoT);	 

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
        Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
        req_requisicaoDAO.update(req_requisicaoT);	 
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


  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
      List<Req_requisicaoT> listTemp  = req_requisicaoDAO.getByPK( req_requisicaoT);	 

      req_requisicaoT= listTemp.size()>0?listTemp.get(0):new Req_requisicaoT();
      
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
	  String page = "req_requisicaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "req_requisicaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
