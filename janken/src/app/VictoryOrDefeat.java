package app;

public class VictoryOrDefeat {
    private static int point = 0;
    public static final void decisionVictoryOrDefeat(int computerHand,int playerHand){
        int playerHandTemp = playerHand;
        playerHandTemp++;

         if(playerHand == computerHand){
             panel.headerLabel.setText("あいこ! (" + point + ")");
         }
         else if((playerHand == 3 && computerHand == 1) || (playerHandTemp == computerHand)){
             point++;
             panel.headerLabel.setText("You Win!(" + point + ")");
         }
         else{
             point = Math.max(0,point--);
             panel.headerLabel.setText("You Lose!(" + point + ")");
        }
    }
}