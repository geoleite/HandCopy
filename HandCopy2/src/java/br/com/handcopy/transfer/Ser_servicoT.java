package br.com.handcopy.transfer;

import br.com.easynet.annotation.Conversion;

public class Ser_servicoT {

    private int ser_nr_id;
    private String ser_tx_nome;

    public void setSer_nr_id(int ser_nr_id) {
        this.ser_nr_id = ser_nr_id;
    }

    public int getSer_nr_id() {
        return ser_nr_id;
    }

    public void setSer_tx_nome(String ser_tx_nome) {
        this.ser_tx_nome = ser_tx_nome;
    }

    public String getSer_tx_nome() {
        return ser_tx_nome;
    }
}
