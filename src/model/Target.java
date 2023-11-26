package model;

public class Target implements FlipperElement {
    private int points;
    private float x;
    private float y;

    public Target(float x, float y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void hit() {
        System.out.println("Ziel getroffen! " + points + " Punkte.");
        // Punkte zum Gesamtscore hinzufügen
    }

}
