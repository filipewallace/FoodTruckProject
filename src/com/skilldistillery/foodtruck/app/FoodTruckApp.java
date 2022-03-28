package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;

import java.util.Scanner;

public class FoodTruckApp {

	private static final int MAX_TRUCKS = 5;
	FoodTruck[] fleet = new FoodTruck[MAX_TRUCKS];
	private int count = 0;

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		FoodTruckApp pleaseWork = new FoodTruckApp();
		System.out.println("Welcome to Food Truck hell");
		pleaseWork.go();
	}

	public void go() {
		String selection;

		do {
			menu1();
			selection = sc.nextLine();

			switch (selection) {
			case "1":
				if (count == fleet.length) {
					System.out.println("Can't hold any more trucks. Press any key to return to main menu: ");
					sc.nextLine();
					break;
				} else {
					newTruck(sc);
					break;
				}
			case "2":
				displayTrucks();
				System.out.println("Enter any key to return to main menu: ");
				sc.nextLine();
				System.out.println("");
				break;
			case "3":
				displayAverage();
				System.out.println("Enter any key to return to main menu: ");
				sc.nextLine();
				break;
			case "4":
				displayHighestRated();
				System.out.println("Enter any key to return to main menu: ");
				sc.nextLine();
				break;
			case "5":
				System.out.println("Thank you! Bye!");
				break;
			default:
				System.out.println("Error! Enter any key to return to main menu: ");
				sc.nextLine();
			}
		} while (!selection.equals("5"));

		sc.close();
	}

	private void menu1() {
		System.out.println("--------------------------------------------");
		System.out.println("1. Add new Food Truck");
		System.out.println("2. Show all Food Trucks");
		System.out.println("3. Show average rating for all Trucks");
		System.out.println("4. Show highest rated Truck");
		System.out.println("5. Quit");
		System.out.println("--------------------------------------------");
	}

	private void menu2() {
		System.out.println("--------------------------------------------");
		System.out.println("1. Add another Food Truck");
		System.out.println("2. Main menu");
		System.out.println("--------------------------------------------");
	}

	private void newTruck(Scanner sc) {
		int selection2;
		String name;
		String foodType;
		int rating;
		do {
			System.out.println("Enter name of food truck, or enter quit to return to the main menu: ");
			name = sc.nextLine();
			if (checkQuit(name)) {
				break;
			}

			System.out.println("What type of food does " + name + " serve?: ");
			foodType = sc.nextLine();

			System.out.print("What would you rate " + name + "?: ");
			rating = sc.nextInt();
			sc.nextLine();

			FoodTruck newTruck = new FoodTruck(name, foodType, rating);
			addTruck(newTruck);
			newTruck.setNextTruckID();

			if (count < fleet.length) {
				menu2();
				selection2 = sc.nextInt();
				sc.nextLine();
				switch (selection2) {
				case 1:
					continue;
				case 2:
					break;
				}
			} else {
				System.out.print("Can't add any more trucks. Enter any key to return to main menu: ");
				sc.nextLine();
				break;
			}
		} while (selection2 == 1);
	}

	private void addTruck(FoodTruck truck) {
		fleet[count] = truck;
		count++;
	}

	private void displayTrucks() {
		System.out.println("");
		for (FoodTruck truck : fleet) {
			if (truck != null) {
				System.out.println(truck.toString());
			}

		}
	}

	private void displayAverage() {
		double totalRatings = 0.0;
		double averageRating = 0.0;
		for (FoodTruck truck : fleet) {
			if (truck != null) {
				totalRatings += truck.getRating();
			}
		}
		averageRating = (totalRatings) / (count);
		System.out.println("Average rating for all food trucks is " + averageRating);

	}

	private void displayHighestRated() {
		int highest = 0;
		for (FoodTruck truck : fleet) {
			if (truck != null) {
				if (truck.getRating() > highest) {
					highest = truck.getRating();
				}
			}
		}
		for (FoodTruck truck : fleet) {
			if (truck != null) {
				if (truck.getRating() == highest) {
					System.out.println(truck.toString());
				}
			}
		}
	}

	boolean checkQuit(String name) {
		boolean result = false;
		switch (name) {
		case "quit":
		case "Quit":
			result = true;
			break;

		}

		return result;
	}
}