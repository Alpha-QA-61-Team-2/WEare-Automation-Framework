package wearetests.enums;

public enum TestData {
    USERNAME("Selen"),
    EMAIL("zelen@abv.com"),
    PASSWORD("123123"),
    CONFIRM_PASSWORD("123123");

    TestData(String propName) {
        value = propName;
    }

    final String value;

    public String getValue() {
        return value;
    }
}
