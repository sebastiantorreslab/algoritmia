package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arrays {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(List.of(1,2,5,4,6,6,3,5,5,45));
        System.out.println("max");
        System.out.println(max(numbers));

        System.out.println("min");
        System.out.println(min(numbers));

        System.out.println("reversed");
        System.out.println(reverse(numbers));

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(List.of(1, 2, 3)));
        matrix.add(new ArrayList<>(List.of(4, 5, 6)));
        matrix.add(new ArrayList<>(List.of(7, 8, 9)));

        System.out.println("flatten");
        System.out.println(flatten(matrix));

        System.out.println("removeDuplicates");
        System.out.println(removeDuplicates(numbers));


    }


    public static int max(ArrayList<Integer> nums){
        int max = nums.getFirst();
        for (Integer num : nums) {
            if (num > max) {
                max = num;
            }
        }
        {
            return max;
        }

    }

    public static int min(ArrayList<Integer> nums){
        int min = nums.getFirst();
        for (Integer num : nums) {
            if (num < min) {
                min = num;
            }
        }
        {
            return min;
        }

    }

    public static List<Integer> reverse (ArrayList<Integer> nums) {
        ArrayList<Integer> reversed = new ArrayList<>();
        for(int i = nums.size() - 1; i >=0 ; i--){
            reversed.add(nums.get(i));
        }
        return reversed;
    }

    public static List<Integer> flatten (ArrayList<ArrayList<Integer>> matrix){

        ArrayList<Integer> flatten = new ArrayList<>();

        for (ArrayList<Integer> integers : matrix) {
            flatten.addAll(integers);
        }

        return flatten;

    }

    public static List<Integer> removeDuplicates(ArrayList<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> repeats = new HashSet<>();

        for (Integer num : nums) {
            if (!repeats.contains(num)) {
                repeats.add(num);
                result.add(num);
            }
        }

        return result;
    }


    }



