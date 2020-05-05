/*
 * Classe principal para realização do desafio
 */

import desafioCodenation.manipulacaoJSON.IOJson;
import desafioCodenation.manipulacaoJSON.CodenationJSON;
import desafioCodenation.requisicao.Get_HTTP;
import desafioCodenation.requisicao.Post_HTTP;
import org.json.JSONObject;

import static desafioCodenation.criptografia.CriptografiaCesar.criptografiaCesar;
import static desafioCodenation.criptografia.CriptografiaSAH.criptografar;

/**
 * Student information systems Brazil, MG
 *
 * @author Eduardo Almeida <edualmeida.a7@gmail.com>
 * @version 1.0
 * @since May 02, 2020
 */
public class Main {

    public static void main(String[] args) {
        String nomeArquivo = "answer.json";
        Get_HTTP requisicao = new Get_HTTP();
        requisicao.lerRespostaJSON();

        JSONObject jso = requisicao.getRespostaJSON();
        CodenationJSON.imprimirJSON(jso);

        CodenationJSON retornoMAP = new CodenationJSON(jso);
        retornoMAP.setDecifrado(criptografiaCesar(true, retornoMAP.getCifrado(), retornoMAP.getNumeroCasas()));
        retornoMAP.setResumoCriptografico(criptografar("SHA-1", "UTF-8", retornoMAP.getDecifrado()));
        JSONObject obj = retornoMAP.toJSON();

        if(IOJson.gravarJSON(obj, 5, nomeArquivo)){
            System.out.println("--------- Gravado ---------");
            CodenationJSON.imprimirJSON(IOJson.carregarJSON(nomeArquivo));
        }else{
            System.err.println("Falha ao gravar!");
        }

        Post_HTTP send = new Post_HTTP();
        send.sendJSON("answer", "answer.json");
        send.readResponse();
    }
}
