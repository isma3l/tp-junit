package tp.junit;

import java.io.*;
import java.util.ArrayList;

public class FileStore implements Store{
    private final String name = "Store.txt";

    @Override
    public void addTestToBlackList(ArrayList<TestState> blacklist) {
        FileWriter fileWriter = null;
        PrintWriter printWriter;

        try {
            fileWriter = new FileWriter(name);
            printWriter = new PrintWriter(fileWriter);

            for (TestState testState: blacklist) {
                printWriter.println(testState.getTestCaseName());
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
    public ArrayList<String> getBlackList() {
        File file;
        FileReader fileReader = null;
        BufferedReader bufferedReader;
        ArrayList<String> list = new ArrayList<String>();

        try {
            file = new File (name);
            fileReader = new FileReader (file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
                list.add(line);
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
