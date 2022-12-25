package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// POM для страницы оформления заказа "Про аренду"
public class TimeAndSubjectOrderPage {
    private WebDriver driver;

    // поле "Когда привезти самокат"
    private By inputStartDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    private By itemStartDate = By.xpath(".//div[@class = 'react-datepicker__month-container']");

    // поле "Срок аренды"
    private By controlDurationTime = By.xpath(".//div[@class = 'Dropdown-control']");

    // выпадающий список вариантов сроков аренды
    private By itemDurationTime = By.xpath(".//div[@class = 'Dropdown-menu']");

    // чекбокс "Цвет самоката - чёрный жемчуг"
    private By colourBlack = By.id("black");

    // чекбокс "Цвет самоката - серая безысходность"
    private By colourGrey = By.id("grey");

    // поле "Комментарий для курьера"
    private By commentInput = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // кнопка "Заказать"
    private By buttonNext = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");


    public TimeAndSubjectOrderPage (WebDriver driver) {
        this.driver = driver;
    }

    public void setStartDate(String startDate) {
        WebElement element = driver.findElement(inputStartDate);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(inputStartDate).click();
        driver.findElement(itemStartDate).findElement(By.xpath("//div[text() = '" + startDate + "']")).click();
    }

    public void setDurationTime(String durationTime) {
        driver.findElement(controlDurationTime).click();
        WebElement element = driver.findElement(itemDurationTime);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(itemDurationTime).findElement(By.xpath(".//*[text() = '" + durationTime + "']")).click();
    }

    public void chooseColour(String colour) {
        if (colour.equals("чёрный жемчуг")) {
            driver.findElement(colourBlack).click();
        } else driver.findElement(colourGrey).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }
}
