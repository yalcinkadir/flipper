package model;

public class Target implements FlipperElement {
    private int points;
    private float x = 0.0f;
    private float y = 0.0f;
    private float radius;
    private long lastHitTime;
    private static final long COOLDOWN_PERIOD = 500;

    public Target(float x, float y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
        this.lastHitTime = System.currentTimeMillis() - COOLDOWN_PERIOD;

    }

    public float getRadius() {
        return radius;
    }

    @Override
    public void hit() {
        System.out.println("Kollision erkannt Target");
        long currentTime = System.currentTimeMillis();
        System.out.println("Aktuelle Zeit: " + currentTime);
        System.out.println("Letzter Treffer: " + lastHitTime);
        System.out.println("Zeit seit letztem Treffer: " + (currentTime - lastHitTime) + "ms");
    
        if (currentTime - lastHitTime > COOLDOWN_PERIOD) {
            System.out.println("Kollision erkannt Target");
            System.out.println("Element getroffen! Punkte erhöht.");
            GameDirector.getInstance().addScore(points);
            System.out.println("Punktestand: " + GameDirector.getInstance().getScore());

            lastHitTime = currentTime;
        }
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
