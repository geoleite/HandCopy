package br.com.handcopy.transfer;

import br.com.easynet.annotation.Conversion;
//br.com.handcopy.transfer.Sol_solicitacaoT
public class Sol_solicitacaoT {

    private int sol_nr_id;
    private int col_nr_id;
    private int cot_nr_id;
    private int set_nr_id;
    private int ser_nr_id;
    private int req_nr_id;
    @Conversion(classe = "br.com.easynet.convesion.ConvertTimestamp", format = "dd/MM/yyyy HH:mm")
    private java.sql.Timestamp sol_dt_datahora;
    private String sol_tx_idterminal;
    private int sol_nr_quantidade;

    public void setSol_nr_id(int sol_nr_id) {
        this.sol_nr_id = sol_nr_id;
    }

    public int getSol_nr_id() {
        return sol_nr_id;
    }

    public void setCol_nr_id(int col_nr_id) {
        this.col_nr_id = col_nr_id;
    }

    public int getCol_nr_id() {
        return col_nr_id;
    }

    public void setCot_nr_id(int cot_nr_id) {
        this.cot_nr_id = cot_nr_id;
    }

    public int getCot_nr_id() {
        return cot_nr_id;
    }

    public void setSet_nr_id(int set_nr_id) {
        this.set_nr_id = set_nr_id;
    }

    public int getSet_nr_id() {
        return set_nr_id;
    }

    public void setSer_nr_id(int ser_nr_id) {
        this.ser_nr_id = ser_nr_id;
    }

    public int getSer_nr_id() {
        return ser_nr_id;
    }

    public void setSol_dt_datahora(java.sql.Timestamp sol_dt_datahora) {
        this.sol_dt_datahora = sol_dt_datahora;
    }

    public java.sql.Timestamp getSol_dt_datahora() {
        return sol_dt_datahora;
    }

    public void setSol_tx_idterminal(String sol_tx_idterminal) {
        this.sol_tx_idterminal = sol_tx_idterminal;
    }

    public String getSol_tx_idterminal() {
        return sol_tx_idterminal;
    }

    public void setSol_nr_quantidade(int sol_nr_quantidade) {
        this.sol_nr_quantidade = sol_nr_quantidade;
    }

    public int getSol_nr_quantidade() {
        return sol_nr_quantidade;
    }

    /**
     * @return the req_nr_id
     */
    public int getReq_nr_id() {
        return req_nr_id;
    }

    /**
     * @param req_nr_id the req_nr_id to set
     */
    public void setReq_nr_id(int req_nr_id) {
        this.req_nr_id = req_nr_id;
    }
}
