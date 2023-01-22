package teacher;

public class PartTeacher extends Teacher{
    private int hours;
    public PartTeacher(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
        super.salary= (calculateSalary());
    }
    public double calculateSalary(){
        double salary;
        if (hours > 150)
              salary =hours * 50;
        else {
            salary = hours * 30;
        }
        return salary;
    }



}
