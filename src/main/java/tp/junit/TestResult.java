/*
 * Responsabilidad: Se encarga de gestionar los resultados de los test,
 * llevando una lista para los que fallaron y
 * otra para los que pasaron satisfactoriamente.
 */
package tp.junit;

import java.util.ArrayList;

public class TestResult {

    private ArrayList<TestState> failures;
    private ArrayList<TestState> passes;
    private ArrayList<TestState> error;
    private ArrayList<TestState> skipped;
    private String suiteName = "";
    private int tCount;

    public TestResult() {
        this.passes = new ArrayList<TestState>();
        this.failures = new ArrayList<TestState>();
        this.error = new ArrayList<TestState>();
        this.skipped = new ArrayList<TestState>();
        tCount = 0;
    }

    public void addSuiteName(String name) {
        if ("".equals(this.suiteName)) {
            this.suiteName = name;
        } else {
            this.suiteName += ("." + name);
        }
    }

    public void addFail(String msg, double time) {
        this.failures.add(new TestState(suiteName + "." + msg, TestState.State.FAIL, time));
        this.tCount++;
    }

    public void addPassed(String msg, double time) {
        this.passes.add(new TestState(suiteName + "." + msg, TestState.State.PASSED, time));
        this.tCount++;
    }

    public void addError(String msg, double time) {
        this.error.add(new TestState(suiteName + "." + msg, TestState.State.ERROR, time));
        this.tCount++;
    }

    public void addSkipped(String msg, double time) {
        this.skipped.add(new TestState(suiteName + "." + msg, TestState.State.SKIPPED, time));
        this.tCount++;
    }

    public ArrayList<TestState> getFailures() {
        return this.failures;
    }

    public ArrayList<TestState> getPasses() {
        return this.passes;
    }

    public ArrayList<TestState> getError() {
        return this.error;
    }

    public ArrayList<TestState> getSkipped() {
        return this.skipped;
    }

    public int getTestCount() {
        return this.tCount;
    }

    public String getSuiteName() {
        return suiteName;
    }
}
