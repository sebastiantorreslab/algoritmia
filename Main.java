import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Integer number = sumArr(numbers);
        System.out.println(number);

        Integer max = max(numbers);
        System.out.println("this is max");
        System.out.println(max);

        Integer min = min(numbers);
        System.out.println("this is min");
        System.out.println( min);

    }

    //Complejidad O(n)

    public static Integer sumArr(ArrayList<Integer> nums){
        Integer num = 0;
        for(int i = 0; i < nums.size(); i++) {
            num += nums.get(i);

        }
        return num;
    }

    //Complejidad O(n)

    public static Integer max(ArrayList<Integer> nums) {
        Integer max = nums.getFirst();
        for(int i = 0 ; i < nums.size(); i++){
            if(nums.get(i) > max){
                max = nums.get(i);
            }
        }

        return max;
    }


    //Complejidad O(n)
    public  static Integer min(ArrayList<Integer> nums) {
        Integer min = nums.getFirst();
        for(int i = 0 ; i < nums.size(); i ++) {
            if (nums.get(i) < min) {
                min = nums.get(i);
            }
        }
        return min;
    }

    //Complejidad O(n^2)








}