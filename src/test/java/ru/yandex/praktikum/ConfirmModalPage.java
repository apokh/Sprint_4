package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// POM для модального окна подтверждения заказа
public class ConfirmModalPage {
    private WebDriver driver;

    // кнопка "Да"
    private By buttonOk = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");

    // окно "Заказ оформлен"
    private By modalSuccess = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");

    public ConfirmModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sayYes() {
        driver.findElement(buttonOk).click();
    }

    public boolean successState() {
        return driver.findElement(modalSuccess).isDisplayed();
    }
}
