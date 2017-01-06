
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
public class Set_setorTGWT extends BaseModel {
  public Set_setorTGWT() {
      setSet_nr_id(0);
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }

  public String getSet_tx_nome() {
    return  get("set_tx_nome");
//    return get("set_tx_nome");
  }

  public void setSet_tx_nome(String set_tx_nome) {
    set("set_tx_nome", set_tx_nome);
  }

  public String getSet_tx_status() {
    return  get("set_tx_status");
//    return get("set_tx_status");
  }

  public void setSet_tx_status(String set_tx_status) {
    set("set_tx_status", set_tx_status);
  }

  public int getSet_nr_idsetorpai() {
    return  ((Integer)get("set_nr_idsetorpai")).intValue();
//    return get("set_nr_idsetorpai");
  }

  public void setSet_nr_idsetorpai(int set_nr_idsetorpai) {
    set("set_nr_idsetorpai", set_nr_idsetorpai);
  }



}

