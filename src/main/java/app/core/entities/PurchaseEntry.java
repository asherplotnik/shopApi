package app.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseEntry {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Purchase purchase;
	private String code;
    private String variation;
    private int quantity;
    private double price;
	
    public PurchaseEntry() {
	}

	public PurchaseEntry(int id, Purchase purchase, String code, String variation, int quantity, double price) {
		this.id = id;
		this.purchase = purchase;
		this.code = code;
		this.variation = variation;
		this.quantity = quantity;
		this.price = price;
	}

	public PurchaseEntry(Purchase purchase, String code, String variation, int quantity, double price) {
		this.purchase = purchase;
		this.code = code;
		this.variation = variation;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getVariation() {
		return variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((variation == null) ? 0 : variation.hashCode());
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
		PurchaseEntry other = (PurchaseEntry) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (purchase == null) {
			if (other.purchase != null)
				return false;
		} else if (!purchase.equals(other.purchase))
			return false;
		if (quantity != other.quantity)
			return false;
		if (variation == null) {
			if (other.variation != null)
				return false;
		} else if (!variation.equals(other.variation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseEntry [id=" + id + ", purchase=" + purchase + ", code=" + code + ", variation=" + variation
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
    
    
}
