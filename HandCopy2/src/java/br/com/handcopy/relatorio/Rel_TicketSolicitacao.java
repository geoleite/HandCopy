/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.handcopy.relatorio;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.easyportal.relatorio.RelatorioPortal;
import br.com.easynet.relatorio.RelatorioBase;
import br.com.handcopy.dao.Sol_solicitacaoDAO;
import br.com.handcopy.jb.SystemBase;
import br.com.handcopy.transfer.Ser_servicoT;
import br.com.handcopy.transfer.Set_setorT;
import br.com.handcopy.transfer.Sol_solicitacaoT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author geoleite
 */
public class Rel_TicketSolicitacao extends RelatorioPortal implements INotSecurity {

    private List<Sol_solicitacaoT> list = new ArrayList<Sol_solicitacaoT>();
    private SystemBase sb = new SystemBase();
    
    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {

        try {
            Set_setorT set_setorT = (Set_setorT)getSession().getAttribute(sb.SETOR);
            Set_setorT setTPai = sb.verificaSetorEPai(set_setorT);
            
            List<Sol_solicitacaoT> listSol = (List<Sol_solicitacaoT>) getSession().getAttribute(sb.SOLICITACAO_IMPRESSAO);
            if (listSol != null && listSol.size() > 0) {
                Sol_solicitacaoDAO dAO = sb.getSol_solicitacaoDAO();
//            list = dAO.getAll();
                List<ServicoSolicitadoREL> listRel = getTransferToRel(listSol);
                jRDataSource = new JRBeanCollectionDataSource(listRel);

                if (!getTipo().equalsIgnoreCase("XLS")) {
                    is = Rel_TicketSolicitacao.class.getResourceAsStream("solicitacao.jasper");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                getParameters().put("empresa", setTPai.getSet_tx_nome());
                getParameters().put("setor", set_setorT.getSet_tx_nome());
                getParameters().put("nomeUsuario", getUsuarioLogado().getUsu_tx_nome());
                getParameters().put("dataSolicitacao", sdf.format(listSol.get(0).getSol_dt_datahora()));
                print("Solicitacoes", "Solicitacoes");
                getSession().removeAttribute(sb.SOLICITACAO_IMPRESSAO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
    }

    private List<ServicoSolicitadoREL> getTransferToRel(List<Sol_solicitacaoT> listSol) throws Exception {
        List<Ser_servicoT> listSer = sb.getSer_servicoDAO().getAll();
        TreeMap<Integer, Ser_servicoT> treeSer = new TreeMap<Integer, Ser_servicoT>();
        for (int i = 0; i < listSer.size(); i++) {
            Ser_servicoT serT = listSer.get(i);
            treeSer.put(serT.getSer_nr_id(), serT);
        }
        List<ServicoSolicitadoREL> listRel = new ArrayList<ServicoSolicitadoREL>();
        for (Sol_solicitacaoT solT : listSol) {
            ServicoSolicitadoREL ssRel = new ServicoSolicitadoREL();
            ssRel.setIp(solT.getSol_tx_idterminal());
            ssRel.setQuantidade(solT.getSol_nr_quantidade());
            ssRel.setServico(treeSer.get(solT.getSer_nr_id()).getSer_tx_nome());
            listRel.add(ssRel);
        }
        return listRel;
    }
}
