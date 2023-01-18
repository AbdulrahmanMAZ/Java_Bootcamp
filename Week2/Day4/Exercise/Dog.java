package Exercise;

public class Dog implements Animal{

    @Override
    public void getName() {
        System.out.println("HAO HAO");
    }

    @Override
    public String toString() {
        return "I AM A DOG";
    }
}

