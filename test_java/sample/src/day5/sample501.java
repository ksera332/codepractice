package day5;

public class sample501{

    public static void main(String[] args){
        double d[] = new double[3];
        double sum,ave;
        d[0] = 1.2;
        d[1] = 3.4;
        d[2] = 4.1;
        sum = 0.0;
        for(int i = 0;i < d.length;i++){
            System.out.println(d[i]);
            sum += d[i];
        }
        ave = sum/3;
        System.out.println("sum = " + sum);
        System.out.println("ave = " + ave);
    }
}