package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sec_setor_colaboradorConsultJB extends SystemBase {

  // Atributos e propriedades
    private Sec_setor_colaboradorT sec_setor_colaboradorT = new Sec_setor_colaboradorT();

  public void setSec_setor_colaboradorT(Sec_setor_colaboradorT sec_setor_colaboradorT) {
    this.sec_setor_colaboradorT = sec_setor_colaboradorT;
  }

  public Sec_setor_colaboradorT getSec_setor_colaboradorT() {	
    return sec_setor_colaboradorT;
  }


	
  private List<Sec_setor_colaboradorT> list;

  public List<Sec_setor_colaboradorT> getList() {
    return list;
  }
  
  public void setList(List<Sec_setor_colaboradorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
      list = sec_setor_colaboradorDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Sec_setor_colaboradorDAO sec_setor_colaboradorDAO = getSec_setor_colaboradorDAO();
      sec_setor_colaboradorDAO.delete(sec_setor_colaboradorT);	 
      setMsg("Exclusao efetuada com sucesso!");
      sec_setor_colaboradorT = new Sec_setor_colaboradorT();
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
	  String page = "sec_setor_colaboradorInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
