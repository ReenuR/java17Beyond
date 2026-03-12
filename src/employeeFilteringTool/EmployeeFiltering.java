package employeeFilteringTool;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EmployeeFiltering {
    public static void main(String[] args) {

        Predicate<Employee> filterBySalary = (Employee e) -> e.getSalary()>100000;
        Predicate<Employee> deptEngg = e->e.getDepartment().equals("Engineering");
        Consumer<Employee> printEmployee = System.out::println;
        Function<Employee, String> empNames = Employee::getName;
        Function<Employee, String> empDept = Employee::getDepartment;
        Supplier<Employee> defaultEmp = () -> new Employee("Rajak",35,128000,"Management");

       // System.out.println(filterBySalary.test(new Employee("Rajak",35,128000,"Management")));
        System.out.println(defaultEmp.get());

        List<Employee> employees = Employee.getAll();

        employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 100000))
                .forEach((key, employeesList) ->{
                    System.out.println("Key: " + key);
                    employeesList.forEach(e-> System.out.println("Emp: " + e));
                });

        //employees.stream().filter(filterBySalary).forEach(printEmployee);



       // employees.stream().filter(deptEngg.and(filterBySalary)).forEach(printEmployee);
       /* System.out.println("Printing employee names and departments: ");
       employees.forEach(e-> System.out.println(
               empNames.apply(e) + " : " + empDept.apply(e)
       ) );
        System.out.println(empNames + " : " + empDept);*/

       /* //sort by salary
        Stream<Employee> employeeStream = employees.stream().sorted(Comparator.comparing(Employee::getSalary));
        System.out.println(employeeStream);*/

        //Group By Department
        //employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((d,e) -> System.out.println("Department " + d + " : " + "EMP " + e));

        //Avg Salary per dept
       /* employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary))).forEach((D, C) -> System.out.println("Department " +D +" : " + "Avg -> " +C));
*/
        //Highest Paid Employee
       /* Optional<Employee> higestPaidEmp = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        higestPaidEmp.ifPresent(printEmployee);*/


        // System.out.println(defaultEmp);

       /* employees.stream()
                .filter(filterBySalary)
                .forEach(System.out::println);*/

        Comparator<Employee> byDeptThanSalary =
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary);

      /*  employees.stream()
                .sorted(byDeptThanSalary)
                .forEach(System.out::println);*/

        //Reversed Sorting
//        employees.stream()
//                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
//                .forEach(System.out::println);

        //Group by department
      /*  employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((dept, empList) -> System.out.println(dept + " : " + empList));*/

        //Average salary per department
       /* employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((dept, avg) -> System.out.println(dept + ":" + avg));*/

       // employees.stream().distinct().forEach(System.out::println);
    }
}
