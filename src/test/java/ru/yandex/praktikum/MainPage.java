package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// POM для главной страницы
public class MainPage {
    private WebDriver driver;

    // кнопка "Заказать" вверху страницы
    private By buttonMakeOrderHead = By.xpath(".//button[@class = 'Button_Button__ra12g' and text() = 'Заказать']");

    // кнопка "Заказать" внизу страницы
    private By buttonMakeOrderFoot = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startApp() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // сделать заказ через верхнюю (Head) или нижнюю (Foot) кнопку "Заказать"
    public void startOrder(String place) {
        By button;
        if (place.equals("Head")) {
            button = buttonMakeOrderHead;
        } else button = buttonMakeOrderFoot;

        WebElement element = driver.findElement(button);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();

    }
}
