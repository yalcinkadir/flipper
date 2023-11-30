package model;

import java.util.ArrayList;
import java.util.List;

public class ComplexElement implements FlipperElement {
    private List<FlipperElement> elements = new ArrayList<>();
    private float x;
    private float y;

    public void addElement(FlipperElement element) {
        elements.add(element);
    }

    @Override
    public void hit() {
        for (FlipperElement element : elements) {
            element.hit();
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