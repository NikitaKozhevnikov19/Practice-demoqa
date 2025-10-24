package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalComponent;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalComponent modalComponent = new ModalComponent();

    @Test
    void successfulRegistrationTest() {
        TestData data = new TestData(); // новый объект с Faker

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setPhoneNumber(data.phoneNumber)
                .setDateOfBirth(data.day, data.month, data.year)
                .setSubject(data.subject)
                .setHobby(data.hobby)
                .setPicture(data.avatar)
                .setAddress(data.streetAddress)
                .setState(data.state)
                .setCity(data.city)
                .submitForm();

        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phoneNumber)
                .checkResult("Date of Birth", data.birthDate)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.avatar)
                .checkResult("Address", data.streetAddress)
                .checkResult("State and City", data.stateAndCity)
                .closeModal();
    }
}
