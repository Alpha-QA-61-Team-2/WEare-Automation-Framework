package wearetests.enums;

import wearetests.core.WEareBaseWebTest;

import java.util.Random;

public enum RandomDataType {
    USERNAME, EMAIL;

    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generate(RandomDataType type) {
        Random random = new Random();
        switch (type) {
            case USERNAME:
                return "user" + randomString(random, ALPHABETS, 8);
            case EMAIL:
                String username = "user" + randomString(random, ALPHABETS, 8);
                return username + "@example.com";
            default:
                throw new IllegalArgumentException("Unsupported RandomDataType: " + type);
        }
    }

    private static String randomString(Random random, String source, int length) {
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(source.charAt(random.nextInt(source.length())));
        }
        return result.toString();
    }
}
