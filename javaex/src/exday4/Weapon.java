package exday4;

public abstract class Weapon {
    private String name = "";

    public Weapon(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public abstract void attack();

}