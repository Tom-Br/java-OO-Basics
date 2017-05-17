package edu.ap.be;

import java.util.ArrayList;

import edu.ap.be.Plaats.Type;

public class Garage {
	
	private static int teller = 0;
	
	private int id;
	private ArrayList<Plaats> garagePlaatsen;
	private int aantalPlaatsen;
	
	public Garage(int aantalPlaatsen) {
		super();
		teller++;
		this.id = teller;
		this.aantalPlaatsen = aantalPlaatsen;
		
		garagePlaatsen = new ArrayList<>(aantalPlaatsen);		
		plaatsenGenereren();
		
	}
	
	private void plaatsenGenereren(){
		
		int aantalKlein = 0;
		for (int i = 0 ; i < aantalPlaatsen; i++){
			if (aantalKlein <= ((aantalPlaatsen/3)*2)){
				garagePlaatsen.add(new Plaats(Type.KLEIN));
				aantalKlein++;
				
			}
			else{
				garagePlaatsen.add(new Plaats(Type.GROOT));
			}
			
		}
		
	}	
	
	public int getId() {
		return id;
	}

	public int aantalPlaatsenVrij(){
		int teller = 0;
		
		for(int i = 0 ; i < this.garagePlaatsen.size(); i++){
			if(!garagePlaatsen.get(i).isBezet()){
				teller++;
			}
		}
		return teller;
	}
	
	public int aantalPlaatsenVrij(Type type){
		
		int teller = 0;
		
		for(int i = 0 ; i < this.garagePlaatsen.size(); i++){
			if(!garagePlaatsen.get(i).isBezet() && (garagePlaatsen.get(i).getType() == type) ){
				teller++;
			}
		}
		
		return teller;
	}
	
	public double getGemiddeldeCOUitstoot(){
		int aantalVoertuigenMetCO = 0;
		double somCO = 0;
		
		for(int i = 0 ; i < this.garagePlaatsen.size(); i++){
			if(garagePlaatsen.get(i).getVoertuig() instanceof Gemotoriseerd && ( (Gemotoriseerd)garagePlaatsen.get(i).getVoertuig()).getCOUitstoot() != 0){
				aantalVoertuigenMetCO++;
				somCO += ((Gemotoriseerd) garagePlaatsen.get(0).getVoertuig()).getCOUitstoot();
			}
		}
		
		return somCO/aantalVoertuigenMetCO;
	}

	public int garageInrijden(Voertuig voertuig) throws GeenPlaatsGevondenException{
		
		boolean plaatsGevonden = false;		
		int plaatsID = 0;
		
		while (!plaatsGevonden){
			if (plaatsID >= aantalPlaatsen){
				throw new GeenPlaatsGevondenException();
			}
			else{
				try{
					garagePlaatsen.get(plaatsID).voertuigStallen(voertuig);
					plaatsGevonden = true;
				}catch (IllegalArgumentException ex) {
					plaatsGevonden = false;
					plaatsID++;
				}
			}
		}
		
		return plaatsID;
	}
	
	public Voertuig garageUitrijden(int plaatsnummer){
		
		return garagePlaatsen.get(plaatsnummer).plaatsVerlaten();
		
	}

	@Override
	public String toString() {
		String result;
		result = String.format("Garage %1$d : \n", id);
		for (Plaats plaats : garagePlaatsen) {
			result += String.format("- %1$s", plaats);
		}
		result += String.format("Aantal Plaatsen : %1$d", aantalPlaatsen);
		return result;
		//return "Garage [id=" + id + ", garagePlaatsen=" + garagePlaatsen + ", aantalPlaatsen=" + aantalPlaatsen + "]";
	}
	
	

}
