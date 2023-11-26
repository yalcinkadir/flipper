package controller;
import model.FlipperElement;

public interface FlipperElementVisitor {
    void visit(FlipperElement element);
}