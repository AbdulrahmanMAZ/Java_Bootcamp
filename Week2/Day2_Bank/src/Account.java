public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int debit(int amount) {
        if (amount > 0){
        this.balance += amount;
        }
        return this.balance ;
    }
    public int credit(int amount) {
        if (balance >= amount && amount > 0)
        {
            this.balance -= amount;
        }else{
            System.out.println("Not enough money");
        }
       return  this.balance ;
    }
    public int tarnsferTo(Account account,int amount) {
        if (balance >= amount && amount > 0)
        {
            this.balance -= amount;
            account.debit(amount);
        }else{
            System.out.println("Not enough money");
        }
        return  this.balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}