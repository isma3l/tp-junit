package tp.junit;

import java.io.IOException;

public abstract class RunnerDecorator extends Runner{
    public abstract void run(TestSuite suite) throws IOException;
}
