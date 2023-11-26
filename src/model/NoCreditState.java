package model;
import controller.Flipper;

public class NoCreditState extends State {

    public NoCreditState(Flipper flipper) {
        super(flipper);
    }

    @Override
    public void insertCoin() {
        System.out.println("Münze eingeworfen. Wechsle in den Zustand 'ReadyState.");
        getFlipper().setState(new ReadyState(getFlipper()));
    }

    @Override
    public void play() {
        System.out.println("Kein Guthaben. Bitte Münzen einwerfen.");
    }
}