package app;

import java.util.Random;
import java.util.Stack;
import java.util.Scanner;


public class App {

    static int mazeSize = 30;
    //壁をTrue 道をFalse
    static boolean[][] wall;
    static int row,col;
    static Stack<Integer> rowStack = new Stack<Integer>();
    static Stack<Integer> colStack = new Stack<Integer>();
    static int usrRow = mazeSize - 1,usrCol = 1,goalRow = 0,goalCol = mazeSize - 2;

    public static void main(String[] args) {
        
        if(args.length != 1){
            System.out.println("Usage: java maze [mazeSize]");
            return;
        }

        //Integer.parseIntは文字列→Intらしい
        mazeSize = Integer.parseInt((args[0]));
        wall = new boolean[mazeSize][mazeSize];

        printUsage();

        createMaze();
        resetUsr();
        resetGoal();

        Scanner scan = new Scanner(System.in);
        scan.close();

        String keys = "";
        char key;
        long start = System.currentTimeMillis(),end;

        while(true){
            printMaze();
            keys = scan.next();
            key = keys.charAt(keys.length() - 1);
            moveUsr(key);

            if(usrRow == goalRow && usrCol == goalCol){
                end = System.currentTimeMillis();
                printResult((end - start) / 1000);
                break;
            }
        }
    }

    //迷路を作るメソッド
    static void createMaze(){
        //穴掘り法を使うのでまず全部壁にする
        for(int i = 0;i<mazeSize;i++){
            for(int j = 0;j<mazeSize;j++){
                wall[i][j] = true;
            }
        }

        //開始位置をランダム選択(1 ~ mazeSize-2)
        Random rnd = new Random();
        row = rnd.nextInt(mazeSize-2) + 1;
        col = rnd.nextInt(mazeSize-2) + 1;
        wall[row][col] = false;

        rowStack.push(row);
        colStack.push(col);

        boolean continueFlag = true;

        while(continueFlag){

        }
    }

    //迷路を表示するメソッド
    static void printMaze(){
        for(int i = 0;i < mazeSize;i++){
            for(int j = 0;j < mazeSize;j++){
                if(i == usrRow && j == usrCol){
                    System.out.println("**");
                }
                else if(i == goalRow && j == goalCol){
                    System.out.println("Go");
                }
                else if (wall[i][j]){
                    System.out.println("[]");
                }
                else{
                    System.out.println(" ");
                }
                System.out.println();
            }
        }
    }

    //穴を掘る
    static void extendPath(){
        boolean extendFlag = true;
        while(extendFlag){
            extendFlag = extendPathSub();
        }
    }

    //穴を掘れたらTrue、ミスったらFalse
    static boolean extendPathSub(){
        Random rnd = new Random();
        //上:0下:1左:2右:3
        int direction = rnd.nextInt(4);

        for(int i = 0;i<4;i++){
            direction = (direction+i) % 4;
            if(canExtendPathWithDir(direction)){
                movePoint(direction);
                return true;
            }
        }
        return false;
    }

    //掘れるかどうかの判定
    static boolean canExtendPathWithDir(int direction){
        int exRow = row,exCol = col;

        switch(direction){
            case 0://上
                exRow--;
                break;
            
            case 1://下
                exRow++;
                break;
            
            case 2://左
                exCol--;
                break;

            case 3://右
                exCol++;
                break;
        }

        if(countSurroundingPath(exRow,exCol) > 1){
            return false;
        }

        return true;
    }

    //周囲1マスにある道の数を数える
    static int countSurroundingPath(int row,int col){
        int num = 0;

        if (row - 1 < 0 || !wall[row - 1][col]){
            num++;
        }
        if(row + 1 > mazeSize-1 || !wall[row +1][col]){
            num++;
        }
        if(col - 1 <0 || !wall[row][col - 1]){
            num++;
        }
        if(col +1>mazeSize-1 || !wall[row][col + 1]){
            num++;
        }
        return num;
    }

    //指定した方向1マスrowとcolを移動させるメソッド
    static void movePoint(int direction){
        switch(direction){
            case 0://上
                row--;
                break;

            case 1://下
                row++;
                break;

            case 2://左
                col--;
                break;

            case 3://右
                col++;
                break;
        }
        wall[row][col] = false;
        rowStack.push(row);
        colStack.push(col);
    }
    static boolean canExtendPathWithDir(){
        return (canExtendPathWithDir(0) || canExtendPathWithDir(1) || canExtendPathWithDir(2) || canExtendPathWithDir(3));
    }

    //ユーザー初期位置に動かす
    static void resetUsr(){
        usrRow = mazeSize - 1;
        usrCol = 1;

        while(true){
            if(wall[usrRow - 1][usrCol]){
                usrCol++;
            }
            else{
                break;
            }
        }
        wall[usrRow][usrCol]= false;
    }

    //ゴールを初期位置に動かすメソッド
    static void resetGoal(){
        goalRow = 0;
        goalCol = mazeSize - 2;

        while(true){
            if(wall[goalRow + 1][goalCol]){
                goalCol--;
            }
            else{
                break;
            }
        }
        wall[goalRow][goalCol] = false;
    }

    static void moveUsr(char key){
        String errMes = "You can not move there";
        int exUsrRow = usrRow,exUsrCol = usrCol;

        switch(key){
            case 'w'://上
                exUsrRow--;
                break;
            
            case 's'://下
                exUsrRow++;
                break;

            case 'a'://左
                exUsrCol--;
                break;

            case 'd'://右
                exUsrCol++;
                break;

            case 'R'://リスタート
                resetUsr();
                return;
            
            case 'N'://ニューゲーム
                createMaze();
                resetUsr();
                resetGoal();
                return;

            default:
            System.out.println(errMes);
            return;
        }

        if(exUsrRow > mazeSize -1 || wall[exUsrRow][exUsrCol]){
            System.out.println(errMes);
            return;
        }
        usrRow = exUsrRow;
        usrCol = exUsrCol;
    }

    static void printResult(long secondTime){
        System.out.println();
        System.out.println("+-+-+-+-+-+-+-+-+-+");
        System.out.println("|c|o|n|g|r|a|t|s|!|");
        System.out.println("+-+-+-+-+-+-+-+-+-+");
        System.out.println();

        System.out.println("Your time is " + secondTime + " seconds.");
        System.out.println();
    }

    // 遊び方を表示するメソッド
	static void printUsage() {
		System.out.println("Welcome to " + mazeSize + "*" + mazeSize + " Maze!");
		System.out.println();

		System.out.println("Usage:");
		System.out.println("** in the lower left is YOU.");
		System.out.println("GO in the upper right is GOAL.");
		System.out.println();

		System.out.println("Press the w key and the enter key to move UP.");
		System.out.println("Press the s key and the enter key to move DOWN.");
		System.out.println("Press the a key and the enter key to move LEFT.");
		System.out.println("Press the d key and the enter key to move RIGHT.");
		System.out.println();

		System.out.println("Press the R key and the enter key to RESTART game.");
		System.out.println("Press the N key and the enter key to start NEW game.");
		System.out.println();

		System.out.println("GAME START!!");
	}
 }