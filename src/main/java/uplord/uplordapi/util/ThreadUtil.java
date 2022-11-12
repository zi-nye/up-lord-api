package uplord.uplordapi.util;

public class ThreadUtil {

    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}