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

        ArrayList<Integer> sortSwap = (ArrayList<Integer>) sortSwap(numbers);
        System.out.println("Insertion swaped gpt");
        System.out.println(sortSwap);

        ArrayList<Integer> bubbleSort = (ArrayList<Integer>) bubbleSort(numbers);
        System.out.println("bubbleSort swaped");
        System.out.println(bubbleSort);


        ArrayList<Integer> mergeRecursion = (ArrayList<Integer>) mergeRecursion(numbers);
        System.out.println("mergeRecursion swaped");
        System.out.println(mergeRecursion);










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

    public static List<Integer> sortSwap(ArrayList<Integer> nums) {
        for(int i = 0; i < nums.size(); i++){
            int current = nums.get(i);
            for(int j = i - 1; j >= 0 && current < nums.get(j); j--){
                nums.set(j + 1, nums.get(j));
                nums.set(j, current);
            }
        }
        return nums;
    }


    public static List<Integer> bubbleSort(ArrayList<Integer> nums){
        boolean swaps = true;
        while(swaps){
            swaps = false;
            for(int i = 1; i < nums.size(); i++){
                if(nums.get(i) < nums.get(i-1)){
                    nums.set(i-1,nums.get(i) );
                    nums.set(i,nums.get(i-1) );
                    swaps = true;
                }
            }
        }
        return nums;
    }




    public static void mergeSort(ArrayList<Integer> nums1,ArrayList<Integer> nums2) {
        if(nums1.isEmpty() || nums2.isEmpty() ){
            throw new IllegalArgumentException("Not allowed empty list");
        }




    }

    public static void mergeSortUnited(ArrayList<Integer> nums1,ArrayList<Integer> nums2) {
        if(nums1.isEmpty() || nums2.isEmpty() ){
            throw new IllegalArgumentException("Not allowed empty list");
        }




    }


    public static  List<Integer> mergeRecursion(ArrayList<Integer> list){

        if(list.size() < 2){
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeRecursion((ArrayList<Integer>) left);
        right = mergeRecursion((ArrayList<Integer>) right);

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        // Agregar los elementos restantes de left (si los hay)
        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        // Agregar los elementos restantes de right (si los hay)
        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }

    public static <T> List<T> unirListas(List<T> lista1, List<T> lista2) {
        List<T> resultado = new ArrayList<>(lista1);
        resultado.addAll(lista2);
        return resultado;
    }


}


