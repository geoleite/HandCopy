package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ser_servicoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ser_servicoT ser_servicoT = new Ser_servicoT();

  public void setSer_servicoT(Ser_servicoT ser_servicoT) {
    this.ser_servicoT = ser_servicoT;
  }

  public Ser_servicoT getSer_servicoT() {	
    return ser_servicoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Ser_servicoDAO ser_servicoDAO =  getSer_servicoDAO();
      ser_servicoDAO.insert(ser_servicoT);	 
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
    
      ser_servicoT = new Ser_servicoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ser_servicoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
