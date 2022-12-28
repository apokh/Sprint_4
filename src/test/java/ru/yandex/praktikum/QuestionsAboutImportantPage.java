package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// POM для блока "Вопросы о важном"
public class QuestionsAboutImportantPage {
    private WebDriver driver;

    // блок с вопросами
    private By questions = By.xpath(".//div[@class = 'accordion']");

    public QuestionsAboutImportantPage (WebDriver driver) {
        this.driver = driver;
    }

    // кликнуть по кнопке с вопросом
    public void clickByButtonFirst(int i) {
        WebElement element = driver.findElement(questions);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        String xPathQuestion = "//div[" + i + "]/div[@class = 'accordion__heading']/div[@class = 'accordion__button']";
        driver.findElement(questions).findElement(By.xpath(xPathQuestion)).click();
    }

    // получить статус отображаемости ответа (0 - скрыт, 1 - отображается)
    public boolean displayStateAnswer (int i) {
        String xPathAnswer = "//div[" + i + "]/div[@class = 'accordion__panel']";
        return driver.findElement(questions).findElement(By.xpath(xPathAnswer)).isDisplayed();
    }

    // вернуть текст вопроса
    public String getQuestionText (int i) {
        String xPathQuestion = "//div[" + i + "]/div[@class = 'accordion__heading']/div[@class = 'accordion__button']";
        return driver.findElement(questions).findElement(By.xpath(xPathQuestion)).getText();
    }

    // вернуть текст ответа
    public String getAnswerText (int i) {
        String xPathAnswerText = "//div[" + i + "]/div[@class = 'accordion__panel']/p";
        return driver.findElement(questions).findElement(By.xpath(xPathAnswerText)).getText();
    }

}