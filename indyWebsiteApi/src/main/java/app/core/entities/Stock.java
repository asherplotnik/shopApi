package app.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String variation;
	private int qty;
	private String img;
	@ManyToOne
	private Item item;

	public Stock() {
	}

	public Stock(Integer id, String variation, int qty, String img) {
		this.id = id;
		this.variation = variation;
		this.qty = qty;
		this.img = img;
	}

	public Stock(String variation, int qty, String img) {
		this.variation = variation;
		this.qty = qty;
		this.img = img;
	}

	public Integer getId() {
		return id;
	}
	
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVariation() {
		return variation;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + qty;
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
		Stock other = (Stock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (qty != other.qty)
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
		return "Entry [id=" + id + ", variation=" + variation + ", qty=" + qty + ", img=" + img + "]";
	}

	
}
