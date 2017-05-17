package edu.ap.be;

public class ElektrischeFiets extends Fiets implements Gemotoriseerd {
	
	private int range;
	private double uitstoot = 0;

	public ElektrischeFiets(String model, String merk, byte aantalVersnellingen, int range) {
		super(model, merk, aantalVersnellingen);
		this.range = range;
	}

	@Override
	public boolean isBestuurbaarDoorKinderen() {
		return false;
	}

	@Override
	public double getCOUitstoot() {
		return uitstoot;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - range: " + range + " km";
	}
	
	

}
