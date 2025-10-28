package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestsWIthAnnotations {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        open("https://demoqa.com/login");
    }

    @CsvSource({
            "user1, wrongPass1",
            "user2, wrongPass2",
            "user3, wrongPass3"
    })
    @ParameterizedTest(name = "Попытка входа пользователя {0} с паролем {1} на demoqa.com")
    @Tag("BLOCKER")
    void loginWithInvalidUsers(String username, String password) {
        $("#userName").setValue(username);
        $("#password").setValue(password);
        $("#login").click();
        $("#name").shouldHave(text("Invalid username or password!"));
    }


    static Stream<Arguments> provideUsers() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("nbuUser1", "wrongPass1"),
                org.junit.jupiter.params.provider.Arguments.of("nbuUser2", "wrongPass2"),
                org.junit.jupiter.params.provider.Arguments.of("nbuUser3", "wrongPass3")
        );
    }

    @ParameterizedTest(name = "Пользователь {0} с паролем {1}")
    @MethodSource("provideUsers")
    void loginWithMethodSource(String username, String password) {
        open("https://demoqa.com/login");

        $("#userName").setValue(username);
        $("#password").setValue(password);
        $("#login").click();

        $("#name").shouldHave(text("Invalid username or password!"));
    }


    enum TestUsers {
        USER1("nbuUser1"),
        USER2("nbuUser2"),
        USER3("nbuUser3");

        private final String username;

        TestUsers(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    @ParameterizedTest(name = "Попытка входа с пользователем {0}")
    @EnumSource(TestUsers.class)
    void loginWithEnum(TestUsers user) {
        open("https://demoqa.com/login");
        $("#userName").setValue(user.getUsername());
        $("#password").setValue("wrongPass");
        $("#login").click();

        $("#name").shouldHave(text("Invalid username or password!"));
    }
}





