package wearetests.enums;

import java.util.Random;
import java.util.UUID;

public enum TestData {

    ADMIN_PROFILE("admina"),
    USER_1("olga"),
    USER_2("martin"),
    USER_3("milko"),
    VALID_USER_ID("43"),
    USERNAME_CREATE("user"),
    EMAIL("rndm@abv.com"),
    PASSWORD("123456"),
    CONFIRM_PASSWORD("123456"),
    WRONG_PASSWORD("wrong"),
    FIRST_NAME("Test"),
    LAST_NAME("Testov"),
    UPDATED_EMAIL("upd@abc.ag");


    TestData(String propName) {
        value = propName;
    }

    final String value;

    public String getValue() {
        return value;
    }


    //todo maybe remove below
    @Override
    public String toString() {
        return value;
    }

    /*public static final int USERNAME_LENGTH = 3;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";*/

    /*private static String generateUniqueUsername() {
        StringBuilder username = new StringBuilder(USERNAME_LENGTH);
        Random random = new Random(System.currentTimeMillis());  // Seed the random generator for more randomness

        for (int i = 0; i < USERNAME_LENGTH; i++) {
            int randomIndex = random.nextInt(ALPHABET.length());
            username.append(ALPHABET.charAt(randomIndex));
        }

        return username.toString();
    }*/
}
