package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Level2 {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1,2,3,4,4,5,2,11,12,6,7,8,9);
        //Find first element greater than 5.
        Optional<Integer> num = nums.stream().filter(n -> n > 5).findFirst();
        System.out.println("First num > 5: " + num.get());

        // next biggest element than 5
        nums
              .stream()
              .filter(n -> n > 5)
              .sorted()
              .limit(1)
                .forEach(System.out::println);

        //Convert list of integers to comma separated string --> "3,7,2,9,4"
        List<Integer> list  = List.of(3,7,2,9,4);

        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("List of comma Separated nums : " + result);


        //------------*** ------------//

        //Find second highest number.
        System.out.print("Second Highest number : ");
        Optional<Integer> secondLargest = nums.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        secondLargest.ifPresent(System.out::println);

        //Partition numbers into even and odd


        //Group numbers by even / odd



        //Find frequency of each element --> [1,2,2,3,3,3]




    }
}
