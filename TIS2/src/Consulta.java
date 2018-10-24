/**
 * Esta classe pode armazenar uma lista de consulta
 * de varios pacientes do sistema de SUS
 */

public class Consulta {
    private static final int QTD_MAX_DE_CONSULTA = 100;
    private TipoConsulta[] listaDeConsulta;
    private int numDeConsultas;

    public Consulta() {
        listaDeConsulta = new TipoConsulta[QTD_MAX_DE_CONSULTA];
        numDeConsultas = 0;
    }

    public int getNumDeConsultas() {
        return numDeConsultas;
    }

    public void adicionar(TipoConsulta novaConsulta) {
        if (numDeConsultas < QTD_MAX_DE_CONSULTA) {
            listaDeConsulta[numDeConsultas++] = novaConsulta;
        }
    }

    public TipoConsulta consultar(String nomePaciente) {
        for (int pos = 0; pos < numDeConsultas; pos++) {
            if (nomePaciente.equalsIgnoreCase(listaDeConsulta[pos].getNome())) {
                return listaDeConsulta[pos];
            }
        }
        return null; // Consulta não encontrada.
    }

/** Método para remover consulta ainda nao implmentado

   public void remover(String nomePaciente) {
        for (int pos = 0; pos < numDeConsultas; pos++) {
            if (nomePaciente.equalsIgnoreCase(listaDeConsulta[pos].getNome())) {
                // Remover consulta
                for (int i = pos + 1; i < numDeConsultas; i++)
                    listaDeConsulta[i - 1] = listaDeConsulta[i];
                listaDeConsulta[numDeConsultas - 1] = null;
                numDeConsultas--;
            }
        }
    }*/


    @Override
    public String toString() {
        StringBuilder valor = new StringBuilder();
        for (int i = 0; i < numDeConsultas; i++) {
            valor.append(listaDeConsulta[i] + "\n");
        }
        return valor.toString();
    }
}
