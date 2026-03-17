package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Level3 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(

                new Employee(1, "Alice", "Engineering", 120000, 32),
                new Employee(2, "Bob", "Engineering", 110000, 29),
                new Employee(3, "Charlie", "Engineering", 130000, 35),

                new Employee(4, "David", "HR", 90000, 40),
                new Employee(5, "Eva", "HR", 85000, 38),

                new Employee(6, "Frank", "Finance", 95000, 41),
                new Employee(7, "Grace", "Finance", 105000, 36),

                new Employee(8, "Helen", "Sales", 115000, 33),
                new Employee(9, "Ian", "Sales", 99000, 30)
        );


        //Find all employees from Engineering department
        List<Employee> enggEmp = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering"))
                .toList();
        System.out.println("Engineering Employees: " + enggEmp);
        System.out.println("---------------------------------------------------");

        //Find employee with highest salary
       /* employees.stream()
                .max(Employee::getSalary)
                .ifPresent(System.out::println);*/

        // Find average salary
        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average salary : " + avg);

        System.out.println("---------------------------------------------------");

        //Group employees by department
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((dept, emp) -> System.out.println(dept + " -> " + emp));

        System.out.println("---------------------------------------------------");

        //Find highest paid employee in each department
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((dept, highestSal) -> System.out.println(dept + " : " + highestSal.get()));

        System.out.println("---------------------------------------------------");

        //Get list of employee names only
        employees.stream()
                .map(employee -> employee.getName())
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        //Sort employees by salary descending
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");


        // Find second highest salary employee
        Optional<Employee> emp = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        System.out.println("Second highest earning employee: " + emp.get());

        //Find department with highest average salary

       /* employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)),
                        Collectors.maxBy(Comparator.comparingDouble()))
                .forEach((dept, sal) -> System.out.println(dept + "---> " + sal));
*/

        System.out.println("---------------------------------------------------");
        System.out.println("Find top 3 highest paid employees -->");
        employees
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        System.out.println("Convert employee list into map ---> employeeId → employeeName");

        employees
                .stream()
                .map(e -> e.getId())
                .forEach(System.out::println);

        // dont know these following question and what concepts they are using-->
        //Find employees earning more than department average
        //Find duplicate names
        //Group employees by salary range
        //Create map of department → total salary
    }
}
