package com.skilldistillery.jets;

public class BomberJet extends JetImpl implements CargoCarrier, Fight {
	private boolean isLoaded = false;

	public boolean isLoaded() {
		return isLoaded;
	}

	public BomberJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public void loadCargo() {

		System.out.println(this.getClass().getSimpleName() + " " + this.getModel() + "'s Bomb fully loaded!");
		isLoaded = true;

	}

	@Override
	public void Fight() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getModel() + " is droping Bomb!");
	}
}
