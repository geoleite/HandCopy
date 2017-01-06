package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cot_cotaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Cot_cotaT cot_cotaT = new Cot_cotaT();

  public void setCot_cotaT(Cot_cotaT cot_cotaT) {
    this.cot_cotaT = cot_cotaT;
  }

  public Cot_cotaT getCot_cotaT() {	
    return cot_cotaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultSst_servido_setor();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Cot_cotaDAO cot_cotaDAO =  getCot_cotaDAO();
      cot_cotaDAO.insert(cot_cotaT);	 
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
	private List<Sst_servido_setorT> listsst_servido_setor;
	public List<Sst_servido_setorT> getListsst_servido_setor() {
		return listsst_servido_setor;
	}

	 public void setListsst_servido_setor(List<Sst_servido_setorT> list) {
		this.listsst_servido_setor=list;
	}
	public void consultSst_servido_setor() throws Exception {
		try {
			Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
			listsst_servido_setor=sst_servido_setorDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      cot_cotaT = new Cot_cotaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cot_cotaConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
