package br.com.i9.aparato.client.handcopy.handcopy2.dao;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Req_requisicaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Req_requisicaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "handcopy/handcopy2/req_requisicao/req_requisicaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/req_requisicao/req_requisicaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/req_requisicao/req_requisicaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Req_requisicaoTGWT req_requisicaoT;

    public void consultarTodos() {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
    }

    public void inserir(Req_requisicaoTGWT req_requisicaoT) {
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
        param.put("req_requisicaoT.req_tx_identificador", req_requisicaoT.getReq_tx_identificador());
        param.put("req_requisicaoT.req_tx_teriminal", req_requisicaoT.getReq_tx_teriminal());
        param.put("req_requisicaoT.req_dt_requisitado", dtfDateTime.format(req_requisicaoT.getReq_dt_requisitado()));

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Req_requisicaoTGWT req_requisicaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("req_requisicao").isObject();
                    Req_requisicaoDAOGWT.this.req_requisicaoT = lerRegistroJson(registro);
                }
            }
        };
        this.req_requisicaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("req_requisicaoT.req_nr_id", req_requisicaoT.getReq_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Req_requisicaoTGWT req_requisicaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");
        param.put("req_requisicaoT.req_nr_id", req_requisicaoT.getReq_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Req_requisicaoTGWT req_requisicaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("req_requisicaoT.req_nr_id", req_requisicaoT.getReq_nr_id() + "");
        param.put("req_requisicaoT.req_tx_identificador", req_requisicaoT.getReq_tx_identificador());
        param.put("req_requisicaoT.req_tx_teriminal", req_requisicaoT.getReq_tx_teriminal());
        param.put("req_requisicaoT.req_dt_requisitado", dtfDateTime.format(req_requisicaoT.getReq_dt_requisitado()));


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Req_requisicaoTGWT> lista = new ListStore<Req_requisicaoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Req_requisicaoTGWT req_requisicaoT = lerRegistroJson(registro);
                lista.add(req_requisicaoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Req_requisicaoTGWT lerRegistroJson(JSONObject registro) {
        Req_requisicaoTGWT req_requisicaoTGWT = new Req_requisicaoTGWT();
        Integer req_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("req_nr_id").toString()));
        req_requisicaoTGWT.setReq_nr_id(req_nr_id);

        Integer col_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("col_nr_id").toString()));
        req_requisicaoTGWT.setCol_nr_id(req_nr_id);

        String req_tx_identificador = EasyContainer.clearAspas(registro.get("req_tx_identificador").toString());
        req_requisicaoTGWT.setReq_tx_identificador(req_tx_identificador);

        String req_tx_teriminal = EasyContainer.clearAspas(registro.get("req_tx_teriminal").toString());
        req_requisicaoTGWT.setReq_tx_teriminal(req_tx_teriminal);

        Date req_dt_requisitado = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("req_dt_requisitado").toString()));
        req_requisicaoTGWT.setReq_dt_requisitado(req_dt_requisitado);

        return req_requisicaoTGWT;
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
     * @return the req_requisicaoT
     */
    public Req_requisicaoTGWT getReq_requisicaoT() {
        return req_requisicaoT;
    }

    /**
     * @param req_requisicaoTGWT the req_requisicaoTGWT to set
     */
    public void setReq_requisicaoTGWT(Req_requisicaoTGWT req_requisicaoT) {
        this.req_requisicaoT = req_requisicaoT;
    }
}
