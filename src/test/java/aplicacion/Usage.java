package aplicacion;

public class Usage {
    private static final String usage="Usage:\n" +
            "\tOptions:\n" +
            "\t\t NONE" +
            "\n\t\t"+ArgumentValidator.storeopt +" run remembering previous runs\n";

    @Override
    public String toString() {
        return usage;
    }
}
