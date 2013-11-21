package casosDePrueba;

import aplicacion.TestCalculadora;
import aplicacion.TestRestaCalculadoraCorrecta;
import tp.junit.*;

import java.io.IOException;

public class CasoRecordarYGuardarTestConXmlStore {
    /*
      en este caso se ejecutan 2 tests:
      testCalculadora,  testRestaCalculadoraCorrecta
      y se elige que se almacenen los datos de la corrida en el XmlStore
     */

    public static void main(String[] args) throws IOException {
        TestRunnerStore handler = new TestRunnerStore(new TestRunner(),true);
        TestSuite suite = new TestSuite("suite");
        TestCalculadora testCalculadora = new TestCalculadora();
        TestRestaCalculadoraCorrecta testRestaCalculadoraCorrecta = new TestRestaCalculadoraCorrecta();

        suite.addTest(testCalculadora);
        suite.addTest(testRestaCalculadoraCorrecta);

        handler.setStore(new XmlStore());
        handler.run(suite);
    }
}
