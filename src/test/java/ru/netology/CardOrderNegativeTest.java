package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CardOrderNegativeTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldReturnErrorMessageIfInvalidName() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Vladislav Kurbatov");
        $("[data-test-id=phone] input").setValue("+79685491213");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldReturnErrorMessageIfNameIsEmpty() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+79685491213");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldReturnErrorMessageIfInvalidTel() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Владислав Курбатов");
        $("[data-test-id=phone] input").setValue("79685491213");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldReturnErrorMessageIfTelIsEmpty() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Владислав Курбатов");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldReturnErrorMessageIfTelWithLetters() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Владислав Курбатов");
        $("[data-test-id=phone] input").setValue("abc");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldReturnErrorMessageIfCheckBoxIsEmpty() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Владислав Курбатов");
        $("[data-test-id=phone] input").setValue("+79685491213");
        $("[type=button]").click();
        $(".input_invalid .checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

    @Test
    public void shouldReturnErrorMessageIfAllIsEmpty() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("");
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}
