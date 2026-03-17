package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Level4 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(

                new Employee(1, "Alice", "Engineering", 120000, 32),
                new Employee(2, "Bob", "Engineering", 110000, 29),
                new Employee(3, "Charlie", "Engineering", 130000, 35),

                new Employee(4, "Alice", "HR", 90000, 40),
                new Employee(5, "Eva", "HR", 85000, 38),

                new Employee(6, "Charlie", "Finance", 95000, 41),
                new Employee(7, "Grace", "Finance", 105000, 36),

                new Employee(8, "Helen", "Sales", 115000, 33),
                new Employee(9, "Ian", "Sales", 99000, 30)
        );


        //1. Find duplicate employee names
        System.out.println("Duplicate employee names");

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                .forEach((empNames, value) -> {
                    if (value > 1)
                        System.out.println(empNames);
                });


        //2. Count employees in each department
        System.out.println("------------------------------------------------------------");
        System.out.println("Count employees in each department");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()))
                .forEach((dept, count) -> System.out.println(dept + " : " + count));


        //3. Find department with most employees
        System.out.println("------------------------------------------------------------");
        System.out.println("Department with most employees");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()))
               .entrySet()
               .stream()
               .max(Comparator.comparing(Map.Entry::getValue))
               .ifPresent(System.out::println);


        //4. Create map of department -> total salary
        System.out.println("------------------------------------------------------------");
        System.out.println("Map of department -> total salary");
        Map<String, Double>mapDeptSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        System.out.println(mapDeptSalary);

        //5. Find department with highest total salary
        System.out.println("------------------------------------------------------------");
        System.out.println("Department with highest total salary");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);


        //6. Find employees earning more than department average
        System.out.println("------------------------------------------------------------");
        System.out.println("Employees earning more than department average");
        //check dept's avg with each employee's salary
        Map<String,Double> deptAvgSalaryMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));
        System.out.println(deptAvgSalaryMap);



        //7. Group employee names by department
        System.out.println("------------------------------------------------------------");
        System.out.println("Group employee names by department");
        Map<String, List<String>> map = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(map);


        //8. Group employees by salary range
        System.out.println("------------------------------------------------------------");
        System.out.println("Group employees by salary range");



        //9. Find youngest employee in each department
        System.out.println("------------------------------------------------------------");
        System.out.println("youngest employee in each department");
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.minBy(Comparator.comparing(Employee::getAge))))
                        .forEach((dept, minAge) -> System.out.println(dept + " : " +
                                minAge.map(Employee::getName).orElse("N/A")));


        //10. Find top 2 departments by average salary
        System.out.println("------------------------------------------------------------");
        System.out.println("top 2 departments by average salary");
        List<Map.Entry<String,Double>> listEmp = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Double>comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .toList();
        System.out.println(listEmp);


        List<String> list = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .toList();


         List<String> words = List.of("apple", "banana", "cherry", "avocado", "blueberry", "apricot");
        // write a pipeline that groups words by their first letter, and returns a Map<Character, List<String>>.

        System.out.println("Hi There!");
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0))));


    }

}
