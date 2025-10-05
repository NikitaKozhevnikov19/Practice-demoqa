import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JunitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void FormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Kozhevnikov");
        $("#userEmail").setValue("kozherka2@gamil.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("images/12.jpg");
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        String[] expectedTexts = {
                "Nikita Kozhevnikov",
                "kozherka2@gamil.com",
                "Male",
                "9999999999",
                "19 January,2001",
                "Maths",
                "Sports",
                "12.jpg",
                "Some address",
                "NCR Delhi"
        };
        for (String text : expectedTexts) {$("div.table-responsive").shouldHave(text(text));
        }

    }
}
