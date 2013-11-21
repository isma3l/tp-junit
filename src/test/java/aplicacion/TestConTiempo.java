package aplicacion;

import tp.junit.TestCase;

public class TestConTiempo extends TestCase {

    @Override
    public void runTest() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
