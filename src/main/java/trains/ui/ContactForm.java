package trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public enum ContactForm {
    TITLE (By.name("PersonalDetails.Title")),
    FIRST_NAME (By.name("PersonalDetails.FirstName")),
    LAST_NAME (By.name("PersonalDetails.LastName"));

    By byLocator;

    ContactForm(By selector)
    {
        this.byLocator = selector;
    }

    public Target formOption()
    {
        return Target.the(this.name()).located(this.byLocator);
    }
}
