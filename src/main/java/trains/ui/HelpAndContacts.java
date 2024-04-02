package trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HelpAndContacts {


    public static class AboutOyster {

        public static final Target TFLApp = Target.the("Help about the TFL App").located(By.linkText("Contact us about Oyster"));
    }
}
