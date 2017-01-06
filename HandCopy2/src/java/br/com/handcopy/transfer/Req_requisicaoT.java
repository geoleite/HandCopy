package br.com.handcopy.transfer;

import br.com.easynet.annotation.Conversion;

public class Req_requisicaoT { 
	 private int req_nr_id;
	 private int col_nr_id;
	 private String req_tx_identificador;
	 private String req_tx_teriminal;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp req_dt_requisitado;
	 public void setReq_nr_id(int req_nr_id) {
		 this.req_nr_id=req_nr_id;
	}
 
	 public int getReq_nr_id() {
		 return req_nr_id;
 	} 
 	 public void setReq_tx_identificador(String req_tx_identificador) {
		 this.req_tx_identificador=req_tx_identificador;
	}
 
	 public String getReq_tx_identificador() {
		 return req_tx_identificador;
 	} 
 	 public void setReq_tx_teriminal(String req_tx_teriminal) {
		 this.req_tx_teriminal=req_tx_teriminal;
	}
 
	 public String getReq_tx_teriminal() {
		 return req_tx_teriminal;
 	} 
 	 public void setReq_dt_requisitado(java.sql.Timestamp req_dt_requisitado) {
		 this.req_dt_requisitado=req_dt_requisitado;
	}
 
	 public java.sql.Timestamp getReq_dt_requisitado() {
		 return req_dt_requisitado;
 	}

    /**
     * @return the col_nr_id
     */
    public int getCol_nr_id() {
        return col_nr_id;
    }

    /**
     * @param col_nr_id the col_nr_id to set
     */
    public void setCol_nr_id(int col_nr_id) {
        this.col_nr_id = col_nr_id;
    }
 }