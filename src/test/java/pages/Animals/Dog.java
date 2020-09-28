package pages.Animals;

public class Dog extends Animal {

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println(classAndName() + " is barking");
    }

    public void fetch(String what) {
        System.out.println(classAndName() + " is looking for " + what);
    }

}
