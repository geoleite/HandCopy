package br.com.i9.aparato.client.handcopy.handcopy2.dao;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Sst_servido_setorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Sst_servido_setorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "handcopy/handcopy2/sst_servido_setor/sst_servido_setorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/sst_servido_setor/sst_servido_setorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/sst_servido_setor/sst_servido_setorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Sst_servido_setorTGWT sst_servido_setorT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Sst_servido_setorTGWT sst_servido_setorT) {
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
        param.put("sst_servido_setorT.set_nr_id", sst_servido_setorT.getSet_nr_id() + "");
        param.put("sst_servido_setorT.ser_nr_id", sst_servido_setorT.getSer_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Sst_servido_setorTGWT sst_servido_setorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("sst_servido_setor").isObject();
                    Sst_servido_setorDAOGWT.this.sst_servido_setorT = lerRegistroJson(registro);
                }
            }
        };
        this.sst_servido_setorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("sst_servido_setorT.set_nr_id", sst_servido_setorT.getSet_nr_id() + "");
        param.put("sst_servido_setorT.ser_nr_id", sst_servido_setorT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Sst_servido_setorTGWT sst_servido_setorT) {
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
        param.put("sst_servido_setorT.set_nr_id", sst_servido_setorT.getSet_nr_id() + "");
        param.put("sst_servido_setorT.ser_nr_id", sst_servido_setorT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Sst_servido_setorTGWT sst_servido_setorT) {
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
        param.put("sst_servido_setorT.set_nr_id", sst_servido_setorT.getSet_nr_id() + "");
        param.put("sst_servido_setorT.ser_nr_id", sst_servido_setorT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Sst_servido_setorTGWT> lista = new ListStore<Sst_servido_setorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Sst_servido_setorTGWT sst_servido_setorT = lerRegistroJson(registro);
                lista.add(sst_servido_setorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Sst_servido_setorTGWT lerRegistroJson(JSONObject registro) {
        Sst_servido_setorTGWT sst_servido_setorTGWT = new Sst_servido_setorTGWT();
        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        sst_servido_setorTGWT.setSet_nr_id(set_nr_id);

        Integer ser_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ser_nr_id").toString()));
        sst_servido_setorTGWT.setSer_nr_id(ser_nr_id);


        return sst_servido_setorTGWT;
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
     * @return the sst_servido_setorT
     */
    public Sst_servido_setorTGWT getSst_servido_setorT() {
        return sst_servido_setorT;
    }

    /**
     * @param sst_servido_setorTGWT the sst_servido_setorTGWT to set
     */
    public void setSst_servido_setorTGWT(Sst_servido_setorTGWT sst_servido_setorT) {
        this.sst_servido_setorT = sst_servido_setorT;
    }
}
