package strings;

import java.util.*;


public class Strings
{

    public static void main(String[] args) {

        String text = "THIS IS UPPER CASE EXCEPT ONe";

        System.out.println(findRepeatedCharacters(text));


        System.out.println("NumLowerCase");
        System.out.println(numLowerCase(text));


        System.out.println("ToLowerCase");
        System.out.println(toLowerCase(text));


        System.out.println("ToUpperCase");
        System.out.println(toUpperCase(text));


        System.out.println("Palindrome");

        String word = "oso";
        System.out.println(palindromeChecker(word)); // true
        System.out.println(palindromeChecker("Anita lava la tina")); // true
        System.out.println(palindromeChecker("reconocer"));         // true
        System.out.println(palindromeChecker("Java"));              // false
        System.out.println(palindromeChecker(""));                  // true
        System.out.println(palindromeChecker("  "));



        System.out.println("PalindromeOptimized");

        System.out.println(palindromeCheckerOptimized(word)); // true
        System.out.println(palindromeCheckerOptimized("Anita lava la tina")); // true
        System.out.println(palindromeCheckerOptimized("reconocer"));         // true
        System.out.println(palindromeCheckerOptimized("Java"));              // false
        System.out.println(palindromeCheckerOptimized(""));                  // true
        System.out.println(palindromeCheckerOptimized("  "));


        System.out.println("1. Anagramas básicos:");
        System.out.println("   'roma' y 'amor': " + AnagramCheck("roma", "amor")); // true
        System.out.println("   'listen' y 'silent': " + AnagramCheck("listen", "silent")); // true

        // Casos con mayúsculas y espacios
        System.out.println("\n2. Anagramas con formato diferente:");
        System.out.println("   'Roma' y 'AMOR': " + AnagramCheck("Roma", "AMOR")); // true
        System.out.println("   'School master' y 'The classroom': " +
                AnagramCheck("School master", "The classroom")); // true

        // Casos que NO son anagramas
        System.out.println("\n3. No anagramas:");
        System.out.println("   'hola' y 'holo': " + AnagramCheck("hola", "holo")); // false
        System.out.println("   'java' y 'javascript': " + AnagramCheck("java", "javascript")); // false

        // Casos especiales
        System.out.println("\n4. Casos especiales:");
        System.out.println("   Cadena vacía: " + AnagramCheck("", "")); // true
        System.out.println("   Un solo carácter: " + AnagramCheck("a", "a")); // true
        System.out.println("   Con símbolos: 'a!b' y 'ba': " + AnagramCheck("a!b", "ba")); // true (depende de implementación)

        System.out.println("\n5. Contador de letras:");
        String test = "hello world";
        Map<Character, Integer> result = letterCounter(test);
        System.out.println(result);

        System.out.println("\n4. Frequencies");
        System.out.println(frequencies(test));



        System.out.println("\n4. ShortenString");
        System.out.println(shortString("aaaabbbbcccc"));


    }
    public static Set<Character> findRepeatedCharacters(String text) {
        Set<Character> seen = new HashSet<>();
        Set<Character> repeats = new HashSet<>();

        if (text == null) return repeats;

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (!seen.add(letter)) { // add() devuelve false si el elemento ya existía
                repeats.add(letter);
            }
        }

        return repeats;
    }


    public static Integer numLowerCase(String input) {
        int count = 0;

        for(int i = 0; i < input.length(); i ++){
            if(Character.isLowerCase(input.charAt(i))){
                count++;
            }
        }

        return count;
    }


    public static String toLowerCase(String input){
        return input.toLowerCase();
    }

    public static String toUpperCase(String input){
        return input.toUpperCase();
    }


    public static Boolean palindromeChecker(String input1){

        if( input1 == null){
            throw new IllegalArgumentException("Invalid parameters");
        }

        List<Character> chars = new ArrayList<>();
        char[] sequence = input1.toLowerCase().replaceAll("\\s+", "").toCharArray();

        for(Character ch: sequence){
            chars.add(ch);
        }

        return chars.equals(chars.reversed());
    }

    //compatible con otras versiones

    public static boolean palindromeCheckerOptimized(String input) {
        if(input == null) throw new IllegalArgumentException("Invalid parameters");
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        int left = 0, right = normalized.length() - 1;
        while(left < right) {
            if(normalized.charAt(left++) != normalized.charAt(right--))
                return false;
        }
        return true;
    }


    public static boolean AnagramCheck(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] arrA = a.toLowerCase().toCharArray();
        char[] arrB = b.toLowerCase().toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        return Arrays.equals(arrA, arrB);
    }


    public static Map<Character, Integer> letterCounter(String input) {

        Map<Character, Integer> letterMap = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return letterMap;
        }

        char[] chars = input.replaceAll("\\s+", "").toCharArray();

        for (char c : chars) {
            letterMap.put(c, letterMap.getOrDefault(c, 0) + 1);
        }

        return letterMap;
    }


    public static Map<Character, Integer> frequencies(String input){

        if(input == null){
            throw new IllegalArgumentException("Invalid params");
        }

        Map<Character, Integer> hash = new HashMap<>();

        for(Character c: input.replaceAll("\\s+","").toCharArray()){
            hash.put(c,hash.getOrDefault(c,0)+1);
        }

        return hash;

    }

    public static  String shortString(String input){

        Set<String> shorten = new LinkedHashSet<>();

        for(Character c : input.toCharArray()){
            shorten.add(String.valueOf(c));
        }

        return shorten.toString();


}














}
