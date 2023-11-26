package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import factory.AsciiDisplayFactory;
import model.NoCreditState;
import model.ReadyState;
import model.State;
import model.Ball;
import model.Bumper;
import model.Target;
import model.FlipperElement;
import model.GameDirector;
import view.Display;
import view.DisplayFactory;

public class Flipper {
    private State state;
    private Ball ball;
    private Display display;
    private int ballsLeft;
    private List<FlipperElement> elements = new ArrayList<>();

    public Flipper() {
        float xPosBumper = 50; // Beispielwert für die X-Position eines Bumpers
        float yPosBumper = 100; // Beispielwert für die Y-Position eines Bumpers
        float xPosTarget = 200; // Beispielwert für die X-Position eines Ziels
        float yPosTarget = 150; // Beispielwert für die Y-Position eines Ziels
        int points = 10; // Beispielwert für die Punkte eines Ziels

        elements.add(new Bumper(xPosBumper, yPosBumper, points));
        elements.add(new Target(xPosTarget, yPosTarget, points));
        // Weitere Flipper-Elemente hinzufügen
        this.state = new NoCreditState(this);
        DisplayFactory factory = new AsciiDisplayFactory();
        this.display = factory.createDisplay();
        // Rest des Konstruktors...
    }

    public void checkEndCondition() {
        if (ballsLeft == 0) {
            endGame();
        }
    }

    public void startGame() {

        float startX = 0; // Anfangsposition X
        float startY = 0; // Anfangsposition Y
        float startVx = 1; // Anfangsgeschwindigkeit X
        float startVy = 1; // Anfangsgeschwindigkeit Y
        // Starte das Spiel
        // Aktiviere Spielmechaniken wie Flippers, Ballfreigabe etc.
        ball = new Ball(startX, startY, startVx, startVy);
        isGameRunning = true;

        System.out.println("Das Spiel hat begonnen!");
        gameLoop();
    }

    private void endGame() {
        System.out.println("Spiel beendet. Dein Punktestand: " + GameDirector.getInstance().getScore());
        askForNewGame();
    }

    private void askForNewGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Möchtest du noch einmal spielen? (ja/nein)");
            String antwort = scanner.nextLine().toLowerCase();

            if ("ja".equals(antwort)) {
                resetGame();
                showStatusAndAskForCoin();
            } else {
                System.out.println("Danke fürs Spielen!");
                // Optional: Schließe Ressourcen, beende Programm etc.
            }
        }
    }

    private void resetGame() {
        ballsLeft = 3;
        GameDirector.getInstance().resetScore();
        this.state = new NoCreditState(this);
        // Weitere Reset-Logik...
    }

    private boolean isGameRunning = false;
    private float maxY = 7; // Beispielwert

    public void gameLoop() {
        while (isGameRunning) {
            ball.updatePosition();
            for (FlipperElement element : elements) {
                checkCollision(element);
            }
            updateDisplay();

            // Überprüfe, ob der Ball verloren ist
            if (ball.getY() > maxY) {
                ballsLeft--;
                if (ballsLeft <= 0) {
                    isGameRunning = false;
                    endGame();
                } else {
                    // Reset Ball und weiter spielen
                    resetBall();
                }
            }
        }
    }

    private void resetBall() {
        float startX = 0; // Anfangsposition X
        float startY = 0; // Anfangsposition Y
        float startVx = 1; // Anfangsgeschwindigkeit X
        float startVy = 1; // Anfangsgeschwindigkeit Y
        ball = new Ball(startX, startY, startVx, startVy);
    }

    private static final float COLLISION_THRESHOLD = 1.0f; // Beispielwert

    public void checkCollision(FlipperElement element) {
        if (Math.abs(ball.getX() - element.getX()) < COLLISION_THRESHOLD &&
                Math.abs(ball.getY() - element.getY()) < COLLISION_THRESHOLD) {
            ball.bounceOff(); // Implementiere diese Methode in Ball
            element.hit(); // Erhöht Punktzahl oder führt andere Aktionen durch
        }
    }

    public static void main(String[] ags) {
        printWelcomeMessage();
        Flipper flipper = new Flipper();
        flipper.showStatusAndAskForCoin();
    }

    private static void printWelcomeMessage() {

        String reset = "\u001B[0m";
        String green = "\u001B[32m";

        System.out.println(green + "=====================================");
        System.out.println("===       Star Wars Flipper       ===");
        System.out.println("=====================================" + reset);
    }

    public void updateDisplay() {
        if (display != null) {
            display.render();
            System.out.println("Punktestand: " + GameDirector.getInstance().getScore() + " | Verbleibende Bälle: " + ballsLeft);
        } else {
            System.out.println("Display ist nicht initialisiert.");
        }
    }

    public void setState(State newState) {
        this.state = newState;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void play() {
        state.play();
    }

    public void showStatusAndAskForCoin() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) { // Hält das Programm in einer Schleife, um auf Eingaben zu warten
                System.out.println("Aktueller Zustand: " + state.getClass().getSimpleName());
                if (state instanceof NoCreditState) {
                    System.out.println("Drücken Sie C um eine Münze einzuwerfen.");
                    String input = scanner.nextLine().toUpperCase();
                    if (input.equals("C")) {
                        insertCoin();
                    } else {
                        System.out.println("Ungültige Eingabe.");
                    }
                } else if (state instanceof ReadyState) {
                    System.out.println("Drücken Sie S, um das Spiel zu starten.");
                    String input = scanner.nextLine().toUpperCase();
                    if (input.equals("S")) {
                        play();
                        break; // Beendet die Schleife, wenn das Spiel gestartet wird
                    } else {
                        System.out.println("Ungültige Eingabe. Drücken Sie S, um das Spiel zu starten.");
                    }
                }
            }
        }
    }

}