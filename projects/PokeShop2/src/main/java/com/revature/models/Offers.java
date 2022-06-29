package com.revature.models;

public class Offers {
	private int offerId;
	private String status;
	private int pId;
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
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
//	public int getItemId() {
//		return pId;
//	}
//	public void setItemId(int itemId) {
//		this.pId = itemId;
//	}
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
		return "Offers [offerId=" + offerId + ", status=" + status + ", itemId=" + pId + ", amount=" + amount
				+ ", userId=" + userId + "]";
	}
	
	

}
