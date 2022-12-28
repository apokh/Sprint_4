package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

// проверка позитивного сценария заказа
@RunWith(Parameterized.class)
public class CheckPositiveCaseOrder {
    String placeStartButton;
    String customerName;
    String familyName;
    String metroStage;
    String address;
    String phoneNumber;
    String startDate;
    String durationTime;
    String colour;
    String comment;

    public CheckPositiveCaseOrder(String placeStartButton, String customerName, String familyName, String address,
                                  String metroStage, String phoneNumber, String startDate, String durationTime,
                                  String colour, String comment) {
        this.placeStartButton = placeStartButton;
        this.customerName = customerName;
        this.familyName = familyName;
        this.address = address;
        this.metroStage = metroStage;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.durationTime = durationTime;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
            {"Head", "Василий", "Пупкин", "Мытищи, 100500", "Цветной бульвар", "89991427884", "28", "сутки", "чёрный жемчуг", "жду сердечно"},
            {"Foot", "Арсений", "Пяткин", "Замкадье, 300", "Красные Ворота", "89934569833", "30", "трое суток", "серая безысходность", ""},
            {"Head", "Вениамин", "Масюткин", "Красная Площадь, 1", "Лубянка", "89004599801", "26", "двое суток", "чёрный жемчуг", "AQA one love"}
        };
    }

    // в Firefox тесты проходят успешно
    @Test
    public void checkPositiveCaseOrder() {
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.startApp();
        mainPage.startOrder(placeStartButton);
        AboutCustomerPage aboutCustomerPage = new AboutCustomerPage(driver);
        aboutCustomerPage.setInputName(customerName);
        aboutCustomerPage.setFamilyName(familyName);
        aboutCustomerPage.setAddress(address);
        aboutCustomerPage.setMetroStage(metroStage);
        aboutCustomerPage.setPhoneNumber(phoneNumber);
        aboutCustomerPage.clickButtonNext();
        TimeAndSubjectOrderPage timeAndSubjectOrderPage = new TimeAndSubjectOrderPage(driver);
        timeAndSubjectOrderPage.setStartDate(startDate);
        timeAndSubjectOrderPage.setDurationTime(durationTime);
        timeAndSubjectOrderPage.chooseColour(colour);
        timeAndSubjectOrderPage.setComment(comment);
        timeAndSubjectOrderPage.clickButtonNext();
        ConfirmModalPage confirmModalPage = new ConfirmModalPage(driver);
        confirmModalPage.sayYes();
        assertTrue("Не отображается окно 'Заказ оформлен'",confirmModalPage.successState());

        driver.quit();
    }

}
