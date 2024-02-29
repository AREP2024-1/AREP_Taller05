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

    public static double calcularSeno(String numParametro){
        double numero = Double.parseDouble(numParametro);
        return Math.sin(numero);
    }

    public static double calcularCoseno(String numParametro){
        double numero = Double.parseDouble(numParametro);
        return Math.cos(numero);
    }

    public static boolean esPalindromo(String palabra){
        int longitud = palabra.length();
        for (int i = 0; i < longitud/2; i++){
            if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static double magnitudVector(String xPosicion, String yPosicion){
        double x = Double.parseDouble(xPosicion);
        double y = Double.parseDouble(yPosicion);
        return Math.sqrt(x*x + y*y);
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
    
}
