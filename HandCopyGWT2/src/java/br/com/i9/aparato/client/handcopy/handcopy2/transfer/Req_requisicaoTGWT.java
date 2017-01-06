
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
public class Req_requisicaoTGWT extends BaseModel {
  public Req_requisicaoTGWT() {
  }

  public int getReq_nr_id() {
    return  ((Integer)get("req_nr_id")).intValue();
//    return get("req_nr_id");
  }

  public void setReq_nr_id(int req_nr_id) {
    set("req_nr_id", req_nr_id);
  }

  public int getCol_nr_id() {
    return  ((Integer)get("col_nr_id")).intValue();
  }

  public void setCol_nr_id(int col_nr_id) {
    set("col_nr_id", col_nr_id);
  }

  public String getReq_tx_identificador() {
    return  get("req_tx_identificador");
//    return get("req_tx_identificador");
  }

  public void setReq_tx_identificador(String req_tx_identificador) {
    set("req_tx_identificador", req_tx_identificador);
  }

  public String getReq_tx_teriminal() {
    return  get("req_tx_teriminal");
//    return get("req_tx_teriminal");
  }

  public void setReq_tx_teriminal(String req_tx_teriminal) {
    set("req_tx_teriminal", req_tx_teriminal);
  }

  public Date getReq_dt_requisitado() {
    return  (Date)get("req_dt_requisitado");
//    return get("req_dt_requisitado");
  }

  public void setReq_dt_requisitado(Date req_dt_requisitado) {
    set("req_dt_requisitado", req_dt_requisitado);
  }



}

