package casosDePrueba;

import aplicacion.TestCalculadora;
import aplicacion.TestError;
import aplicacion.TestRestaCalculadora;
import tp.junit.*;

import java.io.IOException;

public class CasoRecordarTetConFallidosStoreXml {
    public static void main(String[] args) throws IOException {
        TestRunnerStore handler = new TestRunnerStore(new TestRunner(),true);
        TestSuite suite = new TestSuite("suite");
        TestCalculadora testCalculadora = new TestCalculadora();
        TestError testError = new TestError();
        TestRestaCalculadora testRestaCalculadora = new TestRestaCalculadora();

        suite.addTest(testError);
        suite.addTest(testRestaCalculadora);
        suite.addTest(testCalculadora);
        handler.setStore(new XmlStore());
        handler.run(suite);
    }
}
