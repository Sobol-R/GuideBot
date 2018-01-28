
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import java.sql.*;


public class Main {

    static String url = "jdbc:postgresql://127.0.0.1:5432/GuideBot";
    static String name = "postgres";
    static String password = "RostGPS";
    static Connection connection = null;

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("драйвер подключен");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found.");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");
         try {
             connection = DriverManager.getConnection(url, name, password);
             Statement statement = null;
             statement = connection.createStatement();

         } catch (SQLException e) {
             System.out.println("Connection Failed");
             e.printStackTrace();
             return;
         }
        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();
        Bot bot = new Bot();
        try {
            botapi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
