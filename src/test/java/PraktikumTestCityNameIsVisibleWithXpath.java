import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(Parameterized.class)
public class PraktikumTestCityNameIsVisibleWithXpath {
    //Добавь необходимые поля
    private final String cityName;
    private final boolean isVisible;

    public PraktikumTestCityNameIsVisibleWithXpath(String cityName, boolean isVisible) {
        this.cityName = cityName;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][] {
                { "Москва", true},
                { "Санкт-Петербург", true},
        };
    }

    @Test
    public void citiesTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию. Укажи email и пароль своей учетной записи
        driver.findElement(By.id("email")).sendKeys("sirigij514@24rumen.com");
        driver.findElement(By.id("password")).sendKeys("Qwerty123");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));

        // Найди карточку города по его названию

        List<WebElement> elements = driver.findElements(By.xpath(".//li[contains(text(), cityName)]"));

        // Проверь, что нашёлся хотя бы один нужный элемент
        assertEquals(isVisible, elements.size() != 0);
        driver.quit();
    }
}