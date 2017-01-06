package br.com.i9.aparato.client.handcopy.handcopy2.dao;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Cot_cotaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Cot_cotaDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "handcopy/handcopy2/cot_cota/cot_cotaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/cot_cota/cot_cotaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/cot_cota/cot_cotaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Cot_cotaTGWT cot_cotaT;

    public void consultarTodos() {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultarServico(Cot_cotaTGWT cotT) {
        this.cot_cotaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("cot_cotaT.ser_nr_id", cotT.getSer_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void inserir(Cot_cotaTGWT cot_cotaT) {
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
        param.put("cot_cotaT.cot_nr_id", cot_cotaT.getCot_nr_id() + "");
        param.put("cot_cotaT.set_nr_id", cot_cotaT.getSet_nr_id() + "");
        param.put("cot_cotaT.ser_nr_id", cot_cotaT.getSer_nr_id() + "");
        param.put("cot_cotaT.cot_nr_saldo", cot_cotaT.getCot_nr_saldo() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }




    public void pesquisarSetorServico(Cot_cotaTGWT cot_cotaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("cot_cota").isObject();
                    Cot_cotaDAOGWT.this.cot_cotaT = lerRegistroJson(registro);
                }
            }
        };
        this.cot_cotaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyidSetorServico");
        param.put("cot_cotaT.set_nr_id", cot_cotaT.getSet_nr_id() + "");
        param.put("cot_cotaT.ser_nr_id", cot_cotaT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void pesquisar(Cot_cotaTGWT cot_cotaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("cot_cota").isObject();
                    Cot_cotaDAOGWT.this.cot_cotaT = lerRegistroJson(registro);
                }
            }
        };
        this.cot_cotaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("cot_cotaT.cot_nr_id", cot_cotaT.getCot_nr_id() + "");
        param.put("cot_cotaT.set_nr_id", cot_cotaT.getSet_nr_id() + "");
        param.put("cot_cotaT.ser_nr_id", cot_cotaT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Cot_cotaTGWT cot_cotaT) {
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
        param.put("cot_cotaT.cot_nr_id", cot_cotaT.getCot_nr_id() + "");
        param.put("cot_cotaT.set_nr_id", cot_cotaT.getSet_nr_id() + "");
        param.put("cot_cotaT.ser_nr_id", cot_cotaT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Cot_cotaTGWT cot_cotaT) {
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
        param.put("cot_cotaT.cot_nr_id", cot_cotaT.getCot_nr_id() + "");
        param.put("cot_cotaT.set_nr_id", cot_cotaT.getSet_nr_id() + "");
        param.put("cot_cotaT.ser_nr_id", cot_cotaT.getSer_nr_id() + "");
        param.put("cot_cotaT.cot_nr_saldo", cot_cotaT.getCot_nr_saldo() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Cot_cotaTGWT> lista = new ListStore<Cot_cotaTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Cot_cotaTGWT cot_cotaT = lerRegistroJson(registro);
                lista.add(cot_cotaT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Cot_cotaTGWT lerRegistroJson(JSONObject registro) {
        Cot_cotaTGWT cot_cotaTGWT = new Cot_cotaTGWT();
        Integer cot_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cot_nr_id").toString()));
        cot_cotaTGWT.setCot_nr_id(cot_nr_id);

        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        cot_cotaTGWT.setSet_nr_id(set_nr_id);

        Integer ser_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ser_nr_id").toString()));
        cot_cotaTGWT.setSer_nr_id(ser_nr_id);

        Integer cot_nr_saldo = Integer.parseInt(EasyContainer.clearAspas(registro.get("cot_nr_saldo").toString()));
        cot_cotaTGWT.setCot_nr_saldo(cot_nr_saldo);


        return cot_cotaTGWT;
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
     * @return the cot_cotaT
     */
    public Cot_cotaTGWT getCot_cotaT() {
        return cot_cotaT;
    }

    /**
     * @param cot_cotaTGWT the cot_cotaTGWT to set
     */
    public void setCot_cotaTGWT(Cot_cotaTGWT cot_cotaT) {
        this.cot_cotaT = cot_cotaT;
    }
}
