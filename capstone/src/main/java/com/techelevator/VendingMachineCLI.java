package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;



public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT,MAIN_MENU_OPTION_SALES_REPORT  };

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
		Inventory inventory = new Inventory();
		Map<String, Product> inventoryMap = inventory.readFile();
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			Customer customer = new Customer();

			CoinBank coinBank = new CoinBank();

			String filePath = "Log.txt";

			File logFile = new File(filePath);


			double amountToDeposit = 0;

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
//				Map<Integer, Product> inventoryMap = inventory.readFile();
				inventory.displayItems(inventoryMap);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//				Customer customer = new Customer();
				Scanner userInput = new Scanner(System.in);
				Product product = new Product();
				while (true) {
					String purchaseChoice = (String) menu.getChoiceFromPurchaseMenuOptions(PURCHASE_MENU_OPTIONS, customer);
					if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_FEED_MONEY)) {
						System.out.println("Please deposit money in whole dollar amounts: ");
						/*Scanner userInput = new Scanner(System.in);*/
						amountToDeposit = Double.parseDouble(userInput.nextLine());
						customer.feedMoney(amountToDeposit);
						// Do we need to have a userInput.close() ??
					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_SELECT_PRODUCT)) {
						//Select product method
						product = customer.selectProduct(inventoryMap, customer.getMoneyProvided(), userInput,customer);

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION)) {
							//receive change, money provided to zero, update coinbank balance
						customer.finishTransaction(product,customer,coinBank);
						writeDataToFile(logFile, customer);
						// return to main menu
						break;
					}
				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				break;
			}else if (choice.equals(MAIN_MENU_OPTION_SALES_REPORT)){
				// print salesReport
				generateSalesReport(customer);
				System.out.println("hello");

			}

		}
	}


	// create method for audit
	public void writeDataToFile(File logFile, Customer customer){
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))){
			for (AuditLog log : customer.auditLogs){
				writer.println(log.printInLog());
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}


	// create method for print sales report
	public void generateSalesReport(Customer customer){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
		Date time = Calendar.getInstance().getTime();
		String reportFilePath = "C:/Users/Student/workspace/module-1-capstone-team-5/capstone";
		try {
			String newFileName;
			newFileName = dateFormat.format(time) + " Sales report.txt" ;
			File newFile = new File(reportFilePath, newFileName);
			newFile.createNewFile();

			// add info in each report file
			try (PrintWriter writer = new PrintWriter(newFile)){
				for (SalesReport item : customer.salesReport){
					writer.println(item.printInReport());
				}
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}


	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();


	}
}
