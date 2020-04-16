package day6;

public class sample601{

    public static void main(String[] args){
        sampleClass01 s = new sampleClass01();
        s.n = 100;
        s.s = "hello";
        int ans = s.add(1,2);
        String str = s.add("World");
        System.out.println(ans);
        System.out.println(str);
        s.showNum();

    }
}