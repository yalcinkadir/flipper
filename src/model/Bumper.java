package model;

public class Bumper implements FlipperElement {
    private int points;
    private float radius;
    private long lastHitTime;
    private static final long COOLDOWN_PERIOD = 500;

    public Bumper(float x, float y, int points) {
        this.points = points;
        this.lastHitTime = System.currentTimeMillis() - COOLDOWN_PERIOD;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public void hit() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastHitTime > COOLDOWN_PERIOD) {
            System.out.println("Kollision erkannt Bumper");
            System.out.println("Element getroffen! Punkte erhöht.");
            GameDirector.getInstance().addScore(points);
            System.out.println("Punktestand: " + GameDirector.getInstance().getScore());

            lastHitTime = currentTime;
        }
    }

    @Override
    public float getX() {
        float x = 0.0f;
        return x;
    }

    @Override
    public float getY() {
        float y = 0.0f;
        return y;
    }

}