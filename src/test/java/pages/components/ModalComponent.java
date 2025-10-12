package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {
    private SelenideElement modalHeader = $(".modal-content #example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive"),
            closeButton = $("#closeLargeModal"),
            header = $("h1");

    public ModalComponent checkModalIsOpen() {
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ModalComponent checkModalIsNotOpen() {
        modalHeader.shouldNotBe(visible);
        return this;
    }

    public ModalComponent checkResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public ModalComponent closeModal() {
        closeButton.click();
        header.shouldHave(text("Practice Form"));
        return this;
    }
}
