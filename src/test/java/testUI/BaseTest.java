package testUI;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseTest {

    private String findText="gbsfo";
    // get/set
    public String getFindText() {
        return findText;
    }



    ///////////////


    @BeforeSuite
    public void beforeSuit(){
        baseUrl = "https://www.google.com";

    }
    @AfterTest
    public void afterTest(){
        WebDriverRunner.clearBrowserCache();
    }
}
