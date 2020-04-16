package day3;

public class sample305{

    public static void main(String[] args){

        int num = (int)(Math.random()*7)+1;
        switch(num){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("out");
        }
    }
}