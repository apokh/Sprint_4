package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// POM для страницы оформления заказа aka "Для кого самокат"
public class About {
    private WebDriver driver;

    // поле "Имя"
    private By inputName = By.xpath(".//input[@placeholder = '* Имя']");

    // поле "Фамилия"
    private By inputLastName = By.xpath(".//input[@placeholder = '* Фамилия']");

    // поле "Адрес"
    private By inputAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // поле "Станция метро"
    private By inputLastName = By.xpath(".//input[@class = 'select-search__input']");

    // поле "Телефон"
    private By inputLastName = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // кнопка "Далее"
    private By inputLastName = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Далее']");
}
