package babinvas.model;

import java.time.LocalDateTime;

// The model of traders' operations on the stock exchange
// (Модель операций трейдеров на бирже)
public class TraderShareAction extends BaseModel {
	// Buying
	// (Покупка)
	public static final int OPERATION_BUY = 1;
	// Selling
	// (Продажа)
	public static final int OPERATION_SELL= 2;

	// Date and time of the transaction
	// (Дата и время совершения операции)
	private LocalDateTime operDate;
	// The operation (buy, sell)
	// (Операция (buy, sell)
	private int  operation;
	// The trader who made the operation
	// (Трейдер, совершивший операцию)
	private long trader;
	// Shares with which the transaction was made
	// (Акции, с которыми совершена операция)
	private long share;
	// Number of shares
	// (Количество акций)
	private long amount;

	public TraderShareAction() {
	}

	public TraderShareAction(long id, LocalDateTime operDate, int operation, long trader, long share, long amount) {
		super(id);
		this.operDate = operDate;
		this.operation = operation;
		this.trader = trader;
		this.share = share;
		this.amount = amount;
	}

	public LocalDateTime getOperDate() {
		return operDate;
	}

	public void setOperDate(LocalDateTime operDate) {
		this.operDate = operDate;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public long getTrader() {
		return trader;
	}

	public void setTrader(long trader) {
		this.trader = trader;
	}

	public long getShare() {
		return share;
	}

	public void setShare(long share) {
		this.share = share;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}
