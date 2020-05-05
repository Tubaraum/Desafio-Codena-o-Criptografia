/*
 * Esta classe tem o objetivo encriptar e descriptar textos de acordo
 * a CriptografiaSAH de Júlio César que consiste em pular casas do alfabeto
 * de acordo a quantidade indicada.
 */

package desafioCodenation.criptografia;

/**
 * Student information systems Brazil, MG
 *
 * @author Eduardo Almeida <edualmeida.a7@gmail.com>
 * @version 1.0
 * @since May 02, 2020
 */
public class CriptografiaCesar {

    private static String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Altera o alfabeto atual para o alfabeto desejado
     *
     * @param alfabeto string com o alfabeto a ser usado
     */
    public static void setALFABETO(String alfabeto) {
        ALFABETO = alfabeto;
    }

    /**
     * Método para retorno do alfabeto atual.
     *
     * @return alfabeto atual
     */
    public static String getALFABETO() {
        return ALFABETO;
    }

    /**
     * Método para encriptar um texto ou descriptar um texto qualquuer.Operações em cima do alfabeto PT-BR.
     *
     * @param estado   Informe True, se a mensagem estiver encriptada
     *                 Informe False, se a mensagem estiver descriptada
     * @param string   O texto a ser encriptado ou descriptado
     * @param numCasas Número de casas para encritar ou descriptar
     * @return String
     */
    public static String criptografiaCesar(boolean estado, String string, int numCasas) {

        int numero = numCasas;
        //Se for true significa que é para descriptografar, então fazemos o inverso
        if (estado) {
            numero *= -1;
        }
        // deslocar número de casas
        StringBuilder resultado = new StringBuilder();
        for (char ch : string.toLowerCase().toCharArray()) {
            //Se na string conter caracteres que não são letras, mantem-se.
            if (!ALFABETO.contains(String.valueOf(ch))) {
                resultado.append(ch);
                continue;
            }
            int chr = ch - ALFABETO.charAt(0);
            chr = (chr + numero) % ALFABETO.length();
            if (chr < 0) {
                chr += ALFABETO.length();
            }
            chr += ALFABETO.charAt(0);
            resultado.append((char) chr);
        }
        return resultado.toString();
    }

}
