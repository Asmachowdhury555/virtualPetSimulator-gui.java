public class VirtualPet {
    private String name;
    private int hunger;
    private int happiness;
    private int energy;

    public VirtualPet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 50;
    }

    public void feed() {
        hunger -= 20;
        if (hunger < 0) hunger = 0;
        energy += 5;
    }

    public void play() {
        happiness += 15;
        hunger += 10;
        energy -= 15;
        if (happiness > 100) happiness = 100;
    }

    public void rest() {
        energy += 20;
        hunger += 10;
        if (energy > 100) energy = 100;
    }

    public boolean isAlive() {
        return hunger < 100 && energy > 0;
    }

    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public int getHappiness() { return happiness; }
    public int getEnergy() { return energy; }
}
