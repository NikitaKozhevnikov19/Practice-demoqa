package tests;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.List;

public class TestData {

    static Faker faker = new Faker(new Locale("en-GB"));
    static Random random = new Random();

    public static String getFirstNameFaker() {
        return faker.name().firstName();
    }

    public static String getLastNameFaker() {
        return faker.name().lastName();
    }

    public static String getUserEmailFaker() {
        return faker.internet().emailAddress();
    }

    public static String getUserGenderFaker() {
        List<String> genders = List.of("Male", "Female", "Other");
        return genders.get(random.nextInt(genders.size()));
    }

    public static String getUserPhoneNumbFaker() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getMonth() {
        List<String> months = List.of(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        );
        return months.get(random.nextInt(months.size()));
    }

    public static String getYear() {
        return String.valueOf(faker.number().numberBetween(1980, 2005));
    }

    public static String getUserAddressFaker() {
        return faker.address().fullAddress();
    }

    public static String getUserSubjects() {
        List<String> subjects = List.of("Maths", "English", "History", "Chemistry", "Physics");
        return subjects.get(random.nextInt(subjects.size()));
    }

    public static String getUserHobbies() {
        List<String> hobbies = List.of("Sports", "Reading", "Music");
        return hobbies.get(random.nextInt(hobbies.size()));
    }


    public static String getUserPicture() {
        return "12.jpg";
    }

    public static String getUserState() {
        List<String> states = List.of("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return states.get(random.nextInt(states.size()));
    }

    public static String getUserCity(String state) {
        switch (state) {
            case "NCR":
                return List.of("Delhi", "Gurgaon", "Noida").get(random.nextInt(3));
            case "Uttar Pradesh":
                return List.of("Agra", "Lucknow", "Merrut").get(random.nextInt(3));
            case "Haryana":
                return List.of("Karnal", "Panipat").get(random.nextInt(2));
            case "Rajasthan":
                return List.of("Jaipur", "Jaiselmer").get(random.nextInt(2));
            default:
                return "Delhi";
        }
    }
}
