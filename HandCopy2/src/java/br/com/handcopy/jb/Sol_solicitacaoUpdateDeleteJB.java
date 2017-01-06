package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sol_solicitacaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Sol_solicitacaoT sol_solicitacaoT = new Sol_solicitacaoT();

  public void setSol_solicitacaoT(Sol_solicitacaoT sol_solicitacaoT) {
    this.sol_solicitacaoT = sol_solicitacaoT;
  }

  public Sol_solicitacaoT getSol_solicitacaoT() {	
    return sol_solicitacaoT;
  }

	
  private List<Sol_solicitacaoT> list;

  public List<Sol_solicitacaoT> getList() {
    return list;
  }
  
  public void setList(List<Sol_solicitacaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCoc_cota_colaborador();

  }

  public void clear() throws Exception {
    
      sol_solicitacaoT = new Sol_solicitacaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
        sol_solicitacaoDAO.delete(sol_solicitacaoT);	 
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
      Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
      List<Sol_solicitacaoT> listTemp  = sol_solicitacaoDAO.getByPK( sol_solicitacaoT);	 

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
        Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
        sol_solicitacaoDAO.update(sol_solicitacaoT);	 
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
	private List<Coc_cota_colaboradorT> listcoc_cota_colaborador;
	public List<Coc_cota_colaboradorT> getListcoc_cota_colaborador() {
		return listcoc_cota_colaborador;
	}

	 public void setListcoc_cota_colaborador(List<Coc_cota_colaboradorT> list) {
		this.listcoc_cota_colaborador=list;
	}
	public void consultCoc_cota_colaborador() throws Exception {
		try {
			Coc_cota_colaboradorDAO coc_cota_colaboradorDAO = getCoc_cota_colaboradorDAO();
			listcoc_cota_colaborador=coc_cota_colaboradorDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Sol_solicitacaoDAO sol_solicitacaoDAO = getSol_solicitacaoDAO();
      List<Sol_solicitacaoT> listTemp  = sol_solicitacaoDAO.getByPK( sol_solicitacaoT);	 

      sol_solicitacaoT= listTemp.size()>0?listTemp.get(0):new Sol_solicitacaoT();
      
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
	  String page = "sol_solicitacaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "sol_solicitacaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
