package br.com.i9.aparato.client.handcopy.handcopy2.dao;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Sec_setor_colaboradorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Sec_setor_colaboradorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "handcopy/handcopy2/sec_setor_colaborador/sec_setor_colaboradorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/sec_setor_colaborador/sec_setor_colaboradorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/sec_setor_colaborador/sec_setor_colaboradorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Sec_setor_colaboradorTGWT sec_setor_colaboradorT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Sec_setor_colaboradorTGWT sec_setor_colaboradorT) {
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
        param.put("sec_setor_colaboradorT.set_nr_id", sec_setor_colaboradorT.getSet_nr_id() + "");
        param.put("sec_setor_colaboradorT.col_nr_id", sec_setor_colaboradorT.getCol_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMapNoMessage(url, param);
    }

    public void pesquisar(Sec_setor_colaboradorTGWT sec_setor_colaboradorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("sec_setor_colaborador").isObject();
                    Sec_setor_colaboradorDAOGWT.this.sec_setor_colaboradorT = lerRegistroJson(registro);
                }
            }
        };
        this.sec_setor_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("sec_setor_colaboradorT.set_nr_id", sec_setor_colaboradorT.getSet_nr_id() + "");
        param.put("sec_setor_colaboradorT.col_nr_id", sec_setor_colaboradorT.getCol_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Sec_setor_colaboradorTGWT sec_setor_colaboradorT) {
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
        param.put("sec_setor_colaboradorT.set_nr_id", sec_setor_colaboradorT.getSet_nr_id() + "");
        param.put("sec_setor_colaboradorT.col_nr_id", sec_setor_colaboradorT.getCol_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Sec_setor_colaboradorTGWT sec_setor_colaboradorT) {
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
        param.put("sec_setor_colaboradorT.set_nr_id", sec_setor_colaboradorT.getSet_nr_id() + "");
        param.put("sec_setor_colaboradorT.col_nr_id", sec_setor_colaboradorT.getCol_nr_id() + "");
        param.put("sec_setor_colaboradorT.sec_dt_alocado", dtfDate.format(sec_setor_colaboradorT.getSec_dt_alocado()));


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Sec_setor_colaboradorTGWT> lista = new ListStore<Sec_setor_colaboradorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Sec_setor_colaboradorTGWT sec_setor_colaboradorT = lerRegistroJson(registro);
                lista.add(sec_setor_colaboradorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Sec_setor_colaboradorTGWT lerRegistroJson(JSONObject registro) {
        Sec_setor_colaboradorTGWT sec_setor_colaboradorTGWT = new Sec_setor_colaboradorTGWT();
        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        sec_setor_colaboradorTGWT.setSet_nr_id(set_nr_id);

        Integer col_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("col_nr_id").toString()));
        sec_setor_colaboradorTGWT.setCol_nr_id(col_nr_id);

        Date sec_dt_alocado = dtfDate.parse(EasyContainer.clearAspas(registro.get("sec_dt_alocado").toString()));
        sec_setor_colaboradorTGWT.setSec_dt_alocado(sec_dt_alocado);


        return sec_setor_colaboradorTGWT;
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
     * @return the sec_setor_colaboradorT
     */
    public Sec_setor_colaboradorTGWT getSec_setor_colaboradorT() {
        return sec_setor_colaboradorT;
    }

    /**
     * @param sec_setor_colaboradorTGWT the sec_setor_colaboradorTGWT to set
     */
    public void setSec_setor_colaboradorTGWT(Sec_setor_colaboradorTGWT sec_setor_colaboradorT) {
        this.sec_setor_colaboradorT = sec_setor_colaboradorT;
    }
}
