package babinvas;

import babinvas.repository.ShareRates;
import babinvas.repository.Shares;
import babinvas.repository.TraderShareActions;
import babinvas.repository.Traders;
import org.h2.tools.DeleteDbFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchangeDB {
    // Constant declaration block
    // (Блок объявления констант)
    public static final String DB_DIR = "G:/Java Projects/SQLDemo/db";
    public static final String DB_FILE = "stockExchange";
    public static final String DB_URL = "jdbc:h2:/" + DB_DIR + "/" + DB_FILE;
    public static final String DB_DRIVER = "org.h2.Driver";

    //
    // (Таблицы СУБД)
    Traders traders;
    ShareRates shareRates;
    Shares shares;
    TraderShareActions traderShareActions;

    //
    // (Получет новое соединение с БД)
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    //
    // (Инициализация по умолчанию, без удаления файла БД)
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        this(false);
    }

    //
    // (Инициализация)
    public StockExchangeDB(boolean renew) throws SQLException, ClassNotFoundException {
        if(renew) {
            DeleteDbFiles.execute(DB_DIR, DB_FILE, false);
        }

        Class.forName(DB_DRIVER);

        //
        // (Инициализируем таблицы)
        traders = new Traders();
        shares = new Shares();
        shareRates = new ShareRates();
        traderShareActions = new TraderShareActions();
    }

    //
    // (Создание всех таблиц и внешних ключей)
    public void createTablesAndForeignKeys() throws SQLException {
    }

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
