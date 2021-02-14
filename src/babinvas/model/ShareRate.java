package babinvas.model;

import java.time.LocalDateTime;

// The class of share rates
// (Модель курсов акций)
public class ShareRate extends BaseModel{
	// The display time of the rate
	// (Время выставления курса)
	private LocalDateTime operDate;
	// The share for which the share rate is set
	// (Акция, для которой задается курс)
	private long share;
	// The share rate
	// (Курс акции)
	private double rate;

	public ShareRate() {
	}

	public ShareRate(long id, LocalDateTime operDate, long share, double rate) {
		super(id);
		this.operDate = operDate;
		this.share = share;
		this.rate = rate;
	}

	public LocalDateTime getOperDate() {
		return operDate;
	}

	public void setOperDate(LocalDateTime operDate) {
		this.operDate = operDate;
	}

	public long getShare() {
		return share;
	}

	public void setShare(long share) {
		this.share = share;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}
