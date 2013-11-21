package casosDePrueba;


import aplicacion.TestCalculadora;
import aplicacion.TestError;
import aplicacion.TestRestaCalculadora;
import tp.junit.FileStore;
import tp.junit.TestRunner;
import tp.junit.TestRunnerStore;
import tp.junit.TestSuite;

import java.io.IOException;

public class CasoGuardarTestEnFileStore {

    /*
      en este caso se ejecutan 3 tests:
      testCalculadora, testError, testRestaCalculadora,
      y se elige que se almacenen los datos de la corrida en el FileStore
     */

    public static void main(String[] args) throws IOException {
        TestRunnerStore handler = new TestRunnerStore(new TestRunner(),false);
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
