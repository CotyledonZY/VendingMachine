package com.techelevator;

import com.techelevator.view.CoinBank;
import com.techelevator.view.Customer;
import com.techelevator.view.Inventory;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTIONS_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTIONS_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTIONS_FEED_MONEY, PURCHASE_MENU_OPTIONS_SELECT_PRODUCT, PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION};

	private Menu menu;
	// constructor
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			Inventory inventory = new Inventory();
			CoinBank coinBank = new CoinBank();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				inventory.readFile();
				inventory.displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				Customer customer = new Customer();
				Scanner userInput = new Scanner(System.in);
				while (true) {
					String purchaseChoice = (String) menu.getChoiceFromPurchaseMenuOptions(PURCHASE_MENU_OPTIONS, customer);
					if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_FEED_MONEY)) {
						System.out.println("Please deposit money in whole dollar amounts");
						/*Scanner userInput = new Scanner(System.in);*/
						double amountToDeposit = Double.parseDouble(userInput.nextLine());
						customer.feedMoney(amountToDeposit);
						// Do we need to have a userInput.close() ??
					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_SELECT_PRODUCT)) {
						//Select product method
						customer.selectProduct(inventory, customer.getMoneyProvided(), userInput);
					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION)) {
							//receive change, money provided to zero,
						// return to main menu
						break;
					}
				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				break;
			}
		}
	}




	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();


	}
}
