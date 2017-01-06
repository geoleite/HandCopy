
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
public class Coc_cota_colaboradorTGWT extends BaseModel {
  public Coc_cota_colaboradorTGWT() {
  }

  public int getCol_nr_id() {
    return  ((Integer)get("col_nr_id")).intValue();
//    return get("col_nr_id");
  }

  public void setCol_nr_id(int col_nr_id) {
    set("col_nr_id", col_nr_id);
  }

  public int getCot_nr_id() {
    return  ((Integer)get("cot_nr_id")).intValue();
//    return get("cot_nr_id");
  }

  public void setCot_nr_id(int cot_nr_id) {
    set("cot_nr_id", cot_nr_id);
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
//    return get("set_nr_id");
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }

  public int getSer_nr_id() {
    return  ((Integer)get("ser_nr_id")).intValue();
//    return get("ser_nr_id");
  }

  public void setSer_nr_id(int ser_nr_id) {
    set("ser_nr_id", ser_nr_id);
  }

  public int getCoc_nr_saldo() {
    return  ((Integer)get("coc_nr_saldo")).intValue();
//    return get("coc_nr_saldo");
  }

  public void setCoc_nr_saldo(int coc_nr_saldo) {
    set("coc_nr_saldo", coc_nr_saldo);
  }



}

