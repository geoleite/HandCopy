package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Req_requisicaoConsultJB extends SystemBase {

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
      list = req_requisicaoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
      req_requisicaoDAO.delete(req_requisicaoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      req_requisicaoT = new Req_requisicaoT();
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
	  String page = "req_requisicaoInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
