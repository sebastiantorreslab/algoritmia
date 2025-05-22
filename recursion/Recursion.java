package recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {


    public static void main(String[] args) {



        // fibonacci

        //System.out.println("fibonacci sense");
        //System.out.println(fibonacci(6));

        //System.out.println("fibonacci recursion");
        //System.out.println(fibonacciRec(6));

        System.out.println("harmonic sum");
        System.out.println(harmonicSum(5));


        System.out.println("findMaxArray");
        ArrayList<Integer> nums = new ArrayList<>(List.of(1,2,3,4,5,6,9,8,7));
        System.out.println(findMaxArray(nums));





    }



    // recursión descendente

    public static void imprimirNum(Integer num){
        System.out.println(num);
        if(num > 1){
            imprimirNum(num - 1);
        }

    }

    // factorial

    public static Integer factorial(Integer num) {
        if (num == null || num < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo o null");
        }
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }


    //fibonacci - index position

    public static Integer fibonacci(Integer num) {

        if (num == null || num < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo o null");
        }

        if (num == 0) return 0;
        if (num == 1) return 1;

        int n1 = 0, n2 = 1, result = 0;

        for (int i = 2; i <= num; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }

    //recursion version fibonacci
    public static Integer fibonacciRec(Integer num) {
        if (num == null || num < 0) throw new IllegalArgumentException();
        if (num <  2) return num;
        return fibonacciRec(num - 1) + fibonacciRec(num - 2);
    }

    // harmonic sum - sum of reciprocals.
    public static double harmonicSum(int n) {
        if (n < 1) return 0.0;

        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    //harmonic sum recursion
    public static double harmonicSumRecursive(int n) {
        if (n < 1) return 0.0;
        if (n == 1) return 1.0;
        return 1.0 / n + harmonicSumRecursive(n - 1);
    }
    // find max recursion array
    
    
    public static Number findMaxArrayRec(ArrayList<Integer> arr){
        if (arr == null || arr.isEmpty()) {
            throw new IllegalArgumentException("El array no puede ser null o vacío");
        }

        if (arr.size() == 1) {
            return arr.getFirst();
        }

        Integer first = arr.getFirst();
        ArrayList<Integer> rest = new ArrayList<>(arr.subList(1, arr.size()));

        Integer maxOfRest = (Integer) findMaxArrayRec(rest);

        return first > maxOfRest ? first : maxOfRest;




    }

    public static Integer findMaxArrayRecIndex(List<Integer> arr, int index) {
        if (index == arr.size() - 1) return arr.get(index);
        Integer current = arr.get(index);
        Integer maxOfRest = findMaxArrayRecIndex(arr, index + 1);
        return current > maxOfRest ? current : maxOfRest;
    }


    public static Integer findMaxArray(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser null o vacía");
        }
        return findMaxArrayRecIndex(arr, 0); // Inicia la recursión con índice 0
    }


}
