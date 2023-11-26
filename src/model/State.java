package model;
import controller.Flipper;
import model.State;

public abstract class State {

    private Flipper flipper;

    public State(Flipper flipper) {
        this.flipper = flipper;;
    }

    public Flipper getFlipper() {
        return flipper;
    }

    public abstract void insertCoin();

    public abstract void play();
}