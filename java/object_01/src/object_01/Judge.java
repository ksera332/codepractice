package object_01;

public class Judge {
	public void startJanken(Player player1,Player player2) {
		System.out.println("じゃんけん開始\n");
		for (int cnt = 0; cnt < 3; cnt++) {
			System.out.println((cnt + 1 ) + "回戦目");

			Player winner = judgeJanken(player1,player2);

			if(winner != null) {
				System.out.println("\n" + winner.getName() + "が勝ちました\n");
				winner.notifyResult(true);
			}
			else {
				System.out.println("\n引き分け\n");
			}
		}
		System.out.println("終わり");

		Player finalWinner = judgeFinalWinner(player1,player2);
		System.out.print(player1.getWinCount() + "　対　" + player2.getWinCount() + "で"	);
		if(finalWinner != null) {
			System.out.println(finalWinner.getName() + "の勝ち\n");
		}
		else {
			System.out.println("引き分け\n");
		}
	}
	private Player judgeJanken(Player player1,Player player2) {
		Player winner = null;

		int player1hand = player1.showHand();
		int player2hand = player2.showHand();

		printHand(player1hand);
		System.out.print(" vs. ");
		printHand(player2hand);
		System.out.print("\n");

		if((player1hand == Player.STONE && player2hand == Player.SCISSORS)||
		(player1hand == Player.SCISSORS && player2hand == Player.PAPER)||
		(player1hand == Player.PAPER && player2hand == Player.STONE)) {
			winner = player1;
		}
		else if((player2hand == Player.STONE && player1hand == Player.SCISSORS)||
				(player2hand == Player.SCISSORS && player1hand == Player.PAPER)||
				(player2hand == Player.PAPER && player1hand == Player.STONE)) {
					winner = player2;
		}
		return winner;
		}
	private Player judgeFinalWinner(Player player1,Player player2) {
		Player winner = null;

		int player1WinCount = player1.getWinCount();
		int player2WinCount = player2.getWinCount();
		if(player1WinCount > player2WinCount) {
			winner = player1;
		}
		else if(player1WinCount < player2WinCount) {
			winner = player2;
		}
		return winner;
	}
	private void printHand(int hand) {
		switch (hand) {
		case Player.STONE:
			System.out.print("グー");
			break;
		case Player.SCISSORS:
			System.out.print("チョキ");
			break;
		case Player.PAPER:
			System.out.print("パー");
			break;
		}
	}
}
