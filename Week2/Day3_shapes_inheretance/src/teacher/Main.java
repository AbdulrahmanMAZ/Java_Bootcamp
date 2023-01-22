package teacher;

public class Main {
    public static void main(String[] args) {
//        Student std = new Student("Abdulrahman","amaz.alfaifi@gmail.com","05335353","2212","2");
////        std.setName("Hello");

        FullTeacher FT = new FullTeacher(0);
        PartTeacher PT = new PartTeacher(151);

        //        FT.setSalary(100);
        FT.setSalary(9000);
        PT.setSalary(1);

        System.out.println(FT.getSalary());
        System.out.println(PT.getSalary());



    }
}