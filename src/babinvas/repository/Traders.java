package babinvas.repository;

import java.sql.SQLException;

public class Traders extends BaseTable implements TableOperations {
	public Traders() throws SQLException {
		super("traders");
	}

	@Override
	public void createTable() throws SQLException {
		super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traders(" +
						"id BIGINT AUTO_INCREASE PRIMARY KEY," +
						"name VARCHAR(255) NOT NULL," +
						"freqPerDay INTEGER NOT NULL," +
						"cash DECIMAL(15,2) NOT NULL," +
						"tradingMethod INTEGER NOT NULL)",
				"Создана таблица " + tableName);
	}

	@Override
	public void createForeignKeys() throws SQLException {
	}

	@Override
	public void createExtraConstraints() throws SQLException {
	}
}
