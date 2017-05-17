package edu.ap.be;

public class Fiets extends Voertuig {
	
	private byte aantalVersnellingen;
	
	public Fiets(String model, String merk) {
		this(model, merk, (byte)1);
	}

	public Fiets(String model, String merk, byte aantalVersnellingen) {
		super(model, merk);
		this.aantalVersnellingen = aantalVersnellingen;
	}
	

	@Override
	public boolean isBestuurbaarDoorKinderen() {
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - #v: " + aantalVersnellingen;
	}
	
	

}
