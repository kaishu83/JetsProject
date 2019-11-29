package com.skilldistillery.jets;

public abstract class Jet {
	// TODO Auto-generated constructor stub

	// F I E L D
	private String model;
	private double speed;
	private int range;
	private long price;

	// C O N S T R U CT O R

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

//M E T H O R D

	public int fly() {
		int minutes = (int) (this.range / this.speed * 60);
		System.out.println(this.getClass().getSimpleName() + " " + this.model + " is taking off and can fly " + minutes
				+ " minutes");
		return minutes;
	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
