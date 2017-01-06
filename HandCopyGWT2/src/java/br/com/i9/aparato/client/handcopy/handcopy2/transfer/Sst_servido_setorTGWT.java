
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
public class Sst_servido_setorTGWT extends BaseModel {
  public Sst_servido_setorTGWT() {
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



}

