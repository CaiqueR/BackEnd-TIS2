import java.io.PrintStream;


import org.json.JSONException;
import org.json.JSONObject;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;

public class Site implements Container {


    static ConsultaService consultaService;


    public void handle(Request request, Response response) {
        try {
            // Recupera a URL e o método utilizado.

            String path = request.getPath().getPath();
            String method = request.getMethod();
            String mensagem;

            // Verifica qual ação está sendo chamada

            if (path.startsWith("/adicionarConsulta") && "POST".equals(method)) {
                // http://127.0.0.1:880/adicionarProduto?descricao=leite&preco=3.59&quant=10&tipo=2&dataFabricacao=2017-01-01
                mensagem = consultaService.adicionarConsulta(request);
                this.enviaResposta(Status.CREATED, response, mensagem);

            } else if (path.startsWith("/pesquisarConsulta") && "GET".equals(method)) {
                // http://127.0.0.1:880/consultarProduto?descricao=leite
                mensagem = consultaService.pesquisarConsulta(request);
                this.enviaResposta(Status.OK, response, mensagem);
            } else {
                this.naoEncontrado(response, path);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void naoEncontrado(Response response, String path) throws Exception {
        JSONObject error = new JSONObject();
        error.put("error", "Não encontrado.");
        error.put("path", path);
        enviaResposta(Status.NOT_FOUND, response, error.toString());
    }

    private void enviaResposta(Status status, Response response, String str) throws Exception {

        PrintStream body = response.getPrintStream();
        long time = System.currentTimeMillis();

        response.setValue("Content-Type", "application/json");
        response.setValue("Server", "Controle de consultaService (1.0)");
        response.setDate("Date", time);
        response.setDate("Last-Modified", time);
        response.setStatus(status);

        if (str != null)
            body.println(str);
        body.close();
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        return json;
    }


}

