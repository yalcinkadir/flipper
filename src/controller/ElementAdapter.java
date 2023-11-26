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
        // Die hit Methode ruft die activate Methode des inkompatiblen Elements auf.
        incompatibleElement.activate();
    }

    @Override
    public float getX() {
        // Implementiere die Methode
        return 0; // Rückgabewert als Platzhalter
    }

    @Override
    public float getY() {
        // Implementiere die Methode
        return 0; // Rückgabewert als Platzhalter
    }
}