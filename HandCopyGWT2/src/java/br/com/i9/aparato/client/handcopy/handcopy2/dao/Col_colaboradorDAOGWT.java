package br.com.i9.aparato.client.handcopy.handcopy2.dao;
import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Col_colaboradorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Col_colaboradorDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "handcopy/handcopy2/col_colaborador/col_colaboradorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/col_colaborador/col_colaboradorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/col_colaborador/col_colaboradorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Col_colaboradorTGWT col_colaboradorT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Col_colaboradorTGWT col_colaboradorT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").isString().stringValue();
                    msg = result;
                }
            }
        };
        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
	param.put("col_colaboradorT.col_nr_id" , col_colaboradorT.getCol_nr_id() + "");
param.put("col_colaboradorT.sca_nr_id" , col_colaboradorT.getSca_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Col_colaboradorTGWT col_colaboradorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("col_colaborador").isObject();
                    Col_colaboradorDAOGWT.this.col_colaboradorT = lerRegistroJson(registro);
                }
            }
        };
	this.col_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("col_colaboradorT.col_nr_id" , col_colaboradorT.getCol_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Col_colaboradorTGWT col_colaboradorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
//                    String result = jsonObject.get("resultado").toString();
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
			
//                    msg = result;
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");
        param.put("col_colaboradorT.col_nr_id" , col_colaboradorT.getCol_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Col_colaboradorTGWT col_colaboradorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();

//                    String result = jsonObject.get("resultado").toString();
//                    msg = result;
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
	param.put("col_colaboradorT.col_nr_id" , col_colaboradorT.getCol_nr_id() + "");
param.put("col_colaboradorT.sca_nr_id" , col_colaboradorT.getSca_nr_id() + "");

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Col_colaboradorTGWT> lista = new ListStore<Col_colaboradorTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Col_colaboradorTGWT col_colaboradorT = lerRegistroJson(registro);
                lista.add(col_colaboradorT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteudo json
     */	
    private Col_colaboradorTGWT lerRegistroJson(JSONObject registro) {
	Col_colaboradorTGWT col_colaboradorTGWT = new Col_colaboradorTGWT();
	                Integer col_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("col_nr_id").toString()));
                col_colaboradorTGWT.setCol_nr_id(col_nr_id);

                Integer sca_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("sca_nr_id").toString()));
                col_colaboradorTGWT.setSca_nr_id(sca_nr_id);


	return col_colaboradorTGWT;
    }

    /**
     * @return the list
     */
    public ListStore getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ListStore list) {
        this.list = list;
    }
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the col_colaboradorT
     */
    public Col_colaboradorTGWT getCol_colaboradorT() {
        return col_colaboradorT;
    }

    /**
     * @param col_colaboradorTGWT the col_colaboradorTGWT to set
     */
    public void setCol_colaboradorTGWT(Col_colaboradorTGWT col_colaboradorT) {
        this.col_colaboradorT = col_colaboradorT;
    }
}
