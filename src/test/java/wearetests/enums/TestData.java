package wearetests.enums;

import java.util.Random;
import java.util.UUID;

public enum TestData {

    ADMIN_PROFILE("admina"),
    USER_1("olga"),
    USER_2("martin"),
    USER_3("milko"),
    VALID_USER_ID("43"),
    USERNAME_CREATE("ussser"),
    EMAIL("rndm@abv.com"),
    //todo agree what common password are we using
    PASSWORD("123456"),
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

}
