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

    // DBMS tables
    // (Таблицы СУБД)
    Traders traders;
    ShareRates shareRates;
    Shares shares;
    TraderShareActions traderShareActions;

    // Connects to the database
    // (Соединяет с БД)
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Initializes by default, without deleting the database file
    // (Инициализирует по умолчанию, без удаления файла БД)
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        this(false);
    }

    public StockExchangeDB(boolean renew) throws SQLException, ClassNotFoundException {
        if(renew) {
            DeleteDbFiles.execute(DB_DIR, DB_FILE, false);
        }

        // Checks if a JDBC driver is available to work with the database
        // (Проверяем наличие JDBC драйвера для работы с БД)
        Class.forName(DB_DRIVER);

        traders = new Traders();
        shares = new Shares();
        shareRates = new ShareRates();
        traderShareActions = new TraderShareActions();
    }

    // Creates all tables, constraints and foreign keys
    // (Создаёт все таблиц, ограничения и внешние ключи)
    public void createTablesAndForeignKeys() throws SQLException {
        shares.createTable();
        shareRates.createTable();
        traders.createTable();
        traderShareActions.createTable();

        traderShareActions.createExtraConstraints();
        shares.createExtraConstraints();

        shareRates.createForeignKeys();
        traderShareActions.createForeignKeys();
    }

    public static void main(String[] args) {
        try {
            StockExchangeDB stockExchangeDB = new StockExchangeDB(true);
            stockExchangeDB.createTablesAndForeignKeys();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }
}
