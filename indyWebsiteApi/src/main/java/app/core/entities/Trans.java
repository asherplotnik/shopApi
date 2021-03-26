package app.core.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trans {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int qty;
	private boolean inorout;
	private LocalDate transdate;
	private String note;
	private int orderid;
	@ManyToOne
	private Stock stock;
	
	public Trans() {
	}

	public Trans(Integer id, int qty, boolean inorout, LocalDate transdate, String note, int orderid) {
		this.id = id;
		this.qty = qty;
		this.inorout = inorout;
		this.transdate = transdate;
		this.note = note;
		this.orderid = orderid;
	}

	public Trans(int qty, boolean inorout, LocalDate transdate, String note, int orderid) {
		this.qty = qty;
		this.inorout = inorout;
		this.transdate = transdate;
		this.note = note;
		this.orderid = orderid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getTransdate() {
		return transdate;
	}

	public void setTransdate(LocalDate transdate) {
		this.transdate = transdate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (inorout ? 1231 : 1237);
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + orderid;
		result = prime * result + qty;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((transdate == null) ? 0 : transdate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trans other = (Trans) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inorout != other.inorout)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (orderid != other.orderid)
			return false;
		if (qty != other.qty)
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (transdate == null) {
			if (other.transdate != null)
				return false;
		} else if (!transdate.equals(other.transdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trans [id=" + id + ", qty=" + qty + ", inorout=" + inorout + ", transdate=" + transdate + ", note="
				+ note + ", orderid=" + orderid + ", stock=" + stock + "]";
	}
	
	
	
}
