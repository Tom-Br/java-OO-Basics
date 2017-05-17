package edu.ap.be;

import java.time.LocalDate;

public class Main2 {

	public static void main(String[] args) throws Exception {
		
		Plaats grotePlaats= new Plaats(Plaats.Type.GROOT);
		Plaats kleinePlaats= new Plaats(Plaats.Type.KLEIN);
		Auto a = new Auto("Audi", "A3", 97.1, LocalDate.now());
		ElektrischeFiets ef = new ElektrischeFiets("Gazelle", "Electron", (byte) 6, 55);
		Step s = new Step("Disney", "Frozen");
		
		if(grotePlaats.isBezet() || kleinePlaats.isBezet()){
			throw new Exception("Kijk de implementatie van isBezetna, deze klopt niet...");
		}
		
		try{
			grotePlaats.plaatsVerlaten();
			throw new Exception("Oeps, het verlaten van een plaats zou een exception moeten geven maar dat gebeurd niet");
		}catch (IllegalArgumentException iae){
			//Alles goed, dat verwachten we
		}
		
		try{
			kleinePlaats.voertuigStallen(a);
			throw new Exception("Oeps, het stallen van een auto in een kleine plaats zou een exceptio nmoeten geven ...");
		}catch (IllegalArgumentException iae){
			//Alles goed, dat verwachten we
		}
		
		try{
			kleinePlaats.voertuigStallen(ef);
			throw new Exception("Oeps, het stallen van een EF in een kleine plaats zou een exception moeten geven...");
		}catch (IllegalArgumentException iae){
			//Alles goed, dat verwachten we
		}
		
		grotePlaats.voertuigStallen(a);
		kleinePlaats.voertuigStallen(s);
		
		if(!grotePlaats.isBezet() || !kleinePlaats.isBezet()){
			throw new Exception("Kijk de implementatie van isBezet na, deze klopt niet...");
		}
		
		try{
			kleinePlaats.voertuigStallen(a);
			throw new Exception("Oeps, het stallen van een reeds bezette plaats zou een fout moeten geven");
		}catch (IllegalArgumentException iae){
			//Alles goed, dat verwachten we
		}
		
		Voertuig v = grotePlaats.plaatsVerlaten();
		if(v != a) throw new Exception("Oeps, de grote plaats heeft een fout object teruggegeven");
		if(grotePlaats.isBezet()) throw new Exception("Oeps, de grote plaats zou leeg moeten zijn maar dat is ze niet");
		System.out.println("Als je deze uitvoer leest, zijn alle tests geslaagd!");
	}

}
