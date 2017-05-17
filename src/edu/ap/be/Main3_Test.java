package edu.ap.be;

import java.time.LocalDate;

import edu.ap.be.Plaats.Type;

public class Main3_Test {

	public static void main(String[] args) {
		
		Garage g1 = new Garage(5);
		System.out.println(g1.toString());
		Auto a = new Auto("Audi", "A3", 97.1, LocalDate.now());
		//ElektrischeFiets ef = new ElektrischeFiets("Gazelle", "Electron", (byte) 6, 55);
		Step s = new Step("Disney", "Frozen");
		
		System.out.println(g1.aantalPlaatsenVrij());
		System.out.println(g1.aantalPlaatsenVrij(Type.KLEIN));
		System.out.println(g1.aantalPlaatsenVrij(Type.GROOT));
		
		try {
			g1.garageInrijden(a);
		} catch (GeenPlaatsGevondenException e) {
			e.getMessage();
		}catch (IllegalArgumentException e) {
			e.getMessage();
		}
		
		try {
			g1.garageInrijden(s);
		} catch (GeenPlaatsGevondenException e) {
			e.getMessage();
		}catch (IllegalArgumentException e) {
			e.getMessage();
		}
		
		System.out.println(g1.toString());
		System.out.println(g1.aantalPlaatsenVrij());
		System.out.println(g1.aantalPlaatsenVrij(Type.KLEIN));
		System.out.println(g1.aantalPlaatsenVrij(Type.GROOT));
		
		
	}

}
