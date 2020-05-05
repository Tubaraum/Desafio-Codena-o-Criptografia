package desafioCodenation.requisicao;

import desafioCodenation.manipulacaoJSON.CodenationJSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Student information systems Brazil, MG
 *
 * @author Eduardo Almeida <edualmeida.a7@gmail.com>
 * @version 1.0
 * @since May 02, 2020
 */
public class Get_HTTP {

    private String token = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" +
                                    "bad3e290e4068d174c5bf1ad1e34abcb9e173e85";
    private JSONObject respostaJSON;
    private int codResposta;

    /**
     * Construtor vazio que faz a requisição get ao link pré-informado
     * salvando nos atributos da classe as respostas
     */
    public Get_HTTP() {
        this.requisicao();
    }

    /**
     * @return Link atual para requisição get
     */
    public String getToken() {
        return this.token;
    }

    /**
     * @param token Link valido para a requisiçãoo get
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return Resposta da requisicao em JSON (que é o esperado)
     */
    public JSONObject getRespostaJSON() {
        return this.respostaJSON;
    }

    /**
     * @return Código de resposta, normalmente 200-206 sucesso na requição
     */
    public int getCodResposta() {
        return this.codResposta;
    }

    /**
     * Método que faz a requisição em cima do token informado e salva as
     * respostas nos devidos atributos da classe
     */
    private void requisicao() {
        try {
            URL urlBusca = new URL(token);
            HttpURLConnection conexao = (HttpURLConnection) urlBusca.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("User-Agent", "Mozilla/5.0");
            codResposta = conexao.getResponseCode();
            System.out.println("\nEnviando requisição 'GET' para: \n" + token + "\n");
            System.out.println("Código de resposta: " + codResposta);
            try (BufferedReader bfr = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
                String inputLine;
                StringBuilder resposta = new StringBuilder();
                while ((inputLine = bfr.readLine()) != null) {
                    resposta.append(inputLine);
                }
                this.respostaJSON = new JSONObject(resposta.toString());
            }
        } catch (IOException | JSONException mue) {
            mue.getMessage();
        }
    }

    /**
     * Leia a resposta em JSON da requisição caso exista
     */
    public void lerRespostaJSON() {
        if (!this.respostaJSON.isEmpty()) {
            CodenationJSON.imprimirJSON(this.respostaJSON);
        } else {
            System.err.println("Sem resposta.");
        }
    }
}
