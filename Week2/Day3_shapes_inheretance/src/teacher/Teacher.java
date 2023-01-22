package teacher;

public class Teacher {

    protected  double salary;

    public Teacher() {
    }

    public Teacher(double salary) {
        this.salary = salary;
    }

    public double  getSalary() {
        return salary;
    }

    public final void setSalary(double salary){
        this.salary = salary;
    };

}
