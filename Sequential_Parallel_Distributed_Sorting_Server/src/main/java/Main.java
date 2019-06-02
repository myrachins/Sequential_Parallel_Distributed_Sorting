import utils.AppSettings;

public class Main {
    public static void main(String[] args) {
        try {
            parseArguments(args);
        } catch (Exception exc) {
            System.out.println("Invalid input parameters. Message: " + exc.getMessage());
        }
    }

    private static void parseArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Number of parameters should be 2");
        }
        try {
            AppSettings.setN(Integer.parseInt(args[0]));
            AppSettings.setM(Integer.parseInt(args[1]));
        } catch (NumberFormatException exc) {
            throw new IllegalArgumentException("Can't parse param: " + exc.getMessage());
        }
    }
}
