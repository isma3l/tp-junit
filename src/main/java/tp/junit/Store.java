package tp.junit;

import java.util.ArrayList;
import java.util.List;

public interface Store {
   public void addTestToBlackList(ArrayList<TestState> blacklist);
   public ArrayList<TestState> getBlackList();
}
