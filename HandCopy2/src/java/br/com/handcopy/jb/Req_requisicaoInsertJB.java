package br.com.handcopy.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.handcopy.dao.*;
import br.com.handcopy.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Req_requisicaoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Req_requisicaoT req_requisicaoT = new Req_requisicaoT();

    public void setReq_requisicaoT(Req_requisicaoT req_requisicaoT) {
        this.req_requisicaoT = req_requisicaoT;
    }

    public Req_requisicaoT getReq_requisicaoT() {
        return req_requisicaoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M?todos de Eventos
    public void insert() throws Exception {

        try {
            Req_requisicaoDAO req_requisicaoDAO = getReq_requisicaoDAO();
            req_requisicaoDAO.insert(req_requisicaoT);
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    public void clear() throws Exception {

        req_requisicaoT = new Req_requisicaoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "req_requisicaoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
