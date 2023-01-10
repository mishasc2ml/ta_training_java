package framework.util;

public class StringOperations {
    public static String componentSubstring(String str, String start) {
        return str.substring(str.indexOf(start) + start.length());
    }

    public static String componentSubstring(String str, String start, String end) {
        return str.substring(str.indexOf(start) + start.length(), str.indexOf(end));
    }
}
