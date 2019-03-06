package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomeGBSFO {
    public SelenideElement getMail() {
        return $(By.className("item_mail"));
    }
}
