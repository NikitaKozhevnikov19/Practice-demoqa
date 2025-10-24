package tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();


    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String gender = faker.options().option("Male", "Female", "Other");
    public final String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public final String streetAddress = faker.address().streetAddress();
    public final String subject = faker.options().option("Maths", "Hindi", "Biology", "Accounting", "Chemistry");
    public final String hobby = faker.options().option("Sports", "Reading", "Music");
    public final String avatar = faker.options().option("12.jpg");


    public final String day = String.format("%02d", faker.number().numberBetween(1, 28));
    public final String month = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public final String year = String.valueOf(faker.number().numberBetween(1920, 2024));
    public final String birthDate = day + " " + month + "," + year;


    public final String state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana");
    public final String city = getCityForState(state);
    public final String stateAndCity = state + " " + city;

    private String getCityForState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Delhi";
        };
    }
}