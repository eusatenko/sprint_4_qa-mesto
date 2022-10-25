import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPageMesto;
import pages.LoginPageMesto;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class PraktikumTestCheckEmailInHeader {
    private WebDriver driver;

    @Test
    public void checkEmailInHeader() {

        driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);

        // выполни авторизацию
        String email = "sirigij514@24rumen.com";
        String password = "Qwerty123";
        // передавай эти переменные внутрь метода
        objLoginPage.login(email, password);

        // создай объект класса заголовка приложения
        HeaderPageMesto objHeaderPage = new HeaderPageMesto(driver);
        // дождись загрузки заголовка
        objHeaderPage.waitForLoadHeader();
        // получи текст элемента в заголовке
        String headerEmail = objHeaderPage.emailInHeader();
        // сделай проверку, что полученное значение совпадает с email
        assertThat(headerEmail, is(email));
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
