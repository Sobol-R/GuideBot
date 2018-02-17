
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import java.sql.*;

import static org.postgresql.core.SqlCommandType.SELECT;


public class Main {

    static String url = "jdbc:postgresql://127.0.0.1:5432/GuideBot";
    static String name = "postgres";
    static String password = "RostGPS";
    static Connection connection = null;
    static float latitude;
    static float longitude;
    static String sight;
    static String description;

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
             Statement statement;
             statement = connection.createStatement();
             /*ResultSet rs = statement.executeQuery("SELECT * FROM public.location");
             //ResultSetMetaData rsmd = rs.getMetaData();
             while (rs.next()) {
                 latitude = Float.valueOf(rs.getString(1));
                 longitude = Float.valueOf(rs.getString(2));
                 sight = rs.getString(3);
                 description = rs.getString(4);
             }
             ResultSet rs1 = statement.executeQuery("SELECT * FROM public.test");
             while (rs1.next()) {
                 System.out.println(latitude = Float.valueOf(rs1.getString(1)));
                 System.out.println(longitude = Float.valueOf(rs1.getString(2)));
             }*/
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
