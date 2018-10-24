import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public final class ConsultaService {
    private Consulta consulta;

    public ConsultaService() {
        consulta = new Consulta();
    }

    public String adicionarConsulta(Request request) {
        String nome, especialidade;
        LocalDateTime dataConsulta;
        TipoConsulta c = null;

        Query query = request.getQuery();

        nome = query.get("Nome");
        especialidade = query.get("especialidade1");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate date = LocalDate.parse(query.get("dataConsulta"), formatter);
        dataConsulta = date.atStartOfDay();

        c = new TipoConsulta(nome, especialidade, dataConsulta);

        if (c != null) {
            consulta.adicionar(c);
        }

        return c.toString();

    }

    public String pesquisarConsulta(Request request) {

        Query query = request.getQuery();
        String nome = query.get("Nome");
        TipoConsulta c = consulta.consultar(nome);

        return c.toString();

    }

/** Método de cancelar consulta ainda não implementado

    public String cancelarConsulta(Request request) {
        int num = estoque.getNumProdutos();
        Query query = request.getQuery();
        String descricao = query.get("descricao");
        estoque.remover(descricao);

        if (num < estoque.getNumProdutos())
            return "Removido";
        else
            return null;

    }*/

}
