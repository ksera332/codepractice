package exday3;

public class sampleClassEx202{
    public static void main(String srgs[]){
        Crow2 c = new Crow2();
        Sparrow2 s = new Sparrow2();
        System.out.print(c.getName() + " : ");
        c.sing();
        System.out.print(s.getName() + " : ");
        s.sing();
    }
}