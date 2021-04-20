package app.core.util;

import java.util.List;

import app.core.entities.Purchase;
import app.core.entities.PurchaseEntry;

public class CheckoutPayload {
	public Purchase purchase;
	public List<PurchaseEntry> entries;
}
