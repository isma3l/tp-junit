package tp.junit;

import java.io.IOException;

public abstract class Runner {
    protected TestResult result;
    private boolean remember;

    protected Runner(TestResult result,boolean remember) {
      this.result = result;
      this.remember = remember;
    }

    public boolean isRemember() {
        return remember;
    }

    public TestResult getResult() {
        return result;
    }

    public abstract void run(TestSuite suite) throws IOException;
}
