package controller;
import model.FlipperElement;
import model.IncompatibleElement;

public class ElementAdapter implements FlipperElement {
    private IncompatibleElement incompatibleElement;

    public ElementAdapter(IncompatibleElement incompatibleElement) {
        this.incompatibleElement = incompatibleElement;
    }

    @Override
    public void hit() {
        incompatibleElement.activate();
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