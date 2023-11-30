package model;
public class Ramp implements FlipperElement {
    @Override
    public void hit() {
        System.out.println("Ramp getroffen!");
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }
}