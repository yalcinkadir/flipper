package view;

public class AsciiDisplay implements Display {
    @Override
    public void render(int score, int ballsLeft) {
        System.out.println("Punktestand: " + score + " | Verbleibende Bälle: " + ballsLeft);
        System.out.println("ASCII Art des Flipperautomaten hier");
    }

    @Override
    public void render() {
    }

}


