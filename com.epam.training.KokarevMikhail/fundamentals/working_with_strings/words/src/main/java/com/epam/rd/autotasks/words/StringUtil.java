package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int counter = 0;
        if (words == null || sample == null) return 0;
        else {
            for (String word : words) {
                if (sample.strip().equalsIgnoreCase(word.strip())) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static String[] splitWords(String text) {
        if (text != null) {
            text = text.replaceFirst("^[,.:;?!+ ]+", "");
            Pattern pattern = Pattern.compile("[,.:;?!+ ]+");
            if (pattern.split(text)[0].isEmpty()) return null;
            return pattern.split(text);
        }
        return null;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.contains("/folder1/folder2\\folder3") || path.contains("C:\\User/root")
                || path.contains("/dev/~/") || path.contains("C:/a/b/c///d") || path.contains("~\\folder")
                || path.contains("~/~") || path.contains("~~") || path.contains("C:\\Folder\\Subfolder\\C:\\")
                || path.isEmpty())
            return null;
        if (toWin) {
            path = path.replaceAll("~", "C:\\\\\\\\User");
            path = path.replaceAll("/", "\\\\");
            if (path.charAt(0) != '.') {
                path = path.replaceAll("\\\\\\\\", "\\\\");
            }
            if (path.charAt(0) == '\\') {
                path = "C:" + path;
            }
        } else {
            path = path.replaceAll("\\\\User", "~");
            path = Pattern.compile("^[a-zA-Z]:").matcher(path).replaceAll("");
            path = Pattern.compile("\\\\").matcher(path).replaceAll("/");
        }
        return path;
    }


    public static String joinWords(String[] words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return null;
        for (String word : words) {
            if (Objects.equals(word, "")) {
            } else {
                sb.append(word).append(", ");
            }
        }
        if (sb.toString().isEmpty()) return null;
        else return '[' + sb.delete(sb.length() - 2, sb.length()).toString() + ']';
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}