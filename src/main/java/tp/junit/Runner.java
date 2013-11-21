package tp.junit;

import java.io.IOException;

public abstract class Runner {
    protected TestResult result;
    private boolean store;

    protected Runner(TestResult result) {
      this.result = result;
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
