/*
 * Interfaz del composite - componente.
 */
package tp.junit;

import java.util.ArrayList;

public abstract class Test {
    SetUp setUp = null;
 //   Store store = null;

    public void setAttribute(SetUp setup) {
        setUp = setup;
    }

    public SetUp getSetUp() {
        return setUp;
    }

   /* public void setStore(Store store) {
        this.store = store;
    }*/

    public abstract void run(TestResult result);

    public abstract String classType();

    public abstract String getName();

    public abstract void regularExp(String regex);

    public abstract void haveTag(String tag);

    public abstract void filterOkTest(ArrayList<String> blackList,TestResult result);
}
