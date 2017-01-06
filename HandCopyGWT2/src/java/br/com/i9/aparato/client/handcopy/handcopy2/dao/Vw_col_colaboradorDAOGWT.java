package br.com.i9.aparato.client.handcopy.handcopy2.dao;

import br.com.i9.aparato.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.aparato.client.handcopy.handcopy2.transfer.Vw_col_colaboradorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Vw_col_colaboradorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "handcopy/handcopy2/vw_col_colaborador/vw_col_colaboradorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "handcopy/handcopy2/vw_col_colaborador/vw_col_colaboradorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "handcopy/handcopy2/vw_col_colaborador/vw_col_colaboradorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Vw_col_colaboradorTGWT vw_col_colaboradorT;

    public void consultarTodos() {
        String url = Constantes.URL + PAGE_CONSULTAR;
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void consultSubordinados() {
        this.vw_col_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultSubordinados");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisarSetor(int setNrId) {
        this.vw_col_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarBySetor");
        param.put("set_setorT.set_nr_id", setNrId + "");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisarSetorNome(int setNrId, Vw_col_colaboradorTGWT vw_col_colaboradorT) {
        this.vw_col_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarBySetorNome");
        param.put("vw_col_colaboradorT.col_tx_nome", vw_col_colaboradorT.getCol_tx_nome());
        param.put("set_setorT.set_nr_id", setNrId + "");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisarNome(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
        this.vw_col_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarByNome");
        param.put("vw_col_colaboradorT.col_tx_nome", vw_col_colaboradorT.getCol_tx_nome());

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void inserir(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").isString().stringValue();
                    msg = result;
                    Info.display("DEBUG", "ponto13 " + msg);
                }
            }
        };
        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
        param.put("vw_col_colaboradorT.col_tx_nome", vw_col_colaboradorT.getCol_tx_nome());
        param.put("vw_col_colaboradorT.col_tx_login", vw_col_colaboradorT.getCol_tx_login());
        param.put("vw_col_colaboradorT.col_tx_status", vw_col_colaboradorT.getCol_tx_status());
        param.put("vw_col_colaboradorT.col_tx_email", vw_col_colaboradorT.getCol_tx_email());
        param.put("vw_col_colaboradorT.col_tx_senha", vw_col_colaboradorT.getCol_tx_senha());
        param.put("vw_col_colaboradorT.col_tx_confsenha", vw_col_colaboradorT.getCol_tx_confsenha());
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisarbyLogin(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("vw_col_colaborador").isObject();
                    Vw_col_colaboradorDAOGWT.this.vw_col_colaboradorT = lerRegistroJson(registro);
                }
            }
        };
        this.vw_col_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyLogin");
        param.put("vw_col_colaboradorT.col_tx_login", vw_col_colaboradorT.getCol_tx_login());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("vw_col_colaborador").isObject();
                    Vw_col_colaboradorDAOGWT.this.vw_col_colaboradorT = lerRegistroJson(registro);
                }
            }
        };
        this.vw_col_colaboradorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("vw_col_colaboradorT.col_nr_id", vw_col_colaboradorT.getCol_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
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
        param.put("vw_col_colaboradorT.col_nr_id", vw_col_colaboradorT.getCol_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void excluirUsuario(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
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
        param.put("op", "deleteUsuario");
        param.put("vw_col_colaboradorT.col_nr_id", vw_col_colaboradorT.getCol_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
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
        param.put("vw_col_colaboradorT.col_nr_id", vw_col_colaboradorT.getCol_nr_id() + "");
        param.put("vw_col_colaboradorT.col_tx_nome", vw_col_colaboradorT.getCol_tx_nome());
        param.put("vw_col_colaboradorT.col_tx_login", vw_col_colaboradorT.getCol_tx_login());
        param.put("vw_col_colaboradorT.col_tx_status", vw_col_colaboradorT.getCol_tx_status());
        param.put("vw_col_colaboradorT.col_tx_email", vw_col_colaboradorT.getCol_tx_email());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterarSenha(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
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
        param.put("op", "updateSenha");
        param.put("vw_col_colaboradorT.col_nr_id", vw_col_colaboradorT.getCol_nr_id() + "");
        param.put("vw_col_colaboradorT.col_tx_senha", vw_col_colaboradorT.getCol_tx_senha());
        param.put("vw_col_colaboradorT.col_tx_confsenha", vw_col_colaboradorT.getCol_tx_confsenha());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Vw_col_colaboradorTGWT> lista = new ListStore<Vw_col_colaboradorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Vw_col_colaboradorTGWT vw_col_colaboradorT = lerRegistroJson(registro);
                lista.add(vw_col_colaboradorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Vw_col_colaboradorTGWT lerRegistroJson(JSONObject registro) {
        Vw_col_colaboradorTGWT vw_col_colaboradorTGWT = new Vw_col_colaboradorTGWT();
        String col_tx_nome = EasyContainer.clearAspas(registro.get("col_tx_nome").toString());
        vw_col_colaboradorTGWT.setCol_tx_nome(col_tx_nome);

        String col_tx_login = EasyContainer.clearAspas(registro.get("col_tx_login").toString());
        vw_col_colaboradorTGWT.setCol_tx_login(col_tx_login);

        String col_tx_status = EasyContainer.clearAspas(registro.get("col_tx_status").toString());
        vw_col_colaboradorTGWT.setCol_tx_status(col_tx_status);

        String col_tx_email = EasyContainer.clearAspas(registro.get("col_tx_email").toString());
        vw_col_colaboradorTGWT.setCol_tx_email(col_tx_email);

        Integer col_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("col_nr_id").toString()));
        vw_col_colaboradorTGWT.setCol_nr_id(col_nr_id);

        return vw_col_colaboradorTGWT;
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
     * @return the vw_col_colaboradorT
     */
    public Vw_col_colaboradorTGWT getVw_col_colaboradorT() {
        return vw_col_colaboradorT;
    }

    /**
     * @param vw_col_colaboradorTGWT the vw_col_colaboradorTGWT to set
     */
    public void setVw_col_colaboradorTGWT(Vw_col_colaboradorTGWT vw_col_colaboradorT) {
        this.vw_col_colaboradorT = vw_col_colaboradorT;
    }
}
