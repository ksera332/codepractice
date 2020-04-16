package exday2;

public class ambulance extends Car{

    private int number = 119;
    public ambulance(){
        System.out.println("create Ambulance");
    }
    public void seve(){
        System.out.println("呼び出しは" + number);
    }
}