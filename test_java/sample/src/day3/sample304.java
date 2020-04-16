package day3;

public class sample304{

    public static void main(String[] args){
        int dice = (int)(Math.random()*7 ) + 1;
        System.out.println("dice = " + dice);
        if(1<= dice && dice<=6){
            if(dice==2 || dice == 4 || dice == 6){
                System.out.println("even");
            }
            else{
                System.out.println("odd");
            }
        }else{
            System.out.println("error");
        }
    }
}