package tp.junit;

import java.util.List;

public interface Store {
   public void addTestToBlackList(String testname);
   public List<String> getBlackList();
}
