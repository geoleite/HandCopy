package br.com.handcopy.transfer;

import br.com.easynet.annotation.Conversion;

public class Sec_setor_colaboradorT {

    private int set_nr_id;
    private int col_nr_id;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date sec_dt_alocado;

    public void setSet_nr_id(int set_nr_id) {
        this.set_nr_id = set_nr_id;
    }

    public int getSet_nr_id() {
        return set_nr_id;
    }

    public void setCol_nr_id(int col_nr_id) {
        this.col_nr_id = col_nr_id;
    }

    public int getCol_nr_id() {
        return col_nr_id;
    }

    public void setSec_dt_alocado(java.util.Date sec_dt_alocado) {
        this.sec_dt_alocado = sec_dt_alocado;
    }

    public java.util.Date getSec_dt_alocado() {
        return sec_dt_alocado;
    }
}
