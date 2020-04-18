//参考URL https://original-game.com/java-janken-game-program/#m_heading-0

package app;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {

        //window設定
        JFrame flame = new JFrame("じゃんけん");//Jflameのインスタンス
        flame.setSize(640, 480);//WindowSize
        flame.setLocationRelativeTo(null);//Windowが画面の中心になるらしい
        flame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//windowを消す×ボタン
        flame.setResizable(false);//windowSize固定

        panel.createPanel(flame);
        flame.setVisible(true);//表示
    }
}