package com.BlackJackApp;

import java.util.ArrayList;
import java.util.List;

class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("Ace")) {
                numAces++;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public void displayHand() {
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println("Total value: " + getValue());
    }
}
