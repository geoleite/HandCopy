
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
public class Vw_col_colaboradorTGWT extends BaseModel {
  public Vw_col_colaboradorTGWT() {
  }

  public String getCol_tx_nome() {
    return  get("col_tx_nome");
//    return get("col_tx_nome");
  }

  public void setCol_tx_nome(String col_tx_nome) {
    set("col_tx_nome", col_tx_nome);
  }

  public String getCol_tx_senha() {
    return  get("col_tx_senha");
//    return get("col_tx_nome");
  }

  public void setCol_tx_senha(String col_tx_senha) {
    set("col_tx_senha", col_tx_senha);
  }

  public String getCol_tx_confsenha() {
    return  get("col_tx_confsenha");
//    return get("col_tx_nome");
  }

  public void setCol_tx_confsenha(String col_tx_confsenha) {
    set("col_tx_confsenha", col_tx_confsenha);
  }

  public String getCol_tx_login() {
    return  get("col_tx_login");
//    return get("col_tx_login");
  }

  public void setCol_tx_login(String col_tx_login) {
    set("col_tx_login", col_tx_login);
  }

  public String getCol_tx_status() {
    return  get("col_tx_status");
//    return get("col_tx_status");
  }

  public void setCol_tx_status(String col_tx_status) {
    set("col_tx_status", col_tx_status);
  }

  public String getCol_tx_email() {
    return  get("col_tx_email");
//    return get("col_tx_email");
  }

  public void setCol_tx_email(String col_tx_email) {
    set("col_tx_email", col_tx_email);
  }

  public int getCol_nr_id() {
    return  ((Integer)get("col_nr_id")).intValue();
  }

  public void setCol_nr_id(int col_nr_id) {
    set("col_nr_id", col_nr_id);
  }
}

