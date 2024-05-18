package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AvitoWebTest extends TestBaseAvito {

    @ValueSource(strings = {"bmw", "audi"})
    @ParameterizedTest(name = "Поиск по {0} должен выдавать не пустой список результатов")
    @DisplayName("Поиск по марке авто должен выдавать не пустой список результатов")
    void searchResultShouldNotBeEmpty(String searchQuery) {

        $(".input-input-Zpzc1").setValue(searchQuery);
        $$("div.suggest-item-fsyRJ").findBy(text(searchQuery)).click();
        $$("div.items-items-kAJAg").shouldBe(sizeGreaterThan(0));
    }

    @CsvFileSource(resources = "/tests_data/searchResultShouldContainGearboxType")
    @ParameterizedTest(name = "Поиск по {0} должен выдавать результат с коробкой типа {1}")
    @DisplayName("Поиск по марке авто должен выдавать результат с типом трансмисии")
    void searchResultShouldContainGearboxType(String searchQuery, String gearboxType) {

        $(".input-input-Zpzc1").setValue(searchQuery);
        $$("div.suggest-item-fsyRJ").findBy(text(searchQuery)).click();
        $("div.items-items-kAJAg").shouldHave(text(gearboxType));
    }
}