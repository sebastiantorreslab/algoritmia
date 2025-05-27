package objects;

import java.util.*;
import java.util.stream.Stream;


public class Objects {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(List.of("One", "world", "ocean", "manuchao"));


        System.out.println("\n.1 arrayToObject");
        System.out.println(arrayToObject(list));

        Map<String, String> hash = new HashMap<>(Map.of(
                "clave1", "valor1",
                "clave2", "valor2"
        ));


        System.out.println("\n.2 arrayToObject");
        System.out.println(objectToArray(hash));


        ArrayList<Integer> numerous = new ArrayList<>(List.of(10, 20, 30, 40, 40, 40, 40, 50, 50, 50, 20, 20, 10, 10, 15));
        System.out.println("\n.3 removeDuplicates");
        System.out.println(removeDuplicates(numerous));

        String text1 = "amor";
        String text2 = "roma";
        System.out.println("\n.4 isAnagram");
        System.out.println(isAnagram(text1, text2));
        System.out.println(isAnagram("aab", "abb"));
        System.out.println(isAnagram("listen", "silent"));

        assertTrue(isAnagram("listen", "silent"));
        assertTrue(isAnagram("anagram", "nagaram"));
        assertFalse(isAnagram("hello", "world"));
        assertTrue(isAnagram("", ""));
        assertTrue(isAnagram("a", "a"));
        assertFalse(isAnagram("aab", "abb"));
        assertTrue(isAnagram("Dormitory", "Dirty room"));


        System.out.println("\n.5 findFirstUniqueCharacter");
        System.out.println(findFirstNonRepeatingIndex("leetcode"));
        System.out.println(findFirstNonRepeatingIndex("loveleetcode"));
        System.out.println("Test 1 (\"hello\"): " + findFirstNonRepeatingIndex("hello"));  // 0 ('h')
        System.out.println("Test 2 (\"swiss\"): " + findFirstNonRepeatingIndex("swiss"));  // 1 ('w')
        System.out.println("Test 3 (\"aabbcc\"): " + findFirstNonRepeatingIndex("aabbcc"));  // -1
        System.out.println("Test 4 (\"java\"): " + findFirstNonRepeatingIndex("java"));  // 0 ('j')
        System.out.println("Test 5 (\"\"): " + findFirstNonRepeatingIndex(""));  // -1
        System.out.println("Test 6 (null): " + findFirstNonRepeatingIndex(null));  // -1
        System.out.println("Test 7 (\"abcabc\"): " + findFirstNonRepeatingIndex("abcabc"));  // -1
        System.out.println("Test 8 (\"stress\"): " + findFirstNonRepeatingIndex("stress"));  // 2 ('t')
        System.out.println("Test 9 (\"aabbccd\"): " + findFirstNonRepeatingIndex("aabbccd"));  // 6 ('d')
        System.out.println("Test 10 (\"aabbccddeeffg\"): " + findFirstNonRepeatingIndex("aabbccddeeffg"));  // 12 ('g')
        System.out.println("Test 11 (\"abcdabcdx\"): " + findFirstNonRepeatingIndex("abcdabcdx"));  // 8 ('x')
    }

    private static void assertTrue(Boolean anagram) {
        System.out.println("Test must be true");
        System.out.println(anagram);
    }

    private static void assertFalse(Boolean anagram) {
        System.out.println("Test must be false");
        System.out.println(anagram);
    }

    //frequencies

    //arrayToObject

    public static Map<Integer, String> arrayToObject(ArrayList<String> arr) {

        if (arr.isEmpty()) {
            throw new IllegalArgumentException("Invalid Parameters");
        }

        Map<Integer, String> hash = new HashMap<>();

        for (String str : arr) {
            hash.put(arr.indexOf(str), str);
        }
        return hash;
    }

    public static ArrayList<String> objectToArray(Map<String, String> hash) {
        return new ArrayList<>(hash.values());
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> arr) {
        Set<Integer> uniques = new LinkedHashSet<>(arr);
        return new ArrayList<>(uniques);
    }


    public static Boolean isAnagram(String input1, String input2) {

        if (input1 == null || input2 == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        String normalized1 = input1.replaceAll("\\s+", "").toLowerCase();
        String normalized2 = input2.replaceAll("\\s+", "").toLowerCase();

        if (normalized1.length() != normalized2.length()) return false;

        Map<Character, Integer> chars = new HashMap<>();

        char[] t1 = normalized1.toCharArray();
        char[] t2 = normalized2.toCharArray();

        for (char c : t1) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        for (char c : t2) {
            int count = chars.getOrDefault(c, 0) - 1;
            if (count < 0) {
                return false;
            }
            chars.put(c, count);
        }

        System.out.println(chars);
        return true;

    }

    public static Integer findFirstNonRepeatingIndex(String input) {


        if (input == null || input.isEmpty()) return -1;

        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println(freq);

        for (int i = 0; i < input.length(); i++) {
            if (freq.get(input.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;

    }
}



