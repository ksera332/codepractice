package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) {
        String title = "   CodeBreaker  ";
        String rule = "隠された3つの数字をあてます。\n"
                    + "1つの数字は1から6の間です。\n"
                    + "3つの答えの中に同じ数字はありません。\n"
                    + "入力した数字の、"
                    + "位置と数字が当たってたらヒット、\n"
                    + "数字だけあってたらブローとカウントします。\n"
                    + "全部当てたら(3つともヒットになったら)"
                    + "終了です\n\n";
        int[] answer = new int[3];//答え
        int[] input = new int[3];//入力
        int hit = 0,blow = 0,count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(title);
        System.out.println(rule);

        //答えの生成
        //同じ数字がないようにする
        for(int i = 0; i<answer.length;i++){
            answer[i] = (int)(Math.random() * 6 + 1);
            boolean flag = false;
            for(int j = i - 1; j >=0;j-- ){
                if(answer[i] == answer[j]){
                    flag = true;
                    answer[i] = (int)(Math.random()*6 - 1);
                }
            }
            while(flag == true){
                for(int j = i - 1; j >=0;j-- ){
                    if(answer[i] == answer[j]){
                        flag = true;
                        answer[i] = (int)(Math.random()*6 - 1);
                    }
                }
            }
        }
    //ゲーム
    while(true){
        count++;
        System.out.println("***" + count + "回目 ***");
        for(int i = 0;i<answer.length;i++){
            System.out.println((i+1) + "個目 : ");
            try{
                input[i] = Integer.parseInt(br.readLine());
            }catch(NumberFormatException e){
                System.err.println("数字入れろや");
                i--;
            }catch(IOException e){
                System.err.println("もういっかい入れろ");
                i--;
            }
        }
        //答え合わせ
        hit = 0;
        blow = 0;
        for(int k=0; k<answer.length;k++){
            for(int j=0;j<answer.length;j++){
                if(k==j && input[k] == answer[j]){
                    hit++;
                }
                else if(input[k] == answer[j]){
                    blow++;
                }
            }
        }
        System.out.println("ヒット" + hit + " ブロー " + blow);
        if(hit == 3){
            System.out.println("クリア!");
        }
        else{
        System.out.println();
        }
    }
    }
}

        
    