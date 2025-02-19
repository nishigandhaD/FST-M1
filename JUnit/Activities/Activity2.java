package activities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import HandsOn.BankAccount;
import HandsOn.NotEnoughFundsException;

class Activity2 {

	@Test
	void notEnoughFunds() {
		BankAccount ba = new BankAccount(9);
		assertThrows(NotEnoughFundsException.class, ()->ba.withdraw(10),"Withdraw amount equals or less than balance");
	}
	
	@Test
	void enoughFunds() {
		BankAccount ba = new BankAccount(100);
		assertDoesNotThrow(()->ba.withdraw(100));
	}
}
