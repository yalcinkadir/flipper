package model;

public class Ball {
    private float x, y;
    private float vx, vy;
    private float radius;

    public Ball(float x, float y, float vx, float vy, float radius) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void updatePosition() {
        x += vx;
        y += vy;
    }

    public void bounceOff() {
        vx = -vx;
        vy = -vy;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setVelocity(float vx, float vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void checkCollision(FlipperElement element) {
    }

}