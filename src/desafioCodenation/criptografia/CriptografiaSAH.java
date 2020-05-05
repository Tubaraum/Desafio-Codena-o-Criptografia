/*
 * Classe para criptografar mensagens/textos
 */
package desafioCodenation.criptografia;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Student information systems Brazil, MG
 *
 * @author Eduardo Almeida <edualmeida.a7@gmail.com>
 * @version 1.0
 * @since May 02, 2020
 */
public class CriptografiaSAH {

    /**
     * Meétodo para criptografar uma mensagem qualquer
     *
     * @param criptografia     método de desafioCodenation.criptografia (ex: MD5 SHA-256, SHA-1...)
     * @param codificacaoTexto tipo de codificação (ex: UTF-8, ASCII...)
     * @param texto            mensagem a ser encriptada
     * @return string resultante do processo ou com falha
     */
    public static String criptografar(String criptografia, String codificacaoTexto, String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance(criptografia);
            byte[] messageDigest = md.digest(texto.getBytes(codificacaoTexto));

            //Transformando em hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            ex.getStackTrace();
        }
        return "Falha";
    }
}
