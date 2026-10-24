package lk.kaushalya.model;

import java.util.Stack;

// originator
class Player{

    private String name;
    private int health;
    private int score;

    public Player(String name, int health, int score) {
        this.name = name;
        this.health = health;
        this.score = score;
    }

    public void display(){
        System.out.println();
        System.out.println("Player Name: " + this.name);
        System.out.println("Health: " + this.health);
        System.out.println("Score: " + this.score);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

// Memento
final class PlayerMemento{

    private int score;

    public PlayerMemento(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}

// CareTaker
class GameCareTaker{

    private Stack<PlayerMemento> playerMementoStack = new Stack<>();

    public void saveGame(Player player){
        PlayerMemento playerMemento = new PlayerMemento(player.getScore());
        playerMementoStack.push(playerMemento);
        System.out.println();
        System.out.println("Game Saved for Player: " + player.getName() + " with Score: " + player.getScore());
    }

    public void loadGame(Player player){
        PlayerMemento playerMemento = playerMementoStack.pop();
        player.setScore(playerMemento.getScore());
        System.out.println();
        System.out.println("Game Loaded for Player: " + player.getName() + " with Score: " + player.getScore());
    }
}

public class Test {
    public static void main(String[] args) {

        Player player = new Player("Kaushalya", 100, 0);
        GameCareTaker gameCareTaker = new GameCareTaker();
       gameCareTaker.saveGame(player);

        player.setScore(100);
        System.out.println("Player Score Updated to: " + player.getScore());

        gameCareTaker.saveGame(player);

        player.setScore(200);
        System.out.println("Player Score Updated to: " + player.getScore());
        gameCareTaker.saveGame(player);

        player.setScore(350);
        System.out.println("Player Score Updated to: " + player.getScore());
        player.display();

        gameCareTaker.loadGame(player);
        System.out.println("Player Score after loading game: " + player.getScore());
        player.display();

        gameCareTaker.loadGame(player);
        System.out.println("Player Score after loading game: " + player.getScore());
        player.display();

        gameCareTaker.loadGame(player);
        System.out.println("Player Score after loading game: " + player.getScore());
        player.display();
    }
}