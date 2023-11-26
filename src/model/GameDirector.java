package model;

public class GameDirector {
    private static GameDirector instance;
    private int score;

    private GameDirector() {
        score = 0;
    }

    public static GameDirector getInstance() {
        if (instance == null) {
            instance = new GameDirector();
        }
        return instance;
    }

    public void addScore(int points) {
        score += points;
        System.out.println("Aktueller Punktestand: " + score);
    }

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }
}
