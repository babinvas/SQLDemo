package babinvas.repository;

import babinvas.StockExchangeDB;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// The service parent class, which contains the implementation of common actions for all tables
// (Сервисный родительский класс, куда вынесена реализация общих действий для всех таблиц)
public class BaseTable implements Closeable {
	// The JDBC connection to work with a table
	// (JDBC-соединение для работы с таблицей)
	Connection connection;

	// The table name
	// (Имя таблицы)
	String tableName;

	// For a real table, its name is passed to the constructor
	// (Для реальной таблицы пердаём в конструктор её имя)
	public BaseTable(String tableName) throws SQLException {
		this.tableName = tableName;
		this.connection = StockExchangeDB.getConnection();
	}

	public void close() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Ошибка закрытия SQL соединения!");
		}
	}

	// Executes the SQL command without parameters in the DBMS,
	// and after it is finished, send a message to the console
	// (Выполнить SQL команду без параметров в СУБД, по завершению выдать сообщение в консоль)
	void executeSqlStatement(String sql, String description) throws SQLException {
		// Reopens (if inactive) the connection to the DBMS
		// (Преоткрывает (если оно неактивно) соединение с СУБД)
		reopenConnection();

		// Creates a statement for executing sql commands
		// (Создаёт statement для выполнения sql-команд)
		Statement statement = connection.createStatement();

		// Executes the statement-sql command
		// (Выполняет statement - sql команду)
		statement.execute(sql);

		// Closes the statement to commit changes to the DBMS
		// (Закрывает statement для фиксации изменений в СУБД)
		statement.close();

		if (description != null) {
			System.out.println(description);
		}
	}

	void executeSqlStatement(String sql) throws SQLException {
		executeSqlStatement(sql, null);
	}

	// Activates connections with the DBMS, if it is not active
	// (Активизирует соединения с СУБД, если оно не активно)
	void reopenConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = StockExchangeDB.getConnection();
		}
	}
}
