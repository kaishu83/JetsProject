package com.skilldistillery.jets;

public class FightJet extends Jet implements Fight {

	public FightJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Fight() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getModel() + " is firing");
	}

}
