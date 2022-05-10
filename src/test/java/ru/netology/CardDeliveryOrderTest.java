package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryOrderTest {

    @BeforeEach
    public void openPage() {
        open("http://localhost:9999/");
    }

    
    @Test
    public void shouldValidValue() {
        Configuration.timeout = 15000;
        $("[placeholder='Город']").setValue("Мос");
        $(".menu-item__control").click();
//        $(".calendar-input__native-control").setValue("13.05.2022");
        $("[name='name']").setValue("Виктор Валуев");
        $("[name='phone']").setValue("+79879879877");
        $(".checkbox__box").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible);
    }
}
