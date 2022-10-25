import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import com.example.pagewidgets.LoginPageMestoSelenium;
import org.junit.Test;
import org.junit.After;
import pages.LoginPageMesto;

//Программа должна проверить страницу авторизации Mesto: ввести почту и пароль, затем кликнуть по кнопке входа в приложение.

public class PraktikumTestLoginWithPOM {

    private WebDriver driver;

    @Test
    public void loginTest() {

//        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // создать объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        // выполнить авторизацию
        objLoginPage.login("sirigij514@24rumen.com",
                "Qwerty123");

    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
