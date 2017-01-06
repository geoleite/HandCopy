/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.handcopy.jb;

import br.com.handcopy.transfer.Vw_col_colaboradorT;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.handcopy.transfer.Sec_setor_colaboradorT;
import br.com.handcopy.transfer.Set_setorT;
import java.util.List;

/**
 *br.com.aparato.handcopy.jb.LoadPerfilDiretor
 * @author geoleite
 */
public class LoadPerfilChefe extends SystemBase {

    public void pageLoad() throws Exception {
        try {
            Usu_usuarioT usuT = (Usu_usuarioT) getSession().getAttribute(br.com.easynet.portal.jb.SystemBase.USER_PRINCIPAL);
            setUsuarioLogado(usuT);
            //    SystemBase sb = new SystemBase();
            Vw_col_colaboradorT colT = new Vw_col_colaboradorT();
            colT.setCol_nr_id(usuT.getUsu_nr_id());
            colT = findbyIdVw_col_colaborador(colT);
            getSession().setAttribute(COLABORADOR, colT);

            Sec_setor_colaboradorT sec_setor_colaboradorT = new Sec_setor_colaboradorT();
            sec_setor_colaboradorT.setCol_nr_id(colT.getCol_nr_id());
            List<Sec_setor_colaboradorT> listSec = getSec_setor_colaboradorDAO().getByCol_nr_id(sec_setor_colaboradorT);

            Set_setorT set_setorT = null;
            if (listSec.size() > 0) {
                set_setorT = new Set_setorT();
                sec_setor_colaboradorT = listSec.get(0);
                set_setorT.setSet_nr_id(sec_setor_colaboradorT.getSet_nr_id());
                List<Set_setorT> listSet = getSet_setorDAO().getByPK(set_setorT);
                set_setorT = listSet.size() > 0 ? listSet.get(0) : null;
                if (set_setorT != null) {
                    getSession().setAttribute(SETOR, set_setorT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
