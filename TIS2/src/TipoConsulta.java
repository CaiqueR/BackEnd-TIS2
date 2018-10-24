import java.time.LocalDateTime;

public class TipoConsulta {
    public static final String DESCRICAO_PADRAO = "Nova Consulta";
    public static final int MAX_CONSULTAS = 1000;
    private String nome, especialidade;
    private LocalDateTime dataConsulta;
    private int id;


    private static int cont = 0;
    private static int instancias = 0;

    public TipoConsulta(String n, String e, LocalDateTime d) {
        setNome(n);
        setEspecialidade(e);
        setDataConsulta(d);

        id = ++cont;
        instancias++;
    }

    public TipoConsulta() {
        nome = DESCRICAO_PADRAO;
        especialidade = null;
        dataConsulta = LocalDateTime.now();

        id = ++cont;
        instancias++;
    }

    public LocalDateTime getData() {
        return dataConsulta;
    }

    public void setData(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() >= 3)
            this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public static int getCont() {
        return cont;
    }

    public static int getInstancias() {
        return instancias;
    }

    public int getId() {
        return id;
    }


    /**
     * Método toString sobreposto para exibir em String o dados
     * Nome do paciente
     * Especialidade do Medico
     * Data da consulta
     */
    @Override
    public String toString() {
        return "ID do Paciente: " + id + " \nNome do Paciente: " + nome + "   \nEspecialidade do médico: " + especialidade
                + "\nData: " + dataConsulta;
    }
}



