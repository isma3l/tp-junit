package tp.junit;


import java.io.IOException;
import java.util.ArrayList;

public class TestRunnerStore extends RunnerDecorator{
    private Runner runner;
    private Store store;
    private boolean remember;

    public TestRunnerStore(Runner runner,boolean remember) {
        super(runner.getResult());
        this.runner = runner;
        this.store = null;
        this.remember=remember;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    private void saveToStore() {
        if(store != null) {
            store.addTestToBlackList(getResult().getPasses());
        }
    }
    @Override
    public void run(TestSuite suite) throws IOException {
        if (remember) suite.filterOkTest(store.getBlackList(),getResult());
        runner.run(suite);
        saveToStore();
    }
}
