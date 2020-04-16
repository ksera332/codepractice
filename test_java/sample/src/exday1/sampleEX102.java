package exday1;

public class sampleEX102{

    public sampleEX102(){
        System.out.println("コンストラクタ");
    }
    public void foo(){
        System.out.println("インスタンス");
    }
    public static void bar(){
        System.out.println("静的メソッド");
    }
    public static void main(String[] args){
        sampleEX102 i = new sampleEX102();
        i.foo();
        i.bar();
        sampleEX102.bar();
        System.gc();
    }
}