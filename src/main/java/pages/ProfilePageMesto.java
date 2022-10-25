package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageMesto {
    private WebDriver driver;
    // создай локатор для поля «Занятие» в профиле пользователя
    private By activity = By.id("owner-description");
    // создай локатор для кнопки «Сохранить» в профиле пользователя
    //private By save = By.className("button popup__button");

    public ProfilePageMesto (WebDriver driver){
        this.driver = driver;
    }

    // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра

    public void setActivity(String changed) {
        //Assert.assertTrue(driver.findElement(activity).isEnabled());
        driver.findElement(activity).clear();
        driver.findElement(activity).sendKeys(changed);
    }


    // метод для нажатия на кнопку сохранения профиля
    /*public void clickSaveButtonInProfile() {
        driver.findElement(save).click();
    }*/
}
