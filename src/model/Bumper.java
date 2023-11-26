package model;
import controller.FlipperElementVisitor;

public class Bumper implements FlipperElement {
    private float x, y; // Position des Bumpers

    public Bumper(float xPosBumper, float yPosBumper) {
    }

    @Override
    public void hit() {
        System.out.println("Bumper getroffen! Punkte erhöht.");
        // Implementiere die Logik zur Punkteerhöhung
    }

    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }
}