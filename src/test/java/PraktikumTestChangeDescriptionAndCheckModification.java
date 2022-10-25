import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePageMesto;
import pages.LoginPageMesto;
import pages.ProfilePageMesto;
import io.github.bonigarcia.wdm.WebDriverManager;


public class PraktikumTestChangeDescriptionAndCheckModification {
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkActivity() throws InterruptedException {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        // выполни авторизацию
        objLoginPage.login("sirigij514@24rumen.com",
                "Qwerty123");

        // создай объект класса главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);
        // дождись загрузки данных профиля на главной странице
        objHomePage.waitForLoadProfileData();

        // кликни на кнопку редактирования профиля
        objHomePage.clickEditProfileButton();

        // создай объект класса для поп-апа редактирования профиля
        ProfilePageMesto objProfilePage = new ProfilePageMesto(driver);

        // это переменная со значением, которое надо ввести в поле «Занятие»
        String newActivity = "Тестировщик";
        // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение
       new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("owner-description")));

        objProfilePage.setActivity(newActivity);
        // сохрани изменения в профиле
        objProfilePage.clickSaveButtonInProfile();

        // проверь, что поле «Занятие» на основной странице поменяло значение на новое
        objHomePage.waitForChangedActivity(newActivity);
    }


//    @After
//    public void teardown() {
//        // Закрой браузер
//        driver.quit();
//    }
}
