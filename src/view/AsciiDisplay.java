package view;
public class AsciiDisplay implements Display {
    @Override
    public void render() {
        // Stelle den Spielzustand einmal dar, ohne Schleifen
        System.out.println("ASCII Art des Flipperautomaten hier");
    }
}
