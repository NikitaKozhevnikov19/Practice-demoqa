import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JunitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Kozhevnikov");
        $("#userEmail").setValue("kozherka2@gamil.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images/12.jpg");
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Nikita Kozhevnikov"));
        $(".modal-body").shouldHave(text("kozherka2@gamil.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9999999999"));
        $(".modal-body").shouldHave(text("19 January,2001"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("12.jpg"));
        $(".modal-body").shouldHave(text("Some address"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        }

    }

