package casosDePrueba;

import aplicacion.TestConTiempo;
import tp.junit.TestPerformance;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

import java.io.IOException;

public class CasoPerformanceExitoso {

    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        TestConTiempo testWithTime = new TestConTiempo(); // el test dura 30 milisegundos
        TestPerformance testPerformanceExitoso = new TestPerformance(testWithTime, 40);
        suite.addTest(testPerformanceExitoso);
        handler.run(suite);
    }
}