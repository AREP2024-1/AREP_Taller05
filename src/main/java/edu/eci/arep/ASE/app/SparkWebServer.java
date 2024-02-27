package edu.eci.arep.ASE.app;

import static spark.Spark.port;
import static spark.Spark.get;

public class SparkWebServer {
    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");

        get("sin", (req,res) -> {
            Double auxNumero = Double.parseDouble(req.queryParams("numero"));
            double numero = Math.sin(auxNumero);
            return numero;
        });

        get("cos", (req,res) -> {
            Double auxNumero = Double.parseDouble(req.queryParams("numero"));
            double numero = Math.cos(auxNumero);
            return numero;
        });
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
