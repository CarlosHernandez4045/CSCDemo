package W6HW;

public class isValid{
    public static boolean isValid (String method) {

        if (method == null) return false;
        if (method.matches("SUM")) return true;
        if (method.matches("AVERAGE")) return true;
        if (method.matches("COUNT")) return true;
        return false;
    }

    //some basic text color strings to use for terminal output in main  
    public static final String RESET = "\033[0m";  
    public static final String RED = "\033[0;31m";
    public static final String PURPLE = "\033[0;35m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
}

