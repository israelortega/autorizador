package mx.unam.sa.autorizador.utils;

/**
 * Aplicacion para crear cadenas cifradas con biblioteca JASYPT y un password
 *
 * @author Ingrid
 */
public class EncryptMain {

    static Exception error;

    public static void main(String[] args) throws Exception {
        try {
            //String para cifrar no se mueve
            //Este procemiento ponerse en un proyecto independiente al servidor
            //En el equipo de desarrollo o producción debe vivir como una variable independiente
            String pass = "DF1G1A3DG7DE5GEA";
            
            //Esta se sustituye
            String cadena = "jdbc:mysql://localhost:3316/dbautoriza?noAccessToProcedureBodies=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Mexico_City";
            
            //System.out.println("Pass: " + pass);
            System.out.println("Cadena: " + cadena);
            
            //Se pasan al constructor los parametros a utilizar
            Encrypt e = new Encrypt(cadena, pass, null);
            //Llamada para Cifrar
            e.encryptString();
            System.out.println("Encrypt: " + e.getCadenaEncrypt());

            //Llamada para decifrar
            e.decryptString();
            System.out.println("Decrypt: " + cadena);

        } catch (Exception e) {
            error = e;
            throw new Exception("Error: " + e.getMessage());
        }

    }

    public static Exception getError() {
        return error;
    }

}
