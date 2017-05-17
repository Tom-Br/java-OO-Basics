package edu.ap.be;

public class Step extends Voertuig {

	public Step(String model, String merk) {
		super(model, merk);
	}

	@Override
	public boolean isBestuurbaarDoorKinderen() {
		return true;
	}
}
