/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Group 8 and Feb 18, 2024
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @Khushmeen 
 */
public abstract class Card {
    //default modifier for child classes
    private final String rank;
    private final String suit;
    
    public Card (String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of "  + suit;
    }
    
    public String getRank() {
        return rank;
    }
    
    public String getSuit() {
        return suit;
    }

}
