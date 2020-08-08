package app;

import java.util.Random;

public class Computer {
        public static int decidesComputerHand(){
            Random random = new Random();
            int rnd = random.nextInt(3) + 1;
            if(rnd == 1) panel.contentsLabel.setText("グー");
            else if(rnd == 2) panel.contentsLabel.setText("チョキ");
            else if(rnd == 3) panel.contentsLabel.setText("パー");

            return (rnd);
    }
}