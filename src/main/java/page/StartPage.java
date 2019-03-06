package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    public StartPage openPage()
    {
        open("/");
        return this;
    }
    public ResultPage findText(String text){
        $(By.name("q")).setValue(text).pressEnter();
        return  page(ResultPage.class);
    }

}
