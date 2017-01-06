/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package br.com.i9.imagemanager.gwt.client.set_setorNew;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseTreeModel;

public class SetorTreeModel extends BaseTreeModel implements Serializable {

    private static int ID = 0;

    public int getSet_nr_id() {
        return ((Integer) get("set_nr_id")).intValue();
//    return get("set_nr_id");
    }

    public void setSet_nr_id(int set_nr_id) {
        set("set_nr_id", set_nr_id);
    }

    public String getSet_tx_nome() {
        return get("set_tx_nome");
//    return get("set_tx_nome");
    }

    public void setSet_tx_nome(String set_tx_nome) {
        set("set_tx_nome", set_tx_nome);
    }

    public String getSet_tx_status() {
        return get("set_tx_status");
//    return get("set_tx_status");
    }

    public void setSet_tx_status(String set_tx_status) {
        set("set_tx_status", set_tx_status);
    }

    public int getSet_nr_idsetorpai() {
        return ((Integer) get("set_nr_idsetorpai")).intValue();
//    return get("set_nr_idsetorpai");
    }

    public void setSet_nr_idsetorpai(int set_nr_idsetorpai) {
        set("set_nr_idsetorpai", set_nr_idsetorpai);
    }

    public String toString() {
        return getSet_tx_nome();
    }
}
