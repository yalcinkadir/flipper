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
        // Zusätzliche Aktionen, wenn alle Elemente getroffen wurden
    }

    @Override
    public float getX() {
        // Implementiere die Logik zur Bestimmung der X-Position
        // Beispiel: Rückgabe des Durchschnitts der X-Positionen aller untergeordneten
        // Elemente
        return x; // Der Wert von 'x' sollte entsprechend deiner Spiellogik berechnet werden
    }

    @Override
    public float getY() {
        // Implementiere die Logik zur Bestimmung der Y-Position
        // Beispiel: Rückgabe des Durchschnitts der Y-Positionen aller untergeordneten
        // Elemente
        return y; // Der Wert von 'y' sollte entsprechend deiner Spiellogik berechnet werden
    }
}