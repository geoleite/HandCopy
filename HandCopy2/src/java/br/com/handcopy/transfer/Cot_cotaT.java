package br.com.handcopy.transfer;

import br.com.easynet.annotation.Conversion;

public class Cot_cotaT { 
	 private int cot_nr_id;
	 private int set_nr_id;
	 private int ser_nr_id;
	 private int cot_nr_saldo;
	 public void setCot_nr_id(int cot_nr_id) {
		 this.cot_nr_id=cot_nr_id;
	}
 
	 public int getCot_nr_id() {
		 return cot_nr_id;
 	} 
 	 public void setSet_nr_id(int set_nr_id) {
		 this.set_nr_id=set_nr_id;
	}
 
	 public int getSet_nr_id() {
		 return set_nr_id;
 	} 
 	 public void setSer_nr_id(int ser_nr_id) {
		 this.ser_nr_id=ser_nr_id;
	}
 
	 public int getSer_nr_id() {
		 return ser_nr_id;
 	} 
 	 public void setCot_nr_saldo(int cot_nr_saldo) {
		 this.cot_nr_saldo=cot_nr_saldo;
	}
 
	 public int getCot_nr_saldo() {
		 return cot_nr_saldo;
 	} 
 }