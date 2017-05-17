package edu.ap.be;

public class Plaats {
	
	public enum Type{
		GROOT,
		KLEIN;
	}
	
	private Voertuig voertuig;
	private boolean bezet;
	private Type type;
	
	public Plaats(Type type) {
		super();
		this.bezet = false;
		this.type = type;
	}

	public boolean isBezet() {
		return bezet;
	}
	
	public Type getType() {
		return type;
	}
	
	public Voertuig getVoertuig() {
		return voertuig;
	}

	public void voertuigStallen(Voertuig voertuig) throws IllegalArgumentException{
		if(isBezet()){
			throw new IllegalArgumentException("Deze plaats is al bezet!");
		}
		else if(voertuig instanceof Gemotoriseerd && this.type == Type.KLEIN){
			throw new IllegalArgumentException("Dit is een kleine plaats. Geen gemotoriseerde voertuigen toegelaten!");
		}
		else{
			this.bezet = true;
			this.voertuig = voertuig;
		}
	}
	
	public Voertuig plaatsVerlaten() throws IllegalArgumentException{
		
		Voertuig returnVoertuig= this.voertuig;
		
		if(!isBezet()){
			throw new IllegalArgumentException("Hier staat geen voertuig!");
		}
		else{
			this.bezet = false;
			this.voertuig = null;
			return returnVoertuig;
		}		
	}

	@Override
	public String toString() {
		String result;
		result = String.format("Type plaats: %1$5s Voertuig: %2$-45s Bezet: %3$5s \n", type, voertuig, bezet);
		return result;
		//return "Plaats [voertuig=" + voertuig + ", bezet=" + bezet + ", type=" + type + "]";
	}
	
	

}
