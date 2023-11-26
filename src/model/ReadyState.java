package model;
import controller.Flipper;

public class ReadyState extends State {
    public ReadyState(Flipper flipper) {
        super(flipper);
    }

    @Override
    public void insertCoin() {
        System.out.println("Münze bereits eingefügt. Das Spiel beginnt!");
    }

    @Override
    public void play() {
        System.out.println("Spiel startet. Viel Spaß!");
        // Hier die Logik für die Ballfreigabe und den Start der Spielmechaniken
        getFlipper().startGame();
    }
}
