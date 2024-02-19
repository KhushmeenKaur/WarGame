/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Group 8 and Feb 18, 2024
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Khushmeen
 */
public abstract class Game {

    private final String name;//the title of the game
    private final GroupOfCards deck;
    private ArrayList<Player> players;// the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
        deck = new GroupOfCards(52);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public void play() {
        for (String suit : new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) {
            for (String rank : new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}) {
                deck.getCards().add(new Card(rank, suit) {});
            }
        }
        deck.shuffle();
        
        int playerIndex = 0;
        for (Card card : deck.getCards()) {
            players.get(playerIndex).addToHand(card);
            playerIndex = (playerIndex + 1) % players.size();
        }
        
        while (true) {
            Card card1 = players.get(0).getHand().remove(0);
            Card card2 = players.get(1).getHand().remove(0);

            System.out.println(players.get(0).getName() + " plays: " + card1);
            System.out.println(players.get(1).getName() + " plays: " + card2);

            int result = card1.getRank().compareTo(card2.getRank());
            if (result > 0) {
                System.out.println(players.get(0).getName() + " wins the round!");
                players.get(0).addToHand(card1);
                players.get(0).addToHand(card2);
            } else if (result < 0) {
                System.out.println(players.get(1).getName() + " wins the round!");
                players.get(1).addToHand(card1);
                players.get(1).addToHand(card2);
            } else {
                System.out.println("It's a tie!");
                players.get(0).addToHand(card1);
                players.get(1).addToHand(card2);
            }
            
            // Check if a player has won
            for (Player player : players) {
                if (player.getHand().isEmpty()) {
                    declareWinner(player);
                    return;
                }
            }
        }
    }
    
  
    public void declareWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getHand().size() > winner.getHand().size()) {
                winner = player;
            }
        }
        System.out.println("The winner is: " + winner.getName());
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public static void main(String[] args) {
        Game warGame = new Game("War") {};
        warGame.addPlayer(new Player("Player 1") {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        warGame.addPlayer(new Player("Player 2") {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        warGame.play();
        warGame.declareWinner();
    }

    private void declareWinner(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    
