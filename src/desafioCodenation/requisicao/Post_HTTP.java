package desafioCodenation.requisicao;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Student information systems Brazil, MG
 *
 * @author Eduardo Almeida <edualmeida.a7@gmail.com>
 * @version 1.0
 * @since May 02, 2020
 */
public class Post_HTTP {
    private String token;
    private String response;
    private int codResponse;

    /**
     * Construtor vazio
     */
    public Post_HTTP() {
        this.response = "Nada enviado";
        this.codResponse = 0;
        this.token = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=bad3e290e4068d174c5bf1ad1e34abcb9e173e85";
    }

    /**
     * Método para enviar via POST
     *
     * @param titulo     Nome do arquivo a ser enviado
     * @param caminhoArq Caminho do arquivo para envio
     */
    public void sendJSON(String titulo, String caminhoArq) {
        try {
            URL url = new URL(this.token);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setDoOutput(true);
            conexao.setRequestMethod("POST");
            MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.STRICT);
            multipartEntity.addPart(titulo, new FileBody(new File(caminhoArq)));
            conexao.setRequestProperty("Content-Type", multipartEntity.getContentType().getValue());
            OutputStream out = conexao.getOutputStream();
            multipartEntity.writeTo(out);
            this.codResponse = conexao.getResponseCode();
            this.response = conexao.getResponseMessage();
            out.close();
            conexao.disconnect();
            if (this.codResponse >= 200 && this.codResponse <= 206) {
                System.err.println("Enviado");
            } else {
                System.err.println("Falhou ao enviar");
                System.err.println("Código de resposta " + this.codResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ler a resposta do POST
     */
    public void readResponse() {
        System.out.println("Resposta de " + this.token + "\n");
        System.out.println(this.codResponse + " - " + this.response);
    }

    /**
     * @return String com o token de POST
     */
    public String getToken() {
        return this.token;
    }

    /**
     * @return Resposta do POST
     */
    public String getResponse() {
        return this.response;
    }

}