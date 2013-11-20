package tp.junit;

public class TestPerformance extends TestDecorator{
    TestCase testCase;
    long timelimit;
    long starttime;
    long endtime;
    public TestPerformance(TestCase testCase, long timelimit) {
        this.testCase = testCase;
        this.timelimit = timelimit;
        this.starttime=0;
        this.endtime=0;
    }

    @Override
    public void runTest() {
        endtime= System.nanoTime();
        long elapsedTime=(endtime-starttime)/ 1000000;
        if (elapsedTime>timelimit) throw new AssertException();
    }

    @Override
    public void run(TestResult result) {
        starttime = System.nanoTime();
        testCase.run(result);
        runTest();
    }
}
