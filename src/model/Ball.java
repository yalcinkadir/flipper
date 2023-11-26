package model;

public class Ball {
    private float x, y; // Position des Balls
    private float vx, vy; // Geschwindigkeit des Balls in X- und Y-Richtung

    // Konstruktor und Methoden für die Ballbewegung
    public Ball(float x, float y, float vx, float vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void updatePosition() {
        x += vx;
        y += vy;
        // Hier könntest du auch Kollisionserkennung und -reaktion implementieren
    }

    public void bounceOff() {
        // Einfache Umkehr der Richtung als Beispiel
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
        // Logik zur Erkennung der Kollision und Reaktion darauf
    }

}