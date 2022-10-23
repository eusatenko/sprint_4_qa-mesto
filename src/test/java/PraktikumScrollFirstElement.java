import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PraktikumScrollFirstElement {
    private WebDriver driver;

    @Test
    public void test() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию
        driver.findElement(By.id("email")).sendKeys("sirigij514@24rumen.com");
        driver.findElement(By.id("password")).sendKeys("Qwerty123");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("places__list")));
        // Найди карточку контента и сделай скролл до неё
        WebElement element = driver.findElement(By.cssSelector(".places__item"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
