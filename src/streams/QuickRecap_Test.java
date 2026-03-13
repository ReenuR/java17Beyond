package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class QuickRecap_Test {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3,7,2,9,4,6,1);

        //Print all even numbers.
        List<Integer> evenNums = nums.stream()
                .filter(n->n%2==0)
                .toList();
        System.out.println("Even Numbers: " + evenNums);

        //Find square of each number.
        List<Integer> square = nums.stream()
                .map(n->n*n)
                .toList();
        System.out.println("Square of nums: " + square);

        //Find numbers greater than 5.
        List<Integer> numGrterThanFive  =  nums.stream()
                .filter(n->n>5)
                .toList();
        System.out.println("Num > 5 : " + numGrterThanFive);

        //Find maximum number.
        Optional<Integer> optional = nums
                        .stream()
                        .max(Integer::compareTo);
       System.out.println("Max number : " + optional.get());


        List<Integer> numList = List.of(1,2,2,3,4,4,5);
        //Remove duplicates from a list.
        List<Integer> distinctNums = numList.stream().distinct().toList();
        System.out.println("Unique values : " + distinctNums);

        //Sort numbers in descending order.
        List<Integer> sortedNum = numList.stream().sorted().toList();
        System.out.println("Sorted in Desc : " + sortedNum);

        //Count how many numbers are greater than 4.
        Long count = numList.stream().filter(n-> n>4).count();
        System.out.println("Num > 4 : " + count);

    }
}
