
/*
 * EasyNet JDragon
 */
package br.com.i9.aparato.client.handcopy.handcopy2.transfer;
import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Sec_setor_colaboradorTGWT extends BaseModel {
  public Sec_setor_colaboradorTGWT() {
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
//    return get("set_nr_id");
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }

  public int getCol_nr_id() {
    return  ((Integer)get("col_nr_id")).intValue();
//    return get("col_nr_id");
  }

  public void setCol_nr_id(int col_nr_id) {
    set("col_nr_id", col_nr_id);
  }

  public Date getSec_dt_alocado() {
    return  (Date)get("sec_dt_alocado");
//    return get("sec_dt_alocado");
  }

  public void setSec_dt_alocado(Date sec_dt_alocado) {
    set("sec_dt_alocado", sec_dt_alocado);
  }



}

