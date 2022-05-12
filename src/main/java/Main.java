import common.enums.Display;
import common.enums.View;
import common.interfaces.Displayable;
import factory.ViewFactory;


public class Main {
    public static void main(String[] args) {
        Displayable displayable = ViewFactory.getView(View.START_VIEW);
        displayable.display(Display.MAIN);
    }
}
