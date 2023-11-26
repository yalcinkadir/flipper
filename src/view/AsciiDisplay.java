package view;

public class AsciiDisplay implements Display {
    @Override
    public void render(int score, int ballsLeft) {
        // Beispielhafte Darstellung des Spiels
        System.out.println("Punktestand: " + score + " | Verbleibende Bälle: " + ballsLeft);
        System.out.println("ASCII Art des Flipperautomaten hier");
        // Weitere Darstellungen des Spielzustands
    }

    @Override
    public void render() {
        // Implementiere die Logik zur Darstellung des Spiels
        // Beispiel: Anzeige des Spielfelds, der Punktzahl, der verbleibenden Bälle etc.
    }

}


