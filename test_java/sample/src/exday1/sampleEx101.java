package exday1;

public class sampleEx101{

    public static void main(String[] args){
        sampleClassEx01 s1,s2;
        System.out.println("num_ins:"+ sampleClassEx01.getNumberOfInstance());
        s1 = new sampleClassEx01(50);
        s2 = new sampleClassEx01();

        System.out.println(s1.getValue());
        System.out.println(s2.getValue());
        System.out.println("num_ins:" + sampleClassEx01.getNumberOfInstance());
    }

}