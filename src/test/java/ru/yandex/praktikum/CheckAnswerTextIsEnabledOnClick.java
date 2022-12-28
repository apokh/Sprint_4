package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CheckAnswerTextIsEnabledOnClick {
    int num;
    String question;
    String answer;

    public CheckAnswerTextIsEnabledOnClick(int num, String question, String answer) {
        this.num = num;
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getButtonParameters() {
        return new Object[][] {
                {1,"Сколько это стоит? И как оплатить?",
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2,"Хочу сразу несколько самокатов! Так можно?",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3,"Как рассчитывается время аренды?",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4,"Можно ли заказать самокат прямо на сегодня?",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5,"Можно ли продлить заказ или вернуть самокат раньше?",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6,"Вы привозите зарядку вместе с самокатом?",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {7,"Можно ли отменить заказ?",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {8,"Я живу за МКАДом, привезёте?",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    // в формулировке задачи "когда нажимаешь на стрелочку, открывается соответствующий текст" - достаточно ёмкая проверка,
    // поэтому сделала лучше больше, чем меньше
    // несколько проверок в один тест - плохо, но в данном случае показалось разделять не целесообразно
    @Test
    public void answerTextIsEnabledOnClick() {
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.startApp();
        QuestionsAboutImportantPage questionsAboutImportantPage = new QuestionsAboutImportantPage(driver);
        questionsAboutImportantPage.clickByButtonFirst(num);
        assertTrue("Ответ не отображается", questionsAboutImportantPage.displayStateAnswer(num));
        assertEquals("Текст ответа не соответствует требованиям",answer,questionsAboutImportantPage.getAnswerText(num));
        assertEquals("Текст вопроса не соответствует требованиям",question,questionsAboutImportantPage.getQuestionText(num));

        driver.quit();
    }

}