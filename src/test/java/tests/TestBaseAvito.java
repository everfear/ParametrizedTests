package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBaseAvito {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.avito.ru/";
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