package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
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
}
