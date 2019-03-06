package testUI;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import page.HomeGBSFO;
import page.StartPage;

public class GoogleTest extends BaseTest {

    @Test(priority = 2)
    public void findPhraseTest() {
    /*
    1.1 Открыть google.com
    1.2 Сделать поиск по фразе “gbsfo”
    1.3 Среди всех результатов найти полное соответствие с “gbsfo”
    1.4 Открыть линку в новой Табе
    */
        new StartPage()
                .openPage()
                .findText(getFindText())
                .getResultPage(getFindText());
        new HomeGBSFO()
                .getMail().shouldBe(Condition.text(getFindText()));
    }

    @Test(priority = 1)
    public void useGoogleTool(){
    /*
    2.1 Открыть google.com
    2.2 Сделать поиск по фразе “gbsfo”
    2.3 Выбрать “инструменты” и внутри выбрать отображать данные только за последний час
    */
    new StartPage()
            .openPage()
            .findText(getFindText())
            .clickTools()
            .setOneHour()
            .getPeriod().shouldHave(Condition.matchesText("За час"));

    }
}
