package controller;
import java.util.ArrayList;
import java.util.List;

import model.FlipperElement;

public class FlipperMediator {
    private List<FlipperElement> elements = new ArrayList<>();

    public void addElement(FlipperElement element) {
        elements.add(element);
    }

    public void elementHit(FlipperElement element) {
        // Logik zur Behandlung von Interaktionen zwischen Elementen
        System.out.println("Element " + element.getClass().getSimpleName() + " getroffen.");
        // Weitere spezifische Logik hier implementieren
    }
}
