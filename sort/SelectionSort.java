package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {

        System.out.println("Selection sort");
        ArrayList<Integer> numbers = new ArrayList<>(List.of(3, 1, 4, 2));

        // Versión que modifica la original
        selectionSort(numbers);
        System.out.println(numbers);

        // Versión que devuelve nueva lista
        ArrayList<Integer> sortedNumbers = selectionSort(numbers);
        System.out.println(sortedNumbers);

        ArrayList<Integer> insertedNumbers = (ArrayList<Integer>) insertionSort(numbers);
        System.out.println("Insertion sort");
        System.out.println(insertedNumbers);

        ArrayList<Integer> insertionSorted = (ArrayList<Integer>) insertionSorted(numbers);
        System.out.println("Insertion sorted gpt");
        System.out.println(insertionSorted);



    }


  /// modifica lista original
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            // Encontrar el mínimo en el resto de la lista
            int minIndex = i;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) < nums.get(minIndex)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = nums.get(i);
                nums.set(i, nums.get(minIndex));
                nums.set(minIndex, temp);
            }
        }
        return nums;
    }

    // sin modificar lista original
    public static ArrayList<Integer> selectionSortOriginal(ArrayList<Integer> nums) {
        ArrayList<Integer> sorted = new ArrayList<>(nums); // Copia

        for (int i = 0; i < sorted.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(j) < sorted.get(minIndex)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Collections.swap(sorted, i, minIndex);
            }
        }

        return sorted;
    }


    public static List<Integer> insertionSort(ArrayList<Integer> nums) {
        ArrayList<Integer> list = new ArrayList<>();
        var inserted = false;
        for(int i = 0; i < nums.size();i++){
            inserted = false;
            for(int  j = 0; j < list.size() && !inserted; j++){
                if(nums.get(i) < list.get(j)){
                    list.set(j,nums.get(i));
                    inserted = true;
                }

            }
            if(!inserted) list.add(nums.get(i));
        }
        return list;
    }


    public static List<Integer> insertionSorted(ArrayList<Integer> nums) {
        ArrayList<Integer> sorted = new ArrayList<>();

        for (Integer num : nums) {
            int i = 0;
            while (i < sorted.size() && num > sorted.get(i)) {
                i++;
            }
            sorted.add(i, num); // Insertar en posición correcta
        }

        return sorted;
    }








}
