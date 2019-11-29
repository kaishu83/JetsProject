package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApp {

	public static void main(String[] args) {

		JetsApp app = new JetsApp();
		app.run();

	}

	public void run() {
		Scanner input = new Scanner(System.in);
		AirField af = new AirField();
		int option = 0;
		try {
			do {
				printMenu();
				option = input.nextInt();
				switch (option) {
					case 1:
						af.PrintFleet();
						break;
					case 2:
						af.flyAll();
						break;
					case 3:
						System.out.println(af.Fastest());
						break;
					case 4:
						System.out.println(af.LongestRange());
						break;
					case 5:
						af.loadAll();
						break;
					case 6:
						af.fightAll();
						break;
					case 7:
						af.AddJet(input);
						break;
					case 8:
						af.DeleteJet(input);
						break;
					case 9:
						option = 9;
						System.out.println("GoodBye!");
						break;
					default:
						System.out.println("Wrong option, try again");

				}

			} while (option != 9);
		} catch (Exception e) {
			System.out.println(e);
		}
		input.close();
	}

	public void printMenu() {
		System.out.println("1. List fleet\n2. Fly all jets\n3. View fastest jet\n4. View jet with longest range\n"
				+ "5. Load all Cargo Jets\n6. Dogfight!\n7. Add a jet to Fleet\n8. Remove a jet from Fleet\n9. Quit");
		System.out.println("Please choose your option");
	}
}
