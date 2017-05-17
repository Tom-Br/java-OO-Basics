package edu.ap.be;

import java.time.LocalDate;

public class Auto extends Voertuig implements Gemotoriseerd{
	
	private LocalDate inschrijfDatum;
	private double uitstoot;

	public Auto(String model, String merk, double co2Uitstoot, LocalDate inschrijfDatum) {
		super(model, merk);
		this.uitstoot = co2Uitstoot;
		this.inschrijfDatum = inschrijfDatum;
	}
	
	public LocalDate getInschrijfDatum() {
		return inschrijfDatum;
	}
	
	@Override
	public double getCOUitstoot() {
		return uitstoot;
	}

	@Override
	public boolean isBestuurbaarDoorKinderen() {
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " - date: " + inschrijfDatum;
	}
	
	

}
