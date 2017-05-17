package edu.ap.be;

public abstract class Voertuig {
	
	private static int teller = 0;
	
	private int id;
	private String model, merk;

	public Voertuig(String model, String merk) {
		super();
		teller++;
		this.id = teller;
		this.model = model;
		this.merk = merk;
	}
	
	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getMerk() {
		return merk;
	}
	
	public abstract boolean isBestuurbaarDoorKinderen();

	@Override
	public String toString() {
		return "(" + id + ")" + " " + merk + " \'" + model + "\'"; 
		
	}
	
	

}
