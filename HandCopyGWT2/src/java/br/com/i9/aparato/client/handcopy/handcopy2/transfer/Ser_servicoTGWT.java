
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
public class Ser_servicoTGWT extends BaseModel {
  public Ser_servicoTGWT() {
  }

  public int getSer_nr_id() {
    return  ((Integer)get("ser_nr_id")).intValue();
//    return get("ser_nr_id");
  }

  public void setSer_nr_id(int ser_nr_id) {
    set("ser_nr_id", ser_nr_id);
  }

  public String getSer_tx_nome() {
    return  get("ser_tx_nome");
//    return get("ser_tx_nome");
  }

  public void setSer_tx_nome(String ser_tx_nome) {
    set("ser_tx_nome", ser_tx_nome);
  }



}

