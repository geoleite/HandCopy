package br.com.handcopy.transfer;

import br.com.easynet.annotation.Conversion;

public class Vw_col_colaboradorT {
    private int col_nr_id;
    private String col_tx_nome;
    private String col_tx_login;
    private String col_tx_status;
    private String col_tx_email;
    private String col_tx_senha;
    private String col_tx_confsenha;

    public void setCol_tx_nome(String col_tx_nome) {
        this.col_tx_nome = col_tx_nome;
    }

    public String getCol_tx_nome() {
        return col_tx_nome;
    }

    public void setCol_tx_login(String col_tx_login) {
        this.col_tx_login = col_tx_login;
    }

    public String getCol_tx_login() {
        return col_tx_login;
    }

    public void setCol_tx_status(String col_tx_status) {
        this.col_tx_status = col_tx_status;
    }

    public String getCol_tx_status() {
        return col_tx_status;
    }

    public void setCol_tx_email(String col_tx_email) {
        this.col_tx_email = col_tx_email;
    }

    public String getCol_tx_email() {
        return col_tx_email;
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

    /**
     * @return the col_tx_senha
     */
    public String getCol_tx_senha() {
        return col_tx_senha;
    }

    /**
     * @param col_tx_senha the col_tx_senha to set
     */
    public void setCol_tx_senha(String col_tx_senha) {
        this.col_tx_senha = col_tx_senha;
    }

    /**
     * @return the col_tx_confsenha
     */
    public String getCol_tx_confsenha() {
        return col_tx_confsenha;
    }

    /**
     * @param col_tx_confsenha the col_tx_confsenha to set
     */
    public void setCol_tx_confsenha(String col_tx_confsenha) {
        this.col_tx_confsenha = col_tx_confsenha;
    }
}
