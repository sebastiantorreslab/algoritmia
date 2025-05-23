package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinarySearch {


    public static void main(String[] args) {


        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 4, 5, 6, 8, 7, 2, 3));
        System.out.println("Binary search");
        System.out.println(search2(numbers, 4)); // true
        System.out.println(search2(numbers, 40));// false
        System.out.println(search2(numbers, 1));// true
        System.out.println(search2(numbers, 2));// true

    }


    // binary search O(log n)

    public static boolean search(List<Integer> nums, Integer n) {
        if (nums.isEmpty()) {
            return false;
        }

        int mid = nums.size() / 2;
        int midValue = nums.get(mid);

        if (midValue == n) {
            return true;
        } else if (midValue < n && mid + 1 < nums.size()) {
            return search(nums.subList(mid + 1, nums.size()), n);
        }  else if (midValue > n) {
            return search(nums.subList(0, mid), n);
        }
        return false;
    }

    public static boolean search2(List<Integer> nums, Integer n){
        return binarySearch(nums,n,0,nums.size() - 1);
    }

    private static boolean binarySearch(List<Integer> nums, Integer n, int low, int high) {
        // Caso base: elemento no encontrado
        if (low >= high) {
            return false;
        }

        int mid = nums.size() / 2;
        int midValue = (int) Math.floor((double) (low + (high + low)) / 2);  // Evitar posible overflow

        // Elemento encontrado
        if (midValue == n) {
            return true;
        }
        // Buscar en la mitad derecha
        else if (midValue < n && mid + 1 < nums.size()) {
            return search(nums.subList(mid + 1, nums.size()), n);
        }  else if (midValue > n) {
            return search(nums.subList(0, mid), n);
        }
        return false;
    }




}



