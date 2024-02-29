package edu.eci.arep.ASE.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SparkWebServerTest {
    private SparkWebServer sparkWebServer = new SparkWebServer();

    @Test
    public void deberiaCalcularSeno(){
        assertEquals(0.0, sparkWebServer.calcularSeno("0"), 0.0001);
        assertEquals(0.988031624093, sparkWebServer.calcularSeno("-30"), 0.0001);
        assertEquals(-0.00000734641, sparkWebServer.calcularSeno("3.1416"), 0.0001);
        assertEquals(-0.9589242746631385, sparkWebServer.calcularSeno("5"), 0.0001);
    }

    @Test
    public void deberiaCalcularCoseno(){
        assertEquals(1.0, sparkWebServer.calcularCoseno("0"), 0.0001);
        assertEquals(0.154251449888, sparkWebServer.calcularCoseno("-30"), 0.0001);
        assertEquals(-0.999999999973, sparkWebServer.calcularCoseno("3.1416"), 0.0001);
        assertEquals(0.283662185463, sparkWebServer.calcularCoseno("5"), 0.0001);
    }

    @Test
    public void deberiaSerPalindromo(){
        assertEquals(true, sparkWebServer.esPalindromo("reconocer"));
        assertTrue(sparkWebServer.esPalindromo("osobaboso"));
        assertTrue(sparkWebServer.esPalindromo("anitalavalatina"));
        
        assertEquals(false, sparkWebServer.esPalindromo("hola"));
        assertFalse(sparkWebServer.esPalindromo("mundo"));
        assertFalse(sparkWebServer.esPalindromo("sammuel"));
    }

    @Test
    public void deberiaCalcularMagnitudVector(){
        assertEquals(5.0, sparkWebServer.magnitudVector("3", "4"), 0.0001);
        assertEquals(13.0, sparkWebServer.magnitudVector("5", "12"), 0.0001);
        assertEquals(17.0, sparkWebServer.magnitudVector("8", "15"), 0.0001);
        assertEquals(45.5411901469428003, sparkWebServer.magnitudVector("7", "45"), 0.0001);
        assertEquals(71.5891053163817658, sparkWebServer.magnitudVector("65", "-30"), 0.0001);

    }
    
}
