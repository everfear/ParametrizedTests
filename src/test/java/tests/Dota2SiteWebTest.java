package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tests.data.Language;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Dota2SiteWebTest extends TestBaseDota2 {

    @EnumSource(Language.class)
    @ParameterizedTest
    @DisplayName("На главой страничке можно сменить язык и будет корректное отображение")
    void siteShouldDisplayCorrectDataWhenLangIsChanged(Language language) {

        $("div.A5ZD2W_mb_zemISyBnEFl").click();
        $$("[class='Kd1K6wuv2y0Fwu75wjH_u']").find(text(language.name())).click();
        $("[class='_19K41n6aXl-qrrH1HwAJ_U']").shouldHave(text(language.description));
    }
}