package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalComponent modalComponent = new ModalComponent();

    @Test
    void formTest() {

        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Kozhevnikov")
                .setEmail("kozherka2@gamil.com")
                .setGender("Male")
                .setPhoneNumber("9999999999")
                .setDateOfBirth("19", "January", "2001")
                .setSubject("Maths")
                .setHobby("Sports")
                .setPicture("12.jpg")
                .setAddress("Some address")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();
        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Nikita Kozhevnikov")
                .checkResult("Student Email", "kozherka2@gamil.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Date of Birth", "19 January,2001")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "12.jpg")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "NCR Delhi")
                .closeModal();
    }

    @Test
    void fillMinimalFormTest() {
        registrationPage.openPage()
                .setFirstName("Nikita")
                .setLastName("Kozhevnikov")
                .setGender("Male")
                .setPhoneNumber("9999999999")
                .submitForm();
        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Nikita Kozhevnikov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .closeModal();
    }

    @Test
    void fillNegativeFormTest() {
        registrationPage.openPage()
                .submitForm()
                .checkValidation();
        modalComponent.checkModalIsNotOpen();
    }
}