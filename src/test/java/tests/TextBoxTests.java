package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Nikita")
                .setUserEmail("kozherka2@gmail.com")
                .setUserCurrentAddress("Some address")
                .setUserPermanentAddress("Other address")
                .submitForm()
                .checkResult("name", "Nikita")
                .checkResult("email", "kozherka2@gmail.com")
                .checkResult("currentAddress", "Some address")
                .checkResult("permanentAddress", "Other address");
    }
}
