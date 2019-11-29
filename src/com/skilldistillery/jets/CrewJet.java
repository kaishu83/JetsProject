package com.skilldistillery.jets;

public class CrewJet extends CargoPlane implements CargoCarrier {

	public CrewJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadCargo() {

		System.out.println(this.getClass().getSimpleName() + " " + this.getModel()
				+ " loaded with crew and its speed and range" + " reduced by 10%!");
		this.setSpeed(this.getSpeed() * 0.9);
		this.setRange((int) (this.getRange() * 0.9));
		this.isLoaded = true;
	}

}
