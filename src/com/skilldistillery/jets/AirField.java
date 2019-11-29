package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> jets = new ArrayList<Jet>();
	private String file;

	public AirField() {
		file = "Jets.txt";
		jets = getJets(file);
	}

	public List<Jet> getJets(String file) {
		List<String> jetStringList = null;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String lineString;
			String[] fieldString;

			try {
				while ((lineString = bf.readLine()) != null) {
					fieldString = lineString.split("\t");
					String type = fieldString[0];
					String model = fieldString[1];
					double speed = Double.parseDouble(fieldString[2]);
					int range = Integer.parseInt(fieldString[3]);
					long price = Long.parseLong(fieldString[4]);
					if (type.equals("SpyJet")) {
						Jet jet = new SpyJet(model, speed, range, price);
						jets.add(jet);
					} else if (type.equals("FightJet")) {
						Jet jet = new FightJet(model, speed, range, price);
						jets.add(jet);
					} else if (type.equals("CargoPlane")) {
						Jet jet = new CargoPlane(model, speed, range, price);
						jets.add(jet);
					} else if (type.equals("CrewJet")) {
						Jet jet = new CrewJet(model, speed, range, price);
						jets.add(jet);
					} else if (type.equals("BomberJet")) {
						Jet jet = new BomberJet(model, speed, range, price);
						jets.add(jet);
					}

				}
				bf.close();
				return jets;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

	public void PrintFleet() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}

	}

	public void flyAll() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public Jet Fastest() {
		Jet jetFastest = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getSpeed() > jetFastest.getSpeed()) {
				jetFastest = jet;
			}
		}
		return jetFastest;
	}

	public Jet LongestRange() {
		Jet jetLongestRange = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > jetLongestRange.getRange()) {
				jetLongestRange = jet;
			}
		}
		return jetLongestRange;
	}

	public void loadAll() {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				if (!((CargoPlane) jet).isLoaded()) {
					((CargoPlane) jet).loadCargo();
				} else
					System.out.println(jet.getClass().getSimpleName() + " " + jet.getModel() + " already loaded!");
			} else if (jet instanceof BomberJet) {
				if (!((BomberJet) jet).isLoaded()) {
					((BomberJet) jet).loadCargo();
				} else
					System.out.println(jet.getClass().getSimpleName() + " " + jet.getModel() + " already loaded!");
			}

		}
	}

	public void fightAll() {
		for (Jet jet : jets) {
			if (jet instanceof Fight) {
				((Fight) jet).Fight();

			}
		}

	}

//	public static void main(String[] args) {
//		AirField af = new AirField();
//		System.out.println(af.jets.size());
//		af.flyAll();
//
//	}

	public void AddJet(Scanner input) {
		System.out.println("What type of jet do you like to add?");
		System.out.println("1. Cargo Plane");
		System.out.println("2. Bomber Jet");
		System.out.println("3. Fight Jet");
		System.out.println("4. Spy Jet");
		System.out.println("5. Crew Jet");
		try {
			String type = input.next();

			System.out.println("What the model of your jet?");
			String model = input.next();
			System.out.println("What the speed of your jet");
			double speed = input.nextDouble();
			System.out.println("What the range of your jet");
			int range = input.nextInt();
			System.out.println("What's your price of jet");
			long price = input.nextLong();
			Jet newJet = null;

			switch (type) {
				case "1":
					newJet = new CargoPlane(model, speed, range, price);
					break;
				case "2":
					newJet = new BomberJet(model, speed, range, price);
					break;
				case "3":
					newJet = new FightJet(model, speed, range, price);
					break;
				case "4":
					newJet = new SpyJet(model, speed, range, price);
					break;
				case "5":
					newJet = new CrewJet(model, speed, range, price);
					break;
				default:
			}

			jets.add(newJet);
			System.out.println("Your jet created!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void DeleteJet(Scanner input) {
		PrintFleet();
		boolean b = false;
		System.out.println("Please enter the \"MODEL\" of the jet your want to remove");
		String modelDel = input.next();
		for (int i = 0; i < jets.size(); i++) {

			if (jets.get(i).getModel().equals(modelDel)) {
				System.out.println("Deleting jet: " + jets.get(i));
				jets.remove(i);
				b = true;
			}
		}
		if (b == false)
			System.out.println("No such model exit, please try again");

	}

}
