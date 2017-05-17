package edu.ap.be;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Voertuig> voertuigen = new ArrayList<>();
		voertuigen.add(new Auto("Audi", "A3", 97.1,  LocalDate.now()));
		voertuigen.add(new Fiets("Gazelle", "One"));
		voertuigen.add(new Fiets("Gazelle", "SixStep", (byte) 6));
		voertuigen.add(new ElektrischeFiets("Gazelle", "Electron", (byte) 6, 55));
		voertuigen.add(new Step("Disney", "Frozen"));
		
		for (Voertuig v : voertuigen) {
			String uitstoot = "";
			
			if (v instanceof Gemotoriseerd) {
				uitstoot = String.format("%.1f gr/km", ((Gemotoriseerd) v).getCOUitstoot());
			}
			
			System.out.printf("%s (%s) %s%n", v.toString(), (v.isBestuurbaarDoorKinderen() ? "KT" : "KNT"), uitstoot);
		}

	}

}
