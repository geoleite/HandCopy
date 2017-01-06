/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.aparato.client.handcopy.handcopy2;

import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Set_setorTGWT;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Util {
    public static int getCodigoSetorRaiz(List<Set_setorTGWT> listSet) {
        int codRaiz = Integer.MAX_VALUE;
        for (int i = 0; i < listSet.size(); i++) {
            Set_setorTGWT setT = listSet.get(i);
            if (codRaiz > setT.getSet_nr_idsetorpai()) {
                codRaiz = setT.getSet_nr_idsetorpai();
            }
        }
        return codRaiz;
    }
}
