package tp.junit;

public class TestPerformance extends TestDecorator{
    TestCase testCase;
    double timelimit;
    long starttime;
    long endtime;

    public TestPerformance(TestCase testCase, double timelimit) {
        this.testCase = testCase;
        this.timelimit = timelimit;
        this.starttime = 0;
        this.endtime = 0;
    }

    public void verifiedTimeLimit() {
        double elapsedTime = (endtime-starttime)/1000000;
        if (elapsedTime > timelimit) throw new AssertException();
    }

    @Override
    public void run(TestResult result) {
        testCase.setAttribute(setUp);
        if (testCase.isRunner()) {
            try {
                runTest();
                verifiedTimeLimit();
                result.addPassed(testCase.getName(), calcularTiempo(starttime, endtime));
            } catch (AssertException e) {
                endtime = System.nanoTime();
                result.addFail(testCase.getName(), calcularTiempo(starttime, endtime));
            } catch (Throwable e) {
                endtime = System.nanoTime();
                result.addError(testCase.getName(), calcularTiempo(starttime, endtime));
            }
        } else {
            result.addSkipped(testCase.getName(), 0);
        }
    }

    @Override
    public void runTest() {
        starttime = System.nanoTime();
        testCase.runTest();
        endtime = System.nanoTime();
    }

    private double calcularTiempo(double tiempoInicial, double tiempoFinal) {
        return (tiempoFinal - tiempoInicial) / 1000000;
    }
}
