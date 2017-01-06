package br.com.i9.aparato.client.handcopy.handcopy2.dao;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.Constantes;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Coc_cota_colaboradorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Coc_cota_colaboradorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "handcopy/handcopy2/coc_cota_colaborador/coc_cota_colaboradorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/coc_cota_colaborador/coc_cota_colaboradorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/coc_cota_colaborador/coc_cota_colaboradorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Coc_cota_colaboradorTGWT coc_cota_colaboradorT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultarByColaborador(Coc_cota_colaboradorTGWT cocT) {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarByColaborador");
        param.put("coc_cota_colaboradorT.col_nr_id", cocT.getCol_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void consultarMeusSaldosAtualizados() {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarMeusSaldosAtualizados");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void inserir(Coc_cota_colaboradorTGWT coc_cota_colaboradorT) {
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
        param.put("coc_cota_colaboradorT.col_nr_id", coc_cota_colaboradorT.getCol_nr_id() + "");
        param.put("coc_cota_colaboradorT.cot_nr_id", coc_cota_colaboradorT.getCot_nr_id() + "");
        param.put("coc_cota_colaboradorT.set_nr_id", coc_cota_colaboradorT.getSet_nr_id() + "");
        param.put("coc_cota_colaboradorT.ser_nr_id", coc_cota_colaboradorT.getSer_nr_id() + "");
        param.put("coc_cota_colaboradorT.coc_nr_saldo", coc_cota_colaboradorT.getCoc_nr_saldo() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Coc_cota_colaboradorTGWT coc_cota_colaboradorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("coc_cota_colaborador").isObject();
                    Coc_cota_colaboradorDAOGWT.this.coc_cota_colaboradorT = lerRegistroJson(registro);
                }
            }
        };
        this.coc_cota_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("coc_cota_colaboradorT.col_nr_id", coc_cota_colaboradorT.getCol_nr_id() + "");
        param.put("coc_cota_colaboradorT.cot_nr_id", coc_cota_colaboradorT.getCot_nr_id() + "");
        param.put("coc_cota_colaboradorT.set_nr_id", coc_cota_colaboradorT.getSet_nr_id() + "");
        param.put("coc_cota_colaboradorT.ser_nr_id", coc_cota_colaboradorT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Coc_cota_colaboradorTGWT coc_cota_colaboradorT) {
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
        param.put("coc_cota_colaboradorT.col_nr_id", coc_cota_colaboradorT.getCol_nr_id() + "");
        param.put("coc_cota_colaboradorT.cot_nr_id", coc_cota_colaboradorT.getCot_nr_id() + "");
        param.put("coc_cota_colaboradorT.set_nr_id", coc_cota_colaboradorT.getSet_nr_id() + "");
        param.put("coc_cota_colaboradorT.ser_nr_id", coc_cota_colaboradorT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Coc_cota_colaboradorTGWT coc_cota_colaboradorT) {
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
        param.put("coc_cota_colaboradorT.col_nr_id", coc_cota_colaboradorT.getCol_nr_id() + "");
        param.put("coc_cota_colaboradorT.cot_nr_id", coc_cota_colaboradorT.getCot_nr_id() + "");
        param.put("coc_cota_colaboradorT.set_nr_id", coc_cota_colaboradorT.getSet_nr_id() + "");
        param.put("coc_cota_colaboradorT.ser_nr_id", coc_cota_colaboradorT.getSer_nr_id() + "");
        param.put("coc_cota_colaboradorT.coc_nr_saldo", coc_cota_colaboradorT.getCoc_nr_saldo() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Coc_cota_colaboradorTGWT> lista = new ListStore<Coc_cota_colaboradorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Coc_cota_colaboradorTGWT coc_cota_colaboradorT = lerRegistroJson(registro);
                lista.add(coc_cota_colaboradorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Coc_cota_colaboradorTGWT lerRegistroJson(JSONObject registro) {
        Coc_cota_colaboradorTGWT coc_cota_colaboradorTGWT = new Coc_cota_colaboradorTGWT();
        Integer col_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("col_nr_id").toString()));
        coc_cota_colaboradorTGWT.setCol_nr_id(col_nr_id);

        Integer cot_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cot_nr_id").toString()));
        coc_cota_colaboradorTGWT.setCot_nr_id(cot_nr_id);

        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        coc_cota_colaboradorTGWT.setSet_nr_id(set_nr_id);

        Integer ser_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ser_nr_id").toString()));
        coc_cota_colaboradorTGWT.setSer_nr_id(ser_nr_id);

        Integer coc_nr_saldo = Integer.parseInt(EasyContainer.clearAspas(registro.get("coc_nr_saldo").toString()));
        coc_cota_colaboradorTGWT.setCoc_nr_saldo(coc_nr_saldo);


        return coc_cota_colaboradorTGWT;
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
     * @return the coc_cota_colaboradorT
     */
    public Coc_cota_colaboradorTGWT getCoc_cota_colaboradorT() {
        return coc_cota_colaboradorT;
    }

    /**
     * @param coc_cota_colaboradorTGWT the coc_cota_colaboradorTGWT to set
     */
    public void setCoc_cota_colaboradorTGWT(Coc_cota_colaboradorTGWT coc_cota_colaboradorT) {
        this.coc_cota_colaboradorT = coc_cota_colaboradorT;
    }
}
