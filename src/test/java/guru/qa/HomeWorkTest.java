package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import guru.qa.domain.HeaderItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTest {

    @ValueSource(strings = {
            "qa_guru_12_5_junit",
            "qa_guru_demoqa_2",
            "qa_guru_git"
    })
    @ParameterizedTest(name = "Checking available repo on my account {0}")
    void openMyRepo(String testData) {
//        Pre-condition
        Selenide.open("https://github.com/aleksandrtretyakov");
//        Steps
        $(byText("Repositories")).click();
        $(byText(testData)).click();
//        Expected result
        $(".css-truncate-target").parent().shouldBe(visible);

    }

    @CsvSource({
            "Choose your tool, Find the right tool"
    })
    @ParameterizedTest(name = "When we click on {0}, we should see {1} text")
    void checkingOtherSite(String name, String titleText) {
//        Pre-condition
        open("https://www.jetbrains.com/");
//        Steps
        $(byText(name)).click();
//        Expected result
        $(byText(titleText)).shouldHave(text(titleText));
    }

    static Stream<Arguments> methodSourceBookPartsTest() {
        return Stream.of(
                Arguments.of("War and Peace", List.of(1, 2)),
                Arguments.of("The Silent Don", List.of(1, 2, 3, 4))
        );
    }

    @MethodSource("methodSourceBookPartsTest")
    @ParameterizedTest
    void methodSourceExampleTest(String bookName, List<Integer> parts) {
        System.out.println(bookName + " and list of parts: " + parts);
    }

    @EnumSource(HeaderItem.class)
    @ParameterizedTest()
    void checkingSiteHeader(HeaderItem testData) {
        open("https://www.ozon.ru/");
        $(withTextCaseInsensitive(testData.ruName)).shouldBe(visible).click();
    }

}
