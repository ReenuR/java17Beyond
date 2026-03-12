package employeeFilteringTool;

import java.util.List;

public class Employee {
    String name;
    int age;
    int salary;
    String department;

    public Employee(String name, int age, int salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static List<Employee> getAll() {
        return List.of(
                new Employee("Reenu", 37, 120000, "Engineering"),
                new Employee("Akhil", 25, 80000, "Engineering"),
                new Employee("Dev", 29, 95000, "Finance"),
                new Employee("Riya", 40, 150000, "Management"),
                new Employee("Raj", 35, 120000, "Engineering")
        );
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return age == employee.age &&
                name.equals(employee.name) &&
                department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + department.hashCode();
        return result;
    }
}
