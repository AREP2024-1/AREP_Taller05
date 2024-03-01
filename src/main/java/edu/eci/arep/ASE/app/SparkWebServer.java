package edu.eci.arep.ASE.app;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;
import static spark.Spark.get;

public class SparkWebServer {
    public static void main(String... args){
        port(getPort());
        staticFileLocation("/public");

        get("/hello", (req,res) -> "Hello Docker!");

        get("/sin", (req,res) -> {
            String numero = req.queryParams("numero");
            return "sen("+ numero +")= "+ calcularSeno(numero);
        });

        get("/cos", (req,res) -> {
            String numero = req.queryParams("numero");
            return "cos("+ numero +")= "+ calcularCoseno(numero);
        });

        get("/palindromo", (req,res) -> {
            String cadena = req.queryParams("cadena");
            if(esPalindromo(cadena)){
                return "Es un palíndromo";

            }else{
                return " No es un palíndromo";
            }
        });

        get("/magnitud", (req,res) -> {
            String x = req.queryParams("x");
            String y = req.queryParams("y");
            return "|A|= " + magnitudVector(x, y);
        });
    }

    /*
     * Método que calcula el seno de un número
     * @param numParametro número al que se le calculará el seno
     */
    public static double calcularSeno(String numParametro){
        double numero = Double.parseDouble(numParametro);
        return Math.sin(numero);
    }

    /*
     * Método que calcula el coseno de un número
     * @param numParametro número al que se le calculará el coseno
     */
    public static double calcularCoseno(String numParametro){
        double numero = Double.parseDouble(numParametro);
        return Math.cos(numero);
    }

    /*
     * Método que verifica si una cadena es un palíndromo
     * @param palabra cadena que se verificará si es palíndromo
     */
    public static boolean esPalindromo(String palabra){
        int longitud = palabra.length();
        for (int i = 0; i < longitud/2; i++){
            if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)){
                return false;
            }
        }
        return true;
    }

    /*
     * Método que calcula la magnitud de un vector
     * @param xPosicion posición en x del vector
     * @param yPosicion posición en y del vector
     */
    public static double magnitudVector(String xPosicion, String yPosicion){
        double x = Double.parseDouble(xPosicion);
        double y = Double.parseDouble(yPosicion);
        return Math.sqrt(x*x + y*y);
    }

    /*
     * Método que obtiene el puerto en el que se ejecutará la aplicación
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
    
}
