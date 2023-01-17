public class Employee {
private String id;
private String name;
private double salary;

    public Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary ;
    }
    public double getAnnualSalary() {

        return salary*12;
    }
    public double raisedSalary(int percent) {
        this.salary += (percent / 100.0) * salary;
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
