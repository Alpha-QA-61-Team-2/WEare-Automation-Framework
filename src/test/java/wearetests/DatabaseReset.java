package wearetests;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseReset {

    /**
     * IMPORTANT! use your individual parameters:
     */
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";


    //if we need to run it manually, we can do it from here:
    public static void main(String[] args) {
        resetDatabase();
    }


    //the method for resetting the db:
    public static void resetDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            System.out.println("connection is successful!");

            InputStream inputStream = DatabaseReset.class.getClassLoader().getResourceAsStream("reset.sql");
            if (inputStream == null) {
                throw new RuntimeException("SQL file not found in resources!");
            }

            StringBuilder sqlScript = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sqlScript.append(line).append("\n");
                }
            }

            for (String sql : sqlScript.toString().split(";")) {
                if (!sql.trim().isEmpty()) {
                    statement.execute(sql.trim());
                }
            }

            System.out.println("Database has been reset using reset.sql!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
