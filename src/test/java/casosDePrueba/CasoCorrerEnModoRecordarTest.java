package casosDePrueba;

import aplicacion.TestCalculadora;
import aplicacion.TestError;
import aplicacion.TestRestaCalculadora;
import aplicacion.TestRestaCalculadoraCorrecta;
import tp.junit.FileStore;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

import java.io.IOException;

public class CasoCorrerEnModoRecordarTest {

 /*
     En el caso CasoGuardarTestEnFileStore se ejecutaron 3 testcase:
     testCalculadora, testError, testRestaCalculadora,
     de los cuales el testCalculadora fue el unico exitoso,
     el resultado de la corrida se guardo en el store.

     Para esta prueba se realiza el mismo test pero en el modo que permita correr solo
     los test failures/errors o nuevos, por lo tanto no se ejecutara el testCalculadora.
     El test nuevo es TestRestaCalculadoraCorrecta
 */

    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();

        TestSuite suite = new TestSuite("suite");
        TestCalculadora testCalculadora = new TestCalculadora();
        TestError testError = new TestError();
        TestRestaCalculadora testRestaCalculadora = new TestRestaCalculadora();
        TestRestaCalculadoraCorrecta testRestaCalculadoraCorrecta = new TestRestaCalculadoraCorrecta();

        suite.addTest(testError);
        suite.addTest(testRestaCalculadora);
        suite.addTest(testCalculadora);
        suite.addTest(testRestaCalculadoraCorrecta);

        handler.runWithStore(suite, new FileStore());
    }
}
