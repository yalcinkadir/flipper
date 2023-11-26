package controller;
import model.FlipperElement;

public class ResetVisitor implements FlipperElementVisitor {
    @Override
    public void visit(FlipperElement element) {
        // Reset-Logik für jedes Element
        System.out.println("Resetting " + element.getClass().getSimpleName());
    }
}