package babinvas.model;

import java.math.BigDecimal;

public class Share extends BaseModel {
	// SQL table fields and their corresponding model fields, SQL data types
	// (Поля SQL таблицы и соответствующие им поля модели, типы данных SQL)

	// Name
	// (Наименование)
	private String name;
	// Initial price
	// (Начальная цена)
	private BigDecimal startPrice;
	// Probability of changing course (in percent)
	// (Вероятность смены курса (в процентах)
	private int changeProbability;
	// Maximum fluctuation (in percent) of the share price as a result of trading
	// (Максимальное колебание (в процентах) стоимости акции в результате торгов)
	private int delta;

	public Share() {
	}

	public Share(long id, String name, BigDecimal startPrice, int changeProbability, int delta) {
		super(id);
		this.name = name;
		this.startPrice = startPrice;
		this.changeProbability = changeProbability;
		this.delta = delta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(BigDecimal startPrice) {
		this.startPrice = startPrice;
	}

	public int getChangeProbability() {
		return changeProbability;
	}

	public void setChangeProbability(int changeProbability) {
		this.changeProbability = changeProbability;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}
}
