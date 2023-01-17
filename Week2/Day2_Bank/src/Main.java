import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Employee emp = new Employee("123","Abdulrahman",1000);
        Account acc =new Account("1234","Abdulrahman",1000);
        Account ac2 =new Account("1234","Abdulrahman",0);

        //Employee salary raised
        System.out.println("Employee salary before raise: "+emp.getSalary());
        System.out.println("Employee annual salary before raise: "+emp.getAnnualSalary());
        double raise =  emp.raisedSalary(10);
        System.out.println("The amount of raise is: "+raise);
        System.out.println("Employee salary after raise: "+emp.getSalary());
        System.out.println("Employee annual salary after raise: "+emp.getAnnualSalary());
        System.out.println("============================");


        //Debit Operation
        System.out.println("Account balance before Debit: "+acc.getBalance());
        acc.debit(1500);
        System.out.println("Account balance after Debit: "+acc.getBalance());
        System.out.println("============================");

        //Credit Operation
        System.out.println("Account balance before credit: "+acc.getBalance());
        acc.credit(500);
        System.out.println("Account balance after credit: "+acc.getBalance());
        System.out.println("============================");


        //Transfer Operation
        int transfer = 150;
        System.out.println("Account TWO balance before receiving transfer: "+ac2.getBalance());
        System.out.println("Account ONE balance before sending transfer: "+acc.getBalance());


//        System.out.print("Transferring "+ transfer +" from account ONE to TWO ");

//        //Loading
//        TimeUnit.SECONDS.sleep(2);
//        System.out.print(".");
//        TimeUnit.SECONDS.sleep(2);
//        System.out.print(".");
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(".");

        acc.tarnsferTo(ac2,transfer);

        System.out.println("Account TWO balance after receiving transfer: "+ac2.getBalance());
        System.out.println("Account ONE balance after sending transfer: "+acc.getBalance());


    }
}
