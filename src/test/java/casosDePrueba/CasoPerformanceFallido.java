package casosDePrueba;

import aplicacion.TestConTiempo;
import tp.junit.TestPerformance;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

import java.io.IOException;

public class CasoPerformanceFallido {

    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        TestConTiempo testWithTime = new TestConTiempo(); // el test dura 30 milisegundos
        TestPerformance testPerformanceFallido = new TestPerformance(testWithTime, 20);
        suite.addTest(testPerformanceFallido);
        handler.run(suite);
    }
}
