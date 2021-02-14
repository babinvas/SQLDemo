package babinvas.repository;

import java.sql.SQLException;

public class TraderShareActions extends BaseTable implements TableOperations {
	public TraderShareActions() throws SQLException {
		super("trader_share_actions");
	}

	@Override
	public void createTable() throws SQLException {
		super.executeSqlStatement("CREATE TABLE IF NOT EXISTS trader_share_actions(" +
						"id BIGINT AUTO_INCREMENT PRIMARY KEY," +
						"operation INTEGER NOT NULL," +
						"trader INTEGER NOT NULL," +
						"share_rate INTEGER NOT NULL," +
						"amount BIGINT NOT NULL)",
				"Создана таблица " + tableName);
	}

	@Override
	public void createForeignKeys() throws SQLException {
		super.executeSqlStatement("ALTER TABLE trader_share_actions " +
						"ADD FOREIGN KEY (share_rate) " +
						"REFERENCES share_rates(id)",
				"Создан внешний ключ trader_share_actions.share -> shares.id");
	}

	@Override
	public void createExtraConstraints() throws SQLException {
	}
}
