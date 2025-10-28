package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {


    private final SelenideElement yearPicker = $(".react-datepicker__year-select");
    private final SelenideElement monthPicker = $(".react-datepicker__month-select");
    private final ElementsCollection dayDatePicker =
            $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year) {
        yearPicker.selectOption(year);
        monthPicker.selectOption(month);

        dayDatePicker.shouldBe(sizeGreaterThan(0));

        dayDatePicker
                .findBy(Condition.text(String.valueOf(Integer.parseInt(day))))
                .shouldBe(Condition.visible)
                .click();
    }
}
