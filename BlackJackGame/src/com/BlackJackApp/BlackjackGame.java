package com.BlackJackApp;

import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        deck.shuffle();

        // Initial deal
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("Player's hand:");
        playerHand.displayHand();
        System.out.println();

        System.out.println("Dealer's hand:");
        dealerHand.displayHand();
        System.out.println();

        // Player's turn
        while (true) {
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("h")) {
                playerHand.addCard(deck.drawCard());
                System.out.println("Player's hand:");
                playerHand.displayHand();
                System.out.println();

                if (playerHand.getValue() > 21) {
                    System.out.println("Bust! You lose.");
                    break;
                }
            } else if (choice.equals("s")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }

        // Dealer's turn
        System.out.println("Dealer's hand:");
        dealerHand.displayHand();
        System.out.println();

        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.drawCard());
            System.out.println("Dealer draws a card.");
            System.out.println("Dealer's hand:");
            dealerHand.displayHand();
            System.out.println();
        }

        // Determine the winner
        int playerValue = playerHand.getValue();
        int dealerValue = dealerHand.getValue();

        System.out.println("Player's hand value: " + playerValue);
        System.out.println("Dealer's hand value: " + dealerValue);
        System.out.println();

        if (playerValue > 21) {
            System.out.println("Bust! You lose.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts! You win.");
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (playerValue < dealerValue) {
            System.out.println("You lose.");
        } else {
            System.out.println("It's a tie.");
        }
    }
}

