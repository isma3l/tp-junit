package tp.junit;

import java.io.IOException;

public abstract class RunnerDecorator extends Runner{
    protected RunnerDecorator(TestResult result) {
        super(result);
    }

    public abstract void run(TestSuite suite) throws IOException;
}
