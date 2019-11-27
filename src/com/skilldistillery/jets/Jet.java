package com.skilldistillery.jets;

public abstract class Jet {
// F I E L D
	private String model;
	private double speed;
	private int range;
	private long price;

	
	
	
// C O N S T R U C T O R
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

}
