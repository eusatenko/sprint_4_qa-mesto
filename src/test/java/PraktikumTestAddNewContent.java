import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PraktikumTestAddNewContent {

    private WebDriver driver;

    @Test
    public void test() {
        // Создаём драйвер для браузера Chrome
       // ChromeOptions options = new ChromeOptions(); // для тренажёра Практикума
       // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage"); // для тренажёра Практикума
        driver = new ChromeDriver(); // для тренажёра Практикума  driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию
        driver.findElement(By.id("email")).sendKeys("sirigij514@24rumen.com");
        driver.findElement(By.id("password")).sendKeys("Qwerty123");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        // Кликни по кнопке добавления нового контента
        driver.findElement(By.className("profile__add-button")).click();
        // В поле названия введи Москва
        driver.findElement(By.name("name")).sendKeys("Москва");
        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.name("link")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenium.jpg");
        // Сохрани контент
        driver.findElement(By.xpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        // Дождись появления кнопки удаления карточки
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")));
        // Удали контент
        driver.findElement(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}