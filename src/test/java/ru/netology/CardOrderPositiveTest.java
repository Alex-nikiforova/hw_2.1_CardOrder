package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardOrderPositiveTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldReturnSuccessfullyIfFullName() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Владислав Курбатов");
        $("[data-test-id=phone] input").setValue("+79685491213");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnSuccessfullyIfNameOfOneLetter() {

        $$(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Николай О");
        $("[data-test-id=phone] input").setValue("+79685491213");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnSuccessfullyIfNameWithHyphen() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Анна-Мария Славная");
        $("[data-test-id=phone] input").setValue("+79685491213");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
