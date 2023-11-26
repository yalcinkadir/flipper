package model;

public class Bumper implements FlipperElement {
    private int points;

    public Bumper(float x, float y, int points) {
        this.points = points;
    }

    @Override
    public void hit() {
        System.out.println("Element getroffen! Punkte erhöht.");
        GameDirector.getInstance().addScore(points);
    }

    private float y;

    @Override
    public float getX() {
        float x = 0.0f; // Initialize x with a default value
        return x;
    }

    @Override
    public float getY() {
        float y = 0.0f; // Initialize x with a default value

        return y;
    }

}