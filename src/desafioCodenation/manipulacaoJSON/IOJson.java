/*
 * Classe para exportar e importar objetos JSON
 */

package desafioCodenation.manipulacaoJSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Student information systems Brazil, MG
 *
 * @author Eduardo Almeida <edualmeida.a7@gmail.com>
 * @version 1.0
 * @since May 02, 2020
 */
public class IOJson {

    /**
     * Método para gravar um Objeto JSON na máquina
     *
     * @param jobjt      Objeto json
     * @param numStrings número de strings por tupla do Objeto
     * @param nomeArq    nome para o arquivo ou caminho
     * @return
     */
    public static boolean gravarJSON(JSONObject jobjt, int numStrings, String nomeArq) {
        try {
            FileWriter file = new FileWriter(nomeArq);
            file.write(jobjt.toString(numStrings));
            file.flush();
            file.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo");
        } catch (JSONException jex) {
            jex.getMessage();
        }
        return false;
    }

    /**
     * Método para carregar um Objeto JSON da máquina
     *
     * @param nomeArquivo nome do arquivo ou caminho
     * @return o Objeto JSON ou null
     */
    public static JSONObject carregarJSON(String nomeArquivo) {
        try {
            //*********************************
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb = sb.append(line);
            }
            br.close();
            fr.close();
            // ********************************
            return new JSONObject(sb.toString());
        } catch (IOException ioe) {
            System.err.println("Erro ao ler arquivo " + nomeArquivo);
        } catch (JSONException e) {
            System.err.println("Erro ao manipular " + nomeArquivo);
        }
        return null;
    }

}
