
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
public class Sol_solicitacaoTGWT extends BaseModel {
  public Sol_solicitacaoTGWT() {
  }

  public int getSol_nr_id() {
    return  ((Integer)get("sol_nr_id")).intValue();
//    return get("sol_nr_id");
  }

  public void setSol_nr_id(int sol_nr_id) {
    set("sol_nr_id", sol_nr_id);
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

  public Date getSol_dt_datahora() {
    return  (Date)get("sol_dt_datahora");
//    return get("sol_dt_datahora");
  }

  public void setSol_dt_datahora(Date sol_dt_datahora) {
    set("sol_dt_datahora", sol_dt_datahora);
  }

  public String getSol_tx_idterminal() {
    return  get("sol_tx_idterminal");
//    return get("sol_tx_idterminal");
  }

  public void setSol_tx_idterminal(String sol_tx_idterminal) {
    set("sol_tx_idterminal", sol_tx_idterminal);
  }

  public int getSol_nr_quantidade() {
    return  ((Integer)get("sol_nr_quantidade")).intValue();
//    return get("sol_nr_quantidade");
  }

  public void setSol_nr_quantidade(int sol_nr_quantidade) {
    set("sol_nr_quantidade", sol_nr_quantidade);
  }



}

