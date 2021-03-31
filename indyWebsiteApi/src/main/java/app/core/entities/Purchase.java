package app.core.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private User user;
    private LocalDateTime wiredate;
    private String acc;
    private String status;
    private String tracking;
    private String shipping;
    @JsonIgnore
    @OneToMany(mappedBy="purchase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseEntry> entries;
    
    public Purchase() {
	}
    
	public Purchase(User user, LocalDateTime wiredate, String acc, String status, String tracking, String shipping) {
		this.user = user;
		this.wiredate = wiredate;
		this.acc = acc;
		this.status = status;
		this.tracking = tracking;
		this.shipping = shipping;
	}

	public Purchase(int id, User user, LocalDateTime wiredate, String acc, String status, String tracking,
			String shipping) {
		this.id = id;
		this.user = user;
		this.wiredate = wiredate;
		this.acc = acc;
		this.status = status;
		this.tracking = tracking;
		this.shipping = shipping;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getWiredate() {
		return wiredate;
	}

	public void setWiredate(LocalDateTime wiredate) {
		this.wiredate = wiredate;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public List<PurchaseEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<PurchaseEntry> entries) {
		this.entries = entries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Purchase other = (Purchase) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", user=" + user + ", wiredate=" + wiredate + ", acc=" + acc + ", status="
				+ status + ", tracking=" + tracking + ", shipping=" + shipping + "]";
	}

	
    
}
