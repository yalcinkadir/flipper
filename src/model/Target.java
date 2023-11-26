package model;

public class Target implements FlipperElement {
    private int points;
    private float x = 0.0f; // Initialize x with a default value

    private float y = 0.0f; // Initialize x with a default value

    public Target(float x, float y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
    }

    @Override
    public void hit() {
        System.out.println("Element getroffen! Punkte erhöht.");
        GameDirector.getInstance().addScore(points);
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
