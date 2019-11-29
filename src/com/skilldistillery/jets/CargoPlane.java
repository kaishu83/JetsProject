package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {
	protected boolean isLoaded;

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		isLoaded = false;
	}

	@Override
	public void loadCargo() {

		System.out.println(this.getClass().getSimpleName() + " " + this.getModel() + " loaded and its speed and range"
				+ "reduced by 20%!");
		this.setSpeed(this.getSpeed() * 0.8);
		this.setRange((int) (this.getRange() * 0.8));
		isLoaded = true;
	}

	public boolean isLoaded() {
		return isLoaded;
	}

}
