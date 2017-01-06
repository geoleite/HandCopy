package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sst_servido_setorUpdateDeleteJB extends SystemBase {

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
	//
		consultSet_setor();

		consultSer_servico();

  }

  public void clear() throws Exception {
    
      sst_servido_setorT = new Sst_servido_setorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
        sst_servido_setorDAO.delete(sst_servido_setorT);	 
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
      Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
      List<Sst_servido_setorT> listTemp  = sst_servido_setorDAO.getByPK( sst_servido_setorT);	 

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
        Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
        sst_servido_setorDAO.update(sst_servido_setorT);	 
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
	private List<Set_setorT> listset_setor;
	public List<Set_setorT> getListset_setor() {
		return listset_setor;
	}

	 public void setListset_setor(List<Set_setorT> list) {
		this.listset_setor=list;
	}
	public void consultSet_setor() throws Exception {
		try {
			Set_setorDAO set_setorDAO = getSet_setorDAO();
			listset_setor=set_setorDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Ser_servicoT> listser_servico;
	public List<Ser_servicoT> getListser_servico() {
		return listser_servico;
	}

	 public void setListser_servico(List<Ser_servicoT> list) {
		this.listser_servico=list;
	}
	public void consultSer_servico() throws Exception {
		try {
			Ser_servicoDAO ser_servicoDAO = getSer_servicoDAO();
			listser_servico=ser_servicoDAO.getAll();
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
      Sst_servido_setorDAO sst_servido_setorDAO = getSst_servido_setorDAO();
      List<Sst_servido_setorT> listTemp  = sst_servido_setorDAO.getByPK( sst_servido_setorT);	 

      sst_servido_setorT= listTemp.size()>0?listTemp.get(0):new Sst_servido_setorT();
      
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
	  String page = "sst_servido_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "sst_servido_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
