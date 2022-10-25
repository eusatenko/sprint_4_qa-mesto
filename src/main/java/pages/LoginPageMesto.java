package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class LoginPageMesto {

    private WebDriver driver;
    // локатор поля ввода «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки входа в приложение
    private By signInButton = By.className("auth-form__button");

    // добавь здесь локатор для кнопки «Регистрация»
    private By registrationButton = By.className("header__auth-link");

    // конструктор класса
    public LoginPageMesto(WebDriver driver){
        this.driver = driver;
    }
    // метод проверяет, активна ли кнопка «Войти»
    public boolean checkSignInIsEnabled() {
        return driver.findElement(signInButton).isEnabled();
    }
    // метод кликает по кнопке «Войти»
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    // метод кликает по кнопке «Регистрация»
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    // метод проверяет текст кнопки «Регистрация»
    public void checkTextRegistrationButton() {
        assertEquals("Регистрация", driver.findElement(registrationButton).getText(), true);
    }


    // метод заполняет поля «Email»
    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    // метод заполненяет поля «Пароль»
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    // это и есть шаг
    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }
}
