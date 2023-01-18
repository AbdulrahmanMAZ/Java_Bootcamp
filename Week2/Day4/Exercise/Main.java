package Exercise;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Dog();
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());

        animals.get(0).getName();
        animals.get(1).getName();



    }

}
