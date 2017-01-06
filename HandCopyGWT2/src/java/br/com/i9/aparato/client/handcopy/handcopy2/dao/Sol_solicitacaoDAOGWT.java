package br.com.i9.aparato.client.handcopy.handcopy2.dao;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.Constantes;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Sol_solicitacaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Sol_solicitacaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "handcopy/handcopy2/sol_solicitacao/sol_solicitacaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/sol_solicitacao/sol_solicitacaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/sol_solicitacao/sol_solicitacaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Sol_solicitacaoTGWT sol_solicitacaoT;

    public void consultarTodos() {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void consultarMinhasSolicitacoes() {
        this.sol_solicitacaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarMinhasSolicitacoes");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }
    public void consultarPorColaborador(Sol_solicitacaoTGWT sol_solicitacaoT) {
        this.sol_solicitacaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarPorColaborador");
        param.put("sol_solicitacaoT.col_nr_id", sol_solicitacaoT.getCol_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void inserir(Sol_solicitacaoTGWT sol_solicitacaoT) {
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
        param.put("sol_solicitacaoT.ser_nr_id", sol_solicitacaoT.getSer_nr_id() + "");
        param.put("sol_solicitacaoT.sol_nr_quantidade", sol_solicitacaoT.getSol_nr_quantidade() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Sol_solicitacaoTGWT sol_solicitacaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("sol_solicitacao").isObject();
                    Sol_solicitacaoDAOGWT.this.sol_solicitacaoT = lerRegistroJson(registro);
                }
            }
        };
        this.sol_solicitacaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("sol_solicitacaoT.sol_nr_id", sol_solicitacaoT.getSol_nr_id() + "");
        param.put("sol_solicitacaoT.col_nr_id", sol_solicitacaoT.getCol_nr_id() + "");
        param.put("sol_solicitacaoT.cot_nr_id", sol_solicitacaoT.getCot_nr_id() + "");
        param.put("sol_solicitacaoT.set_nr_id", sol_solicitacaoT.getSet_nr_id() + "");
        param.put("sol_solicitacaoT.ser_nr_id", sol_solicitacaoT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Sol_solicitacaoTGWT sol_solicitacaoT) {
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
        param.put("sol_solicitacaoT.sol_nr_id", sol_solicitacaoT.getSol_nr_id() + "");
        param.put("sol_solicitacaoT.col_nr_id", sol_solicitacaoT.getCol_nr_id() + "");
        param.put("sol_solicitacaoT.cot_nr_id", sol_solicitacaoT.getCot_nr_id() + "");
        param.put("sol_solicitacaoT.set_nr_id", sol_solicitacaoT.getSet_nr_id() + "");
        param.put("sol_solicitacaoT.ser_nr_id", sol_solicitacaoT.getSer_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Sol_solicitacaoTGWT sol_solicitacaoT) {
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
        param.put("sol_solicitacaoT.sol_nr_id", sol_solicitacaoT.getSol_nr_id() + "");
        param.put("sol_solicitacaoT.col_nr_id", sol_solicitacaoT.getCol_nr_id() + "");
        param.put("sol_solicitacaoT.cot_nr_id", sol_solicitacaoT.getCot_nr_id() + "");
        param.put("sol_solicitacaoT.set_nr_id", sol_solicitacaoT.getSet_nr_id() + "");
        param.put("sol_solicitacaoT.ser_nr_id", sol_solicitacaoT.getSer_nr_id() + "");
        param.put("sol_solicitacaoT.sol_dt_datahora", dtfDateTime.format(sol_solicitacaoT.getSol_dt_datahora()));
        param.put("sol_solicitacaoT.sol_tx_idterminal", sol_solicitacaoT.getSol_tx_idterminal());
        param.put("sol_solicitacaoT.sol_nr_quantidade", sol_solicitacaoT.getSol_nr_quantidade() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Sol_solicitacaoTGWT> lista = new ListStore<Sol_solicitacaoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Sol_solicitacaoTGWT sol_solicitacaoT = lerRegistroJson(registro);
                lista.add(sol_solicitacaoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Sol_solicitacaoTGWT lerRegistroJson(JSONObject registro) {
        Sol_solicitacaoTGWT sol_solicitacaoTGWT = new Sol_solicitacaoTGWT();
        Integer sol_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("sol_nr_id").toString()));
        sol_solicitacaoTGWT.setSol_nr_id(sol_nr_id);

        Integer col_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("col_nr_id").toString()));
        sol_solicitacaoTGWT.setCol_nr_id(col_nr_id);

        Integer cot_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cot_nr_id").toString()));
        sol_solicitacaoTGWT.setCot_nr_id(cot_nr_id);

        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        sol_solicitacaoTGWT.setSet_nr_id(set_nr_id);

        Integer ser_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ser_nr_id").toString()));
        sol_solicitacaoTGWT.setSer_nr_id(ser_nr_id);

        Date sol_dt_datahora = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("sol_dt_datahora").toString()));
        sol_solicitacaoTGWT.setSol_dt_datahora(sol_dt_datahora);

        String sol_tx_idterminal = EasyContainer.clearAspas(registro.get("sol_tx_idterminal").toString());
        sol_solicitacaoTGWT.setSol_tx_idterminal(sol_tx_idterminal);

        Integer sol_nr_quantidade = Integer.parseInt(EasyContainer.clearAspas(registro.get("sol_nr_quantidade").toString()));
        sol_solicitacaoTGWT.setSol_nr_quantidade(sol_nr_quantidade);


        return sol_solicitacaoTGWT;
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
     * @return the sol_solicitacaoT
     */
    public Sol_solicitacaoTGWT getSol_solicitacaoT() {
        return sol_solicitacaoT;
    }

    /**
     * @param sol_solicitacaoTGWT the sol_solicitacaoTGWT to set
     */
    public void setSol_solicitacaoTGWT(Sol_solicitacaoTGWT sol_solicitacaoT) {
        this.sol_solicitacaoT = sol_solicitacaoT;
    }
}
