package aplicacion;
import com.sun.javaws.exceptions.InvalidArgumentException;
import tp.junit.Runner;
import tp.junit.TestRunner;

import java.util.Arrays;
import java.util.List;

public class ArgumentValidator {
    private Runner runner;
    private List<String> args;
    public static final String storeopt="-Store";
    public ArgumentValidator(TestRunner runner, String[] args) {
        this.runner = runner;
        this.args = Arrays.asList(args);
    }
    private  boolean badOption(){
        return (!args.contains(storeopt));
    }
    public void start() throws InvalidArgumentException{
        if (args.size()>0){
            if (badOption() || badArgAmount()){
                throw new InvalidArgumentException(new String[]{"Bad options"});
            }
            runner.setStore(true);
        }
    }

    private boolean badArgAmount() {
        return (args.size()>1);
    }
}
