package babinvas.repository;

import java.sql.SQLException;

//
// (Операции с таблицами)
public interface TableOperations {
	//
	// (Создание таблицы)
	void createTable() throws SQLException;
	//
	// (Создание связей между таблицами)
	void createForeignKeys() throws SQLException;
	//
	// (Создание дополнительных правил для значений полей таблиц)
	void createExtraConstraints() throws SQLException;
}
