import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PraktikumParametrizedAuth {
    //Добавь необходимые поля
    private final String email;
    private final String password;
    private final boolean isLoggedIn;


    public PraktikumParametrizedAuth(String email, String password, boolean isLoggedIn) {
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        //Сгенерируй тестовые данные (свою учётку и несколько случайных)
        return new Object[][] {
                { "sirigij514@24rumen.com", "Qwerty123", true},
                { "myMail@yandex.ru", "12345", false},
                { "yourMail@yandex.ru", "54321", false},
        };
    }

    @Test
    public void loginTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("auth-form__button")).click();
        if (isLoggedIn) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
        }
        assertEquals(isLoggedIn, driver.findElements(By.cssSelector(".profile__image")).size() != 0);
        driver.quit();
    }
}