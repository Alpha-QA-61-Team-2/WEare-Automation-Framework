package wearetests.enums;

public enum TestData {
    USERNAME("boiko"),
    EMAIL("zelen@abv.com"),
    PASSWORD("123123"),
    CONFIRM_PASSWORD("123123"),
    FIRST_NAME("Test"),
    LAST_NAME("Testov");

    TestData(String propName) {
        value = propName;
    }

    final String value;

    public String getValue() {
        return value;
    }
}
