/*
 * Classe para manipulação de um arquivo tipo JSON de uma requisição HTTP
 * Não é uma classe universal, projetada para o uso em questão
 */
package desafioCodenation.manipulacaoJSON;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Student information systems Brazil, MG
 *
 * @author Eduardo Almeida <edualmeida.a7@gmail.com>
 * @version 1.0
 * @since May 02, 2020
 */
public class CodenationJSON {

    private int numeroCasas;
    private String token;
    private String cifrado;
    private String decifrado;
    private String resumoCriptografico;

    /**
     * Construtor vazio
     */
    public CodenationJSON() {
    }

    /**
     * Construtor com os campos pré-informados
     *
     * @param numeroCasas         número de casas da cifra de Cesar
     * @param token               token do usuuário da codenation
     * @param cifrado             mensagem cifrada
     * @param decifrado           mensagem decifrada
     * @param resumoCriptografico resumo da criptografia SAH-1
     */
    public CodenationJSON(int numeroCasas, String token, String cifrado, String decifrado, String resumoCriptografico) {
        this.numeroCasas = numeroCasas;
        this.token = token;
        this.cifrado = cifrado;
        this.decifrado = decifrado;
        this.resumoCriptografico = resumoCriptografico;
    }

    /**
     * Construtor a partir do JSON dos campos já montados
     *
     * @param jsobjct JSON com as informações
     */
    public CodenationJSON(JSONObject jsobjct) {
        try {
            this.numeroCasas = jsobjct.getInt("numero_casas");
            this.token = jsobjct.getString("token");
            this.cifrado = jsobjct.getString("cifrado");
            this.decifrado = jsobjct.getString("decifrado");
            this.resumoCriptografico = jsobjct.getString("resumo_criptografico");
        } catch (JSONException jex) {
            System.err.println("Objeto JSON não é do tipo esperado");
        }
    }

    /**
     * @return Objeto JSON com os campos da classe
     */
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("numero_casas", this.numeroCasas);
        obj.put("token", this.token);
        obj.put("cifrado", this.cifrado);
        obj.put("decifrado", this.decifrado);
        obj.put("resumo_criptografico", this.resumoCriptografico);
        return obj;
    }

    /**
     * Método para mostrar na tela os atributos da classe
     */
    public void imprimir() {
        System.out.println(
                        "---------------------------------------\n"
                        + "Número_casas = " + this.numeroCasas + "\n"
                        + "Token = " + this.token + "\n"
                        + "Cifrado = " + this.cifrado + "\n"
                        + "Decifrado =  " + this.decifrado + "\n"
                        + "Resumo_criptografico = " + this.resumoCriptografico + "\n"
                        + "-------------------------------------"
        );
    }

    /**
     * Método para mostrar na tela um Ojeto JSON
     *
     * @param jsobjct Objeto JSON tipo CodenationJSON
     * @apiNote Espera-se um Objeto JSON formatado no tipo CodenationJSON
     */
    public static void imprimirJSON(JSONObject jsobjct) {
        if (jsobjct != null) {
            System.out.println(
                    "---------------------------------------\n"
                            + "Número_casas = " + jsobjct.getInt("numero_casas") + "\n"
                            + "Token = " + jsobjct.getString("token") + "\n"
                            + "Cifrado = " + jsobjct.getString("cifrado") + "\n"
                            + "Decifrado =  " + jsobjct.getString("decifrado") + "\n"
                            + "Resumo_criptografico = " + jsobjct.getString("resumo_criptografico") + "\n"
                            + "-------------------------------------"
            );
        } else {
            System.err.println("Arquivo vazio");
        }
    }

    /**
     * @return número de casas para cifra de Cesar
     */
    public int getNumeroCasas() {
        return this.numeroCasas;
    }

    /**
     * Alterar número de casas para cifra de cesar
     *
     * @param numeroCasas número inteiro
     */
    public void setNumeroCasas(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    /**
     * @return token do usuário codenation
     */
    public String getToken() {
        return token;
    }

    /**
     * Alterar token do usuário codenation
     *
     * @param token string com o token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return mensagem cifrada
     */
    public String getCifrado() {
        return cifrado;
    }

    /**
     * Alterar o campo da mensagem cifrada
     *
     * @param cifrado String com a mensagem
     */
    public void setCifrado(String cifrado) {
        this.cifrado = cifrado;
    }

    /**
     * @return mensagem decifrada
     */
    public String getDecifrado() {
        return decifrado;
    }

    /**
     * Alterar o campo da mensagem decifrada
     *
     * @param decifrado String com a mensagem
     */
    public void setDecifrado(String decifrado) {
        this.decifrado = decifrado;
    }

    /**
     * @return resumo criptogradico
     */
    public String getResumoCriptografico() {
        return resumoCriptografico;
    }

    /**
     * Alterar o campo resumo criptografico
     *
     * @param resumoCriptografico string com o novo resumo criptofrafico
     */
    public void setResumoCriptografico(String resumoCriptografico) {
        this.resumoCriptografico = resumoCriptografico;
    }

}
