package model;
public class Ramp implements FlipperElement {
    @Override
    public void hit() {
        System.out.println("Ramp getroffen!");
        // Implementiere die Logik für die Rampe
    }

    @Override
    public float getX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getX'");
    }

    @Override
    public float getY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getY'");
    }
}