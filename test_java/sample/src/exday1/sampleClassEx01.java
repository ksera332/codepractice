package exday1;

public class sampleClassEx01{
    private int value = 0;
    private static int num = 0;
    
    public sampleClassEx01(int value){
        this.value = value;
        num++;
    }
    public sampleClassEx01(){
        this(100);
    }
    public static int getNumberOfInstance(){
        return num;
    }
    public int getValue(){
        return this.value;
    }
}