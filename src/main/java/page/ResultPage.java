package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ResultPage {

    public ElementsCollection resultSearch()
    {
        return $$("#ires .g");
    }

    public HomeGBSFO getResultPage(String findStr){

        int size=resultSearch().size();
        for (int i=0; i<size;i++)
        {
            String checkStr =resultSearch().get(i).$(By.cssSelector("h3")).getText();
            if(checkStr.equalsIgnoreCase(findStr)){
                resultSearch().get(i).$(By.cssSelector("a")).sendKeys(Keys.CONTROL,Keys.SHIFT,Keys.ENTER);
            }
        }
        //переключаемся на новую вкладку
        ArrayList<String> tabs = new ArrayList<String> (getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
        ////////////////////////////////
        return page(HomeGBSFO.class);
    }

    //Menu Items
    public ResultPage clickTools(){
        $(By.xpath("//div[@role='navigation']/div/div/div/div[2]/a")).click();
        return this;
    }


    //Panel tools
    public SelenideElement getPeriod(){
      return   $(By.xpath("//div[@id='top_nav']/div/div/div[2]/div/div[3]"));
    }
    public ResultPage setOneHour(){
        getPeriod().click();
        $(By.xpath("//div[@id='top_nav']/div/div/div[2]/div//ul[@aria-expanded='true']//a")).shouldBe(Condition.visible).click();
        return this;
    }

}
