package casosDePrueba;

import aplicacion.TestSetUp;
import aplicacion.testMultiplicacionCalculadora;
import tp.junit.TestPerformance;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

import java.io.IOException;

public class casoPerformance {
    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        testMultiplicacionCalculadora testConSetUp = new testMultiplicacionCalculadora();
        TestPerformance testPerformance= new TestPerformance(testConSetUp, (long) 1);
        TestSetUp setup = new TestSetUp();
        suite.addSetUp(setup);
        suite.addTest(testPerformance);
        handler.run(suite);
    }
}