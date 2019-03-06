package testAPI;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class apiTest extends BaseApiTest {

    @Test
    public void login() {
        /*
        3.1 Написать тест который будет отправлять POST запрос на "URL/api/auth/login"
         и в зависимости от того какой статус код вернется решать тест прошел или нет.
        POST, application/json
        login = any
        password = any
        */
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body("{\"login\":\"" + getUser().getLogin() + "\",\"password\":\"" + getUser().getPassword() + "\"}");
        Response response = request.post(getUrl() + "/api/auth/login");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //working example
    @Test
    public void loginShipNext() {
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body("{\"email\":\"" + getUserShipNext().getLogin() + "\",\"password\":\"" + getUserShipNext().getPassword() + "\"}");
        Response response = request.post(getUrlShipNext() + "/api/v1/auth/sign_in");

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
