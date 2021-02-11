package babinvas.model;

import java.math.BigDecimal;

// The trader model
// (Модель трейдера)
public class Trader extends BaseModel {
	// Sells all the shares and buys the cheapest ones
	// (Продаем все акции и закупаем самые дешевые)
	public static final int METHOD_SELL_ALL_BUY_CHEAP = 1;
	// Sells the most expensive shares and buys the cheapest ones
	// (Продаем самые дорогие и покупаем самые дешевые)
	public static final int METHOD_SELL_ALL_BUY_CHEAPO_SELL_EXPENSIVE_BUY_CHEAP = 2;
	// Sells and buys all randomly selected items
	// (Продаем и покупаем все случайно выбранного наименования)
	public static final int METHOD_SELL_ALL_BUY_CHEAP_SELL_RANDOM_BUY_RANDOM = 3;

	// The name of the trader
	// (Имя трейдера)
	private String name;
	// The frequency per day
	// (Частота в день)
	private int freqPerDay;
	// The amount
	// (Сумма)
	private BigDecimal cash;
	// The algorithm used by the trader
	// (Применяемый трейдером алгоритм)
	private int tradingMethod;

	public Trader() {
	}

	public Trader(long id, String name, int freqPerDay, BigDecimal cash, int tradingMethod) {
		super(id);
		this.name = name;
		this.freqPerDay = freqPerDay;
		this.cash = cash;
		this.tradingMethod = tradingMethod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFreqPerDay() {
		return freqPerDay;
	}

	public void setFreqPerDay(int freqPerDay) {
		this.freqPerDay = freqPerDay;
	}

	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public int getTradingMethod() {
		return tradingMethod;
	}

	public void setTradingMethod(int tradingMethod) {
		this.tradingMethod = tradingMethod;
	}
}
