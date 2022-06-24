package com.revature.models;

public class Offers {
	private int offerId;
	private String status;
	private int itemId;
	private int amount;
	private int userId;
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", status=" + status + ", itemId=" + itemId + ", amount=" + amount
				+ ", userId=" + userId + "]";
	}
	
	

}
