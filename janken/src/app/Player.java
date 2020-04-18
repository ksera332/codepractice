package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;

public class Player implements ActionListener{
    //private static int point = 0;
    public static void createButton(JPanel footerPanel){
        //ボタン
        JButton btnGu = new JButton("グー");
        btnGu = setButton(btnGu);
        footerPanel.add(btnGu,BorderLayout.WEST);

        JButton btnChoki = new JButton("チョキ");
        btnChoki = setButton(btnChoki);
        footerPanel.add(btnChoki,BorderLayout.CENTER);

        JButton btnPaa = new JButton("パー");
        btnChoki = setButton(btnPaa);
        footerPanel.add(btnChoki,BorderLayout.EAST);
    }
    public static JButton setButton(JButton button){
        int buttonSizeX = (640 -20)/3;
        button.setPreferredSize(new Dimension(buttonSizeX,50));
        Font buttonFont = new Font("Msゴシック",Font.PLAIN,24);
        button.setFont(buttonFont);

        Player player = new Player();
        button.addActionListener(player);

        return(button);
    }
    public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		int playerHand = 0;
		if (command.equals("グー")) playerHand = 1;
		else if (command.equals("チョキ")) playerHand = 2;
		else if (command.equals("パー"))  playerHand = 3;
		
		int computerHand = Computer.decidesComputerHand();
        VictoryOrDefeat.decisionVictoryOrDefeat(computerHand, playerHand);
    }
}