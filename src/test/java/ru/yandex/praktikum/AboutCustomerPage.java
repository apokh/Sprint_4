package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// POM для страницы оформления заказа "Для кого самокат"
public class AboutCustomerPage {
    private WebDriver driver;

    // поле "Имя"
    private By inputName = By.xpath(".//input[@placeholder = '* Имя']");

    // поле "Фамилия"
    private By inputFamilyName = By.xpath(".//input[@placeholder = '* Фамилия']");

    // поле "Адрес"
    private By inputAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // поле "Станция метро"
    private By inputMetroStage = By.xpath(".//div[@class = 'select-search']");

    // выпадающий список станций метро
    private By itemMetroStage = By.xpath(".//div[@class = 'select-search__select']");

    // поле "Телефон"
    private By inputPhoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // кнопка "Далее"
    private By buttonNext = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Далее']");

    public AboutCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setFamilyName(String familyName) {
        driver.findElement(inputFamilyName).sendKeys(familyName);
    }

    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void setMetroStage(String metroStage) {
        driver.findElement(inputMetroStage).click();
        driver.findElement(itemMetroStage).findElement(By.xpath(".//*[text() = '" + metroStage + "']")).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    public void clickButtonNext() {
        WebElement element = driver.findElement(buttonNext);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttonNext).click();
    }
}
