
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
public class Col_colaboradorTGWT extends BaseModel {
  public Col_colaboradorTGWT() {
  }

  public int getCol_nr_id() {
    return  ((Integer)get("col_nr_id")).intValue();
//    return get("col_nr_id");
  }

  public void setCol_nr_id(int col_nr_id) {
    set("col_nr_id", col_nr_id);
  }

  public int getSca_nr_id() {
    return  ((Integer)get("sca_nr_id")).intValue();
//    return get("sca_nr_id");
  }

  public void setSca_nr_id(int sca_nr_id) {
    set("sca_nr_id", sca_nr_id);
  }



}

