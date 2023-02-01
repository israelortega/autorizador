
package mx.unam.sa.autorizador.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.NoIvGenerator;

/**
 *
 * @author Ingrid
 */
public class Encrypt {

    static Exception error;
    static String mensaje = "";

    String cadena;
    String pass;
    String cadenaEncrypt;

    public Encrypt(String cadena, String pass, String cadenaEncrypt) {
        this.cadena = cadena;
        this.pass = pass;
        this.cadenaEncrypt = cadenaEncrypt;
    }

    public void encryptString() throws Exception {
        try {
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword(pass);
            encryptor.setAlgorithm("PBEWithMD5AndDES");
            encryptor.setIvGenerator(new NoIvGenerator());
            cadenaEncrypt = encryptor.encrypt(cadena);
        } catch (Exception e) {
            error = e;
            mensaje = " Error al ejecutar encrypt: " + e.getMessage();
            throw new Exception(mensaje);
        }

    }

    public void decryptString() throws Exception {
        try {
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword(pass);
            encryptor.setAlgorithm("PBEWithMD5AndDES");
            encryptor.setIvGenerator(new NoIvGenerator());
            cadena = encryptor.decrypt(cadenaEncrypt);
        } catch (Exception e) {
            error = e;
            mensaje = " Error al ejecutar decrypt: " + e.getMessage();
            throw new Exception(mensaje);
        }

    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCadenaEncrypt() {
        return cadenaEncrypt;
    }

    public void setCadenaEncrypt(String cadenaEncrypt) {
        this.cadenaEncrypt = cadenaEncrypt;
    }

    public static Exception getError() {
        return error;
    }

    public static void setError(Exception error) {
        Encrypt.error = error;
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        Encrypt.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Encrypt{" + "cadena=" + cadena + ", pass=" + pass + ", cadenaEncrypt=" + cadenaEncrypt + '}';
    }
}
