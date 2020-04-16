package day7;

public class sampleClass02{

    //コンストラクタ
    public sampleClass02(){
        System.out.println("コンストラクタ");
    }
    // privateメソッド
    private void method1(){
        System.out.println("methd1(private)");
    }
    //publivメソッド1
    public void method2(){
        System.out.println("method2(public)");
    }
    //publicメソッド3
    public void method3(){
        method1();
        System.out.println("method3(public) : num =" + this.num);
    }
    //private フィールド
    private int num = 1;
}