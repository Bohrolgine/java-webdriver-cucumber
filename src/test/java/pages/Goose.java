package pages;

public class Goose extends Animal{
    public Goose(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println(classAndName() + " is honking");
    }
}
