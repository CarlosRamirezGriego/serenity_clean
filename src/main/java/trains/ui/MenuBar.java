package trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public enum MenuBar {
    STATUS_UPDATES (By.linkText("Status updates")),
    HELP_AND_CONTACT (By.linkText("Help & contacts"));

    By byLocator;

    MenuBar(By selector)
    {
        this.byLocator = selector;
    }

    public Target menuOption()
    {
        return Target.the(this.name()).located(this.byLocator);
    }

}
