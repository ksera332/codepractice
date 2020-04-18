package app;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;

public class panel {
    public static JLabel headerLabel;
	public static JLabel contentsLabel;
    public static void createPanel(JFrame flame){
        //へっだーパネル設定        
        Dimension headerPanekDimension = new Dimension(640,50);//Dimensionクラス (幅,高さ)
        JPanel headerPanel = setPanel(Color.BLACK,headerPanekDimension);
        headerLabel = new JLabel("いざ、勝負!");
        headerLabel = setFont(Color.WHITE, headerLabel, 24);
        headerPanel.add(headerLabel);
        flame.add(headerPanel,BorderLayout.NORTH);//Windowに追加

        //コンテンツパネル
        Dimension contentsPanelDimension = new Dimension(640,380);
        JPanel contentsPanel = setPanel(Color.WHITE,contentsPanelDimension);
        contentsLabel = new JLabel("じゃんけん・・・");
        contentsLabel = setFont(Color.BLACK, contentsLabel,54);
        contentsPanel.add(contentsLabel);
        flame.add(contentsPanel, BorderLayout.CENTER);

        //フッターパネル
        Dimension footerPanelDimension = new Dimension(640,50);
        JPanel footerPanel = setPanel(Color.BLACK,footerPanelDimension);
        Player.createButton(footerPanel);

        flame.add(footerPanel,BorderLayout.SOUTH);

    }
    public static JPanel setPanel(Color color,Dimension PanelDimensione){
        JPanel panel = new JPanel(); //JPanelのインスタンス
        panel.setPreferredSize(PanelDimensione);
        panel.setLayout(new BorderLayout());
        panel.setBackground(color);
        return(panel);
    }

    public static JLabel setFont(Color color,JLabel label,int strSize){
        label.setForeground(color);
        Font labelFont = new Font("MS ゴシック",Font.PLAIN,strSize);
        label.setFont(labelFont);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        return(label);
    }
}