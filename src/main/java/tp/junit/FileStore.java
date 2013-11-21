package tp.junit;

import java.io.*;
import java.util.ArrayList;

public class FileStore implements Store{
    private final String name = "FileStore.txt";

    @Override
    public void addTestToBlackList(ArrayList<TestState> blacklist) {
        FileWriter fileWriter = null;
        PrintWriter printWriter;

        try {
            fileWriter = new FileWriter(name);
            printWriter = new PrintWriter(fileWriter);

            for (TestState testState: blacklist) {
                printWriter.println(testState.getState());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileWriter)
                    fileWriter.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<TestState> getBlackList() {
        File file;
        FileReader fileReader = null;
        BufferedReader bufferedReader;
        ArrayList<TestState> list = new ArrayList<TestState>();

        try {
            file = new File (name);
            fileReader = new FileReader (file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
                list.add(new TestState(line, TestState.State.PASSED, 0));
        }
        catch(Exception exception){
            exception.printStackTrace();
        }finally{
            try{
                if( null != fileReader ){
                    fileReader.close();
                }
            }catch (Exception exception2){
                exception2.printStackTrace();
            }
        }
        return list;
    }

}
