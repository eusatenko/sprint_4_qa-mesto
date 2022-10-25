import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class From_driver {

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    private WebDriver driver;

    @Test
    public void testChangeImageProfile() {
        // Создаём драйвер для браузера Chrome
        // ChromeOptions options = new ChromeOptions(); // для тренажёра Практикума
        // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage"); // для тренажёра Практикума
        // driver = new ChromeDriver(options); // для тренажёра Практикума
        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию
        driver.findElement(By.id("email")).sendKeys("sirigij514@24rumen.com");
        driver.findElement(By.id("password")).sendKeys("Qwerty123");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        // Кликни по изображению профиля
        driver.findElement(By.className("profile__image")).click();
        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.id("owner-avatar")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png");
        // Сохрани новое изображение
        driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }



    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}