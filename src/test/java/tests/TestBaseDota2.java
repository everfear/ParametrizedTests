package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseDota2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.dota2.com/home";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void setUp() {
        open("");
    }

    @AfterEach
    void afterEach()
    {
        closeWebDriver();
    }
}