package app.core.util;
import java.io.Serializable;

public class TransactionForm  implements Serializable{
	public TransactionForm() {
	}
	private static final long serialVersionUID = 1L;
	private int id;
	private String variation;
	private int qty;
	private boolean inorout;
	private String note;
	private String code;
	public String getVariation() {
		return variation;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public boolean isInorout() {
		return inorout;
	}
	public void setInorout(boolean inorout) {
		this.inorout = inorout;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
