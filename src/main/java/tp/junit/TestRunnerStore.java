package tp.junit;


import java.io.IOException;

public class TestRunnerStore extends RunnerDecorator{
    private Runner runner;
    private Store store;
    public TestRunnerStore(Runner runner) {
        this.runner = runner;
        this.store=null;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    private void saveToStore() {
        if(store!= null) {
            store.addTestToBlackList(getResult().getPasses());
        }
    }
    @Override
    public void run(TestSuite suite) throws IOException {
        runner.run(suite);
        saveToStore();
    }
}
