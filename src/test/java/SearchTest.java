import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";

    }
        @Test
        void searchTest() {

            //Откройте страницу Selenide в Github
            open("/selenide/selenide");
            //Перейдите в раздел Wiki проекта
            $("#wiki-tab").click();
            //Убедитесь, что в списке страниц есть страница (Pages) SoftAssertions.
            $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
            //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
            $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
            $(".gh-header-title").shouldHave(text("SoftAssertions"));
            $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                    "class Tests {\n" +
                    "  @Test\n" +
                    "  void test() {\n" +
                    "    Configuration.assertionMode = SOFT;\n" +
                    "    open(\"page.html\");\n" +
                    "\n" +
                    "    $(\"#first\").should(visible).click();\n" +
                    "    $(\"#second\").should(visible).click();\n" +
                    "  }\n" +
                    "}"));
        }

    }