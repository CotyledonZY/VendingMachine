package com.techelevator;

import com.techelevator.view.Inventory;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	// create a String PURCHASE_MENU_OPTIONS_FEED_MONEY,
	// PURCHASE_MENU_OPTIONS_SELECT PRODUCT,
	// PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION,
	// String[] PURCHASE_MENU_OPTIONS

	private Menu menu;
	// constructor
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			Inventory inventory = new Inventory();
			// CoinBank

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				inventory.displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				// CODE HERE - create string choiceFromPurchaseMenu

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
