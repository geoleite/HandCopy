/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.handcopy.relatorio;

import br.com.easynet.database.DataSet;
import br.com.easynet.database.RowDS;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.easyportal.relatorio.RelatorioPortal;
import br.com.easynet.relatorio.RelatorioBase;
import br.com.handcopy.dao.Sol_solicitacaoDAO;
import br.com.handcopy.jb.SystemBase;
import br.com.handcopy.transfer.Ser_servicoT;
import br.com.handcopy.transfer.Set_setorT;
import br.com.handcopy.transfer.Sol_solicitacaoT;
import br.com.handcopy.transfer.Vw_col_colaboradorT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author geoleite
 */
public class Rel_UsuariosCadastrados extends RelatorioPortal implements INotSecurity {

    private SystemBase sb = new SystemBase();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {

        try {
            Set_setorT set_setorT = (Set_setorT)getSession().getAttribute(sb.SETOR);
            Set_setorT setTPai = sb.verificaSetorEPai(set_setorT);
            List<UsuariosSetorREL> listRel = getTransferToRel(setTPai);
            jRDataSource = new JRBeanCollectionDataSource(listRel);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Rel_TicketSolicitacao.class.getResourceAsStream("usuariosCadastrados.jasper");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            getParameters().put("empresa", setTPai.getSet_tx_nome());
            getParameters().put("setor", set_setorT.getSet_tx_nome());
            getParameters().put("nomeUsuario", getUsuarioLogado().getUsu_tx_nome());
            getParameters().put("dataSolicitacao", sdf.format(new Date()));
            print("UsuariosCadastrados", "UsuariosCadastrados");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
    }

    private List<UsuariosSetorREL> getTransferToRel(Set_setorT setTRaiz) throws Exception {
        String sql = "select col.col_tx_nome, col.col_tx_login, setor.set_tx_nome from handcopy2.vw_col_colaborador  col, handcopy2.sec_setor_colaborador sec, handcopy2.set_setor setor where setor.set_nr_id=? and col.col_nr_id = sec.col_nr_id and sec.set_nr_id= setor.set_nr_id order by col_tx_nome";
        Object[] parameters = {setTRaiz.getSet_nr_id()};
        DataSet ds = sb.getSet_setorDAO().executeQuery(sql, parameters);

        List<UsuariosSetorREL> listRel = new ArrayList<UsuariosSetorREL>();
        List<RowDS> list = ds.getList();
        for (RowDS rowDS : list) {
            UsuariosSetorREL usRel = new UsuariosSetorREL();
            usRel.setUsuario((String)rowDS.getColumn("col_tx_nome"));
            usRel.setSetor((String)rowDS.getColumn("set_tx_nome"));
            listRel.add(usRel);
        }

//        for (Sol_solicitacaoT solT : listSol) {
//            ServicoSolicitadoREL ssRel = new ServicoSolicitadoREL();
//            ssRel.setIp(solT.getSol_tx_idterminal());
//            ssRel.setQuantidade(solT.getSol_nr_quantidade());
//            ssRel.setServico(treeSer.get(solT.getSer_nr_id()).getSer_tx_nome());
//            listRel.add(ssRel);
//        }
        return listRel;
    }
}
