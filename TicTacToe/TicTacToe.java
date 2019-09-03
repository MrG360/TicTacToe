
// package com.company.Main;
import java.io.IOException;
import java.util.Scanner;

/**
 * TicTacToe
 */
public class TicTacToe {
    /**
     *
     */
    static Scanner sc = new Scanner(System.in);
    static char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    final int side = 3;
    static char player = 'X';
    static void initialize()
    {
    char player = 'X';
     arr[0]='0'; arr[1]='1'; arr[2]='2'; arr[3]='3'; arr[4]='4'; arr[5]='5'; arr[6]='6'; arr[7]='7'; arr[8]='8'; arr[9]='9';

    }
    static boolean isBoardFull() {
        boolean x = true;
        for (int i = 0; i < 9; i++) {
            if (arr[i] == '1' || arr[i] == '2' || arr[i] == '3' || arr[i] == '4' || arr[i] == '5' || arr[i] == '6'
                    || arr[i] == '7' || arr[i] == '8' || arr[i] == '9')
                x = false;
        }
        return x;
    }

    static void input() throws InterruptedException, IOException {
       int i=0;
        while(i<9)
        {
                System.out.println("Player " + player + " turn");
                int x = sc.nextInt();
                if(arr[x]=='X'||arr[x]=='O')
                {
                    System.out.println("Inavlid input");
                    print();
                    --i;
                }
                else if (x > 0 && x < 10) {
                    arr[x] = player;
                    checkWinner();
                    playerchange();
                    print();
                } 
                else
                {
                    System.out.println("Invalid input"); 
                    --i;
                    print();
                }
                i++;
        }
    }

    static void restartfunc() throws IOException, InterruptedException {
        mainfunc();

    }

    static void checkWinner() throws InterruptedException, IOException {
        if (checkrows() || checkcols() || checkdiag()) {
            print();
            System.out.println("Player " + player + " wins");
            initialize();
            restartfunc();
        } else {
            boolean isTie = (!(checkdiag() || checkcols() || checkrows()) && isBoardFull());
            if (isTie == true) {

                print();
                System.out.println("It's a tie");
                initialize();
                restartfunc();
            }
        }
        return;
    }

    static boolean checkrows() {
        if ((arr[1] == arr[2] && arr[2] == arr[3]) || (arr[4] == arr[5] && arr[5] == arr[6])
                || (arr[7] == arr[8] && arr[8] == arr[9]))
            return true;
        else
            return false;
    }

    static boolean checkcols() {
        if ((arr[1] == arr[4] && arr[4] == arr[7]) || (arr[2] == arr[5] && arr[5] == arr[8])
                || (arr[3] == arr[6] && arr[6] == arr[9]))
            return true;
        else
            return false;
    }

    static boolean checkdiag() {
        if ((arr[1] == arr[5] && arr[5] == arr[9]) || (arr[3] == arr[5] && arr[5] == arr[7]))
            return true;
        else
            return false;
    }

    static void playerchange() {
        if (player == 'X')
            player = 'O';
        else
            player = 'X';
    }

    static void print() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("+---+---+---+");
        System.out.println("| " + arr[1] + " | " + arr[2] + " | " + arr[3] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + arr[4] + " | " + arr[5] + " | " + arr[6] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + arr[7] + " | " + arr[8] + " | " + arr[9] + " |");
        System.out.println("+---+---+---+");

    }

    static void mainfunc() throws IOException, InterruptedException {
        TicTacToe x = new TicTacToe();
        System.out.println("Press 1 to start");
        System.out.println("Press 0 to exit");

        int a = sc.nextInt();
        if (a == 1) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            print();
            input();
            
        } else if (a == 0) {
            System.out.println("Exiting....");
            System.exit(0);
        } else
            System.out.println("Invalid number");

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        mainfunc();
    }
}