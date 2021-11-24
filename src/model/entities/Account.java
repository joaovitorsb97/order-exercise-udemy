package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		
		if(withdrawLimit.equals(0.0)) {
			throw new DomainException("Withdraw limit cannot be 0 (zero).");
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		return "New balance: " + this.balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		if(balance == 0) {
			throw new DomainException("You don't have balance to withdraw.");
		}
		if(amount > withdrawLimit) {
			throw new DomainException("Withdraw amount surpass the withdraw limit.");
		}
		
	}
}
