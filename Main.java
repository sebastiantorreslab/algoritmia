import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Integer number = sumArr(numbers);
        System.out.println(number);
    }

    public static Integer sumArr(ArrayList<Integer> nums){
        Integer num = 0;
        for(int i = 0; i < nums.size(); i++) {
            num += nums.get(i);

        }
        return num;
    }
}