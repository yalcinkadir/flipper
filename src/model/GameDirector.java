package model;
public class GameDirector {
    private static GameDirector instance;

    private GameDirector() {
        // Private Konstruktor verhindert externe Instanziierung
    }

    public static GameDirector getInstance() {
        if (instance == null) {
            instance = new GameDirector();
        }
        return instance;
    }

    // Weitere Methoden zur Spielführung
}