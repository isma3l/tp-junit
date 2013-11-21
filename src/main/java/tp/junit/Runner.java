package tp.junit;

import java.io.IOException;

public abstract class Runner {
    private TestResult result;

    public TestResult getResult() {
        return result;
    }

    public abstract void run(TestSuite suite) throws IOException;
}
