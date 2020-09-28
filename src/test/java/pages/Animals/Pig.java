package pages.Animals;

public class Pig extends Animal {
    public Pig(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println(classAndName() + " is oinking");
    }

}
