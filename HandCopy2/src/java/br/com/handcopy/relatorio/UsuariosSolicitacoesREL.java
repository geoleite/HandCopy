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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;

/**
 *
 * @author geoleite
 */
public class UsuariosSolicitacoesREL extends RelatorioPortal implements INotSecurity {

    private SystemBase sb = new SystemBase();

    public void imprimir() {
        try {

            Set_setorT set_setorT = (Set_setorT) getSession().getAttribute(sb.SETOR);
            Set_setorT setTPai = sb.verificaSetorEPai(set_setorT);

            //jRDataSource = new JRBeanCollectionDataSource(listRel);
            //jRDataSource = new JREmptyDataSource();


            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Rel_TicketSolicitacao.class.getResourceAsStream("usuariosServico.jasper");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            getParameters().put("empresa", setTPai.getSet_tx_nome());
            getParameters().put("setor", set_setorT.getSet_tx_nome());
            getParameters().put("nomeUsuario", getUsuarioLogado().getUsu_tx_nome());
            getParameters().put("dataSolicitacao", sdf.format(new Date()));
            String pathJasper = getApplication().getInitParameter("pathRelatorio");
            getParameters().put("SUBREPORT_DIR", pathJasper);

            baos = new ByteArrayOutputStream();
            JasperFillManager.fillReportToStream(is, baos, getParameters(), sb.getDAO().getConnection());

            bais = new ByteArrayInputStream(baos.toByteArray());
            baos = new ByteArrayOutputStream();
            jasperExportManager.exportReportToPdfStream(bais, baos);
            setFileName("UsuariosSolicitacoes.pdf");
            getRequest().setAttribute(easyDownloadJB.CONTENT_TYPE, "application/easypdf");
            getRequest().setAttribute(easyDownloadJB.FILE_NAME, getFileName());
            getRequest().setAttribute(easyDownloadJB.DATA, baos.toByteArray());
            getPage().forward("/portal/easydownload.jsp");

            //print("Solicitacoes", "Solicitacoes");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }

    }
}
