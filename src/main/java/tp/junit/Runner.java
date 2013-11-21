package tp.junit;

import java.io.IOException;

public abstract class Runner {
    private TestResult result;
    private boolean store;

    protected Runner() {
        this.result = new TestResult();
        this.store = false;
    }

    public void setStore(boolean store) {
        this.store = store;
    }

    public TestResult getResult() {
        return result;
    }

    public abstract void run(TestSuite suite) throws IOException;
}
