package babinvas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchangeDB {
    // Constant declaration block
    // (Блок объявления констант)
    public static final String DB_URL = "jdbc:h2:/G:/Java Projects/SQLDemo/db/stockExchange";
    public static final String DB_DRIVER = "org.h2.Driver";

    public static void main(String[] args) {
        try {
            // Checks if a JDBC driver is available to work with the database
            // (Проверяем наличие JDBC драйвера для работы с БД)
            Class.forName(DB_DRIVER);

            // Connecting to the database
            // (Соединение с БД)
            Connection connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connection to the DBMS is made.\n" +
                    "(Соединение с СУБД выполнено).");

            // Disconnecting from the database
            // (Отключение от БД)
            connection.close();
            System.out.println("Disconnection from the DBMS is done.\n" +
                    "(Отключение от СУБД выполнено).");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }
}
