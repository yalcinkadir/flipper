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
        float xPosBumper = 50;
        float yPosBumper = 100;
        float xPosTarget = 200;
        float yPosTarget = 150;
        int points = 10;

        elements.add(new Bumper(xPosBumper, yPosBumper, points));
        elements.add(new Target(xPosTarget, yPosTarget, points));
        this.state = new NoCreditState(this);
        DisplayFactory factory = new AsciiDisplayFactory();
        this.display = factory.createDisplay();
    }

    public void checkEndCondition() {
        if (ballsLeft == 0) {
            endGame();
        }
    }

    public void startGame() {
        float startX = 0;
        float startY = 0;
        float startVx = 1;
        float startVy = 0.1f;
        float ballRadius = 10.0f;

        ball = new Ball(startX, startY, startVx, startVy, ballRadius);
        isGameRunning = true;

        System.out.println("Das Spiel hat begonnen!");
        gameLoop();
    }

    private void endGame() {
        System.out.println("Spiel beendet. Dein Punktestand: " + GameDirector.getInstance().getScore());
        askForNewGame();
        isGameRunning = false;
    }

    private void askForNewGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Möchtest du noch einmal spielen? (ja/nein)");
            String antwort = scanner.nextLine().toLowerCase();

            if ("ja".equals(antwort)) {
                restartGame();
            } else {
                System.out.println("Danke fürs Spielen!");
                System.exit(0);
            }
        }
    }

    private void restartGame() {
        Flipper flipper = new Flipper();
        flipper.showStatusAndAskForCoin();
    }

    private boolean isGameRunning = false;
    private float maxY = 7;

    public void gameLoop() {
        while (isGameRunning) {
            ball.updatePosition();
            for (FlipperElement element : elements) {
                checkCollision(element);
            }
            updateDisplay();
            System.out.println("Ballposition: " + ball.getX() + ", " + ball.getY());
            System.out.println("Ballsleft: " + ballsLeft);

            if (ball.getY() > maxY) {
                ballsLeft--;
                System.out.println("Ball verloren. Verbleibende Bälle: " + ballsLeft);

            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ballsLeft <= 0) {
                    isGameRunning = false;
                    endGame();
                    break;
                } else {
                    resetBall();
                }
            }
        }
    }

    private void resetBall() {
        float startX = 0;
        float startY = 0;
        float startVx = 1;
        float startVy = 1;
        float ballRadius = 10.0f;
        ball = new Ball(startX, startY, startVx, startVy, ballRadius);
    }

    public void checkCollision(FlipperElement element) {
        float distanceX = Math.abs(ball.getX() - element.getX());
        float distanceY = Math.abs(ball.getY() - element.getY());
        float elementRadius = element instanceof Target ? ((Target) element).getRadius() : 10.0f;
        float maxDistance = ball.getRadius() + elementRadius;

        if (distanceX < maxDistance && distanceY < maxDistance) {
            ball.bounceOff();
            element.hit();
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
            System.out.println(
                    "Punktestand: " + GameDirector.getInstance().getScore() + " | Verbleibende Bälle: " + ballsLeft);
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
            while (true) {
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
                        break;
                    } else {
                        System.out.println("Ungültige Eingabe. Drücken Sie S, um das Spiel zu starten.");
                    }
                }
            }
        }
    }

}