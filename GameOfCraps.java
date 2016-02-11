/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofcraps;

import java.util.Random;

/**
 *
 * @author Neelraj
 */
public class GameOfCraps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GameOfCraps gameofcraps = new GameOfCraps();
        System.out.println("Even Wager statergy"); 
        gameofcraps.evenWager();
        System.out.println("Martingale Wager statergy"); 
        gameofcraps.martingaleWager();
        System.out.println("Reverse Martingale Wager statergy"); 
        gameofcraps.reverseMartingaleWager();
            
    }

    public boolean playGame() {
        boolean bet = false;
        int firstroll = rollDice();// Get the value of dice
        //System.out.println("first : "+ firstroll);
        if (firstroll == 7) {
            bet = true;
        } else if (firstroll == 2 || firstroll == 3 || firstroll == 12) {
            bet = false;
        } else {
            int nextroll;
            while (true) {
                nextroll = rollDice();
                //System.out.println("next : "+ nextroll);
                if (nextroll == 7) {
                    bet = false;
                    break;
                } else if (nextroll == firstroll) {
                    bet = true;
                    break;
                }
            }
        }
        return bet;
    }

    public int rollDice() {
        Random r = new Random();
        int dice = r.nextInt(11) + 2; //Roll dice to generate rnadom number from 2-12

        return dice;
    }

    public void evenWager() {
        int balance = 1000;
        int wager = 100;
        int gameno = 1;
        while (balance >0 && gameno <= 10) {
            boolean outcome = playGame();
            if (outcome == true) {
                balance = balance + wager;
            } else {
                balance = balance - wager;
            }
            gameno++;
            System.out.println("You are left with : " + balance);
        }

    }

    public void martingaleWager() {
        int balance = 1000;
        int wager = 100;
        int gameno = 1;

        while (balance >0 && gameno <= 10) {
            boolean outcome = playGame();
            if (outcome == true) {
                balance = balance + wager;
                wager = 100;
            } else {
                balance = balance - wager;
                wager = wager * 2;
                if (wager > balance) {
                    wager = balance;
                }
            }
            gameno++;
            System.out.println("You are left with : " + balance);
        }
    }

    public void reverseMartingaleWager() {
        int balance = 1000;
        int wager = 100;
        int gameno = 1;

        while (balance >0 && gameno <= 10) {
            boolean outcome = playGame();
            if (outcome == true) {
                balance = balance + wager;
                wager = wager * 2;
                if (wager > balance) {
                    wager = balance;
                }
            } else {
                balance = balance - wager;
                wager = 100;
            }
            gameno++;
            System.out.println("You are left with : " + balance);
        }
    }
}
