package trains;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import trains.ui.MenuBar;
import trains.ui.TFLHomePage;

public class SelectMenu {
    public static Performable option(MenuBar option)
    {
        return Click.on(option.menuOption());
    }
}
