package app;

public class dentaku1 {
    public static void main(String[] args) throws Exception {
        int val1 = 0,val2 = 0;
        String Ope;//演算子

        if(args.length != 3){
            System.out.println("Usage:ex. java dentaku num + num");
            System.exit(0);;
        }
        val1 = Integer.parseInt(args[0]);
        val2 = Integer.parseInt(args[2]);
        Ope = args[1];

        System.out.println("入力は " + val1 + " " + Ope + " " + val2 + " です");
    }
}