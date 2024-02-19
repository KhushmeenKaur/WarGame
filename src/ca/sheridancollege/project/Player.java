/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Group 8 and Feb 18, 2024
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Khushmeen
 */
public abstract class Player {

    private final String name; 
    private final ArrayList<Card> hand; 
    
    public Player (String name) {
        this.name = name;
        this.hand = new ArrayList<>();        
    }

    public String getName() {
        return name;
    }
    
    public String setName() {
        return name;
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void addToHand(Card card) {
        hand.add(card);
    }
    
    public abstract void play();

}
