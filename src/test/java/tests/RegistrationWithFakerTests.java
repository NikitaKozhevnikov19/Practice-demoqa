
package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalComponent;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalComponent modalComponent = new ModalComponent();

    @Test
    void successfulRegistrationTest() {


        String firstName = TestData.getFirstNameFaker();
        String lastName = TestData.getLastNameFaker();
        String userEmail = TestData.getUserEmailFaker();
        String userGender = TestData.getUserGenderFaker();
        String userNumber = TestData.getUserPhoneNumbFaker();
        String day = TestData.getDay();
        String month = TestData.getMonth();
        String year = TestData.getYear();
        String userAddress = TestData.getUserAddressFaker();
        String userSubjects = TestData.getUserSubjects();
        String userHobbies = TestData.getUserHobbies();
        String userPicture = TestData.getUserPicture();
        String userState = TestData.getUserState();
        String userCity = TestData.getUserCity(userState);


        registrationPage.openPage()
                .checkTitle()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(userSubjects)
                .setHobby(userHobbies)
                .setPicture(userPicture)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submitForm();


        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", userSubjects)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", userPicture)
                .checkResult("Address", userAddress)
                .checkResult("State and City", userState + " " + userCity)
                .closeModal();
    }
}
