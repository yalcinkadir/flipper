package model;
import java.util.ArrayList;
import java.util.List;

public class ComplexElement implements FlipperElement {
    private List<FlipperElement> elements = new ArrayList<>();

    public void addElement(FlipperElement element) {
        elements.add(element);
    }

    @Override
    public void hit() {
        for (FlipperElement element : elements) {
            element.hit();
        }
        // Zusätzliche Aktionen, wenn alle Elemente getroffen wurden
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