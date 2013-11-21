package casosDePrueba;


import aplicacion.TestCalculadora;
import aplicacion.TestError;
import aplicacion.TestRestaCalculadora;
import tp.junit.FileStore;
import tp.junit.TestRunner;
import tp.junit.TestRunnerStore;
import tp.junit.TestSuite;

import java.io.IOException;

public class CasoRecordarTestConFallidos {

    // se guarda en el Store.txt los test que no seran ejecutados al realzarse
    // la segunda corrida bajo el modo: correr failures/errors/ + nuevos

    public static void main(String[] args) throws IOException {
        TestRunnerStore handler = new TestRunnerStore(new TestRunner());
        TestSuite suite = new TestSuite("suite");
        TestCalculadora testCalculadora = new TestCalculadora();
        TestError testError = new TestError();
        TestRestaCalculadora testRestaCalculadora = new TestRestaCalculadora();

        suite.addTest(testError);
        suite.addTest(testRestaCalculadora);
        suite.addTest(testCalculadora);
        handler.setStore(new FileStore());
        handler.run(suite);
    }
}
