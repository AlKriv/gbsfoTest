package testAPI;

import model.User;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseApiTest {

    private User user;
    private User userShipNext;
    private String url;
    private String urlShipNext;

    public BaseApiTest() {

        this.urlShipNext = "https://testing.shipnext.com";
        this.url="url";

        this.user=new User();
        this.user.setLogin("any");
        this.user.setPassword("any");

        this.userShipNext=new User();
        this.userShipNext.setLogin("dert@i.ua");
        this.userShipNext.setPassword("qwerty");

    }

    public String getUrl() {
        return url;
    }

    public String getUrlShipNext() {
        return urlShipNext;
    }

    public User getUser() {
        return user;
    }

    public User getUserShipNext() {
        return userShipNext;
    }

    @BeforeSuite
    public void BeforeSuite() {
        baseUrl = "";
    }
}
