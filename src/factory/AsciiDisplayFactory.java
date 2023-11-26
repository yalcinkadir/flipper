package factory;
import view.AsciiDisplay;
import view.Display;
import view.DisplayFactory;

public class AsciiDisplayFactory implements DisplayFactory {
    @Override
    public Display createDisplay() {
        return new AsciiDisplay();
    }
}