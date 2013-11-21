package casosDePrueba;

import aplicacion.TestCalculadora;
import aplicacion.TestError;
import aplicacion.TestRestaCalculadora;
import aplicacion.TestRestaCalculadoraCorrecta;
import tp.junit.FileStore;
import tp.junit.TestRunner;
import tp.junit.TestRunnerStore;
import tp.junit.TestSuite;

import java.io.IOException;

public class CasoRecordarTestFallidosDeFileStore {

 /*
     En este caso se usa la corrida almacenada por el caso CasoGuardarTestEnFileStore,
     en dicha corrida se ejecutaron 3 testcase:   testCalculadora, testError, testRestaCalculadora,
     de los cuales el testCalculadora fue el unico exitoso,

     Para esta prueba se realiza el mismo test pero en el modo que permita correr solo
     los test failures/errors o nuevos, por lo tanto NO se ejecutara el testCalculadora,
     pero si dos los restantes mas el nuevo test TestRestaCalculadoraCorrecta,
     corriendo solo 3 test de los 4 test que se agregan.
 */

    public static void main(String[] args) throws IOException {
        TestRunnerStore handler = new TestRunnerStore(new TestRunner(),true);

        TestSuite suite = new TestSuite("suite");
        // se elige que se recuerde la corrida que se guardo con FileStore
        handler.setStore(new FileStore());

        TestCalculadora testCalculadora = new TestCalculadora();
        TestError testError = new TestError();
        TestRestaCalculadora testRestaCalculadora = new TestRestaCalculadora();
        TestRestaCalculadoraCorrecta testRestaCalculadoraCorrecta = new TestRestaCalculadoraCorrecta();

        suite.addTest(testError);
        suite.addTest(testRestaCalculadora);
        suite.addTest(testCalculadora);
        suite.addTest(testRestaCalculadoraCorrecta);

        handler.run(suite);
    }
}
