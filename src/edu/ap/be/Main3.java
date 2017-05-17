package edu.ap.be;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main3 {

	private static String[] autoMerknamen= {"Audi", "BMW", "Opel", "Renault"};
	private static String[] autoModelnamen= {"A3", "X3", "Astra", "Picasso", "Antara", "Clio", "Zafira"};
	private static String[] fietsMerknamen= {"Gazelle", "Koga", "Batavu", "Merckx"};
	private static String[] fietsModelnamen= {"Traptdoor", "Pedalo", "DraaienMaar", "Smarty", "Bellie"};
	private static String[] stepMerknamen= {"Studio 100", "Disney"};
	private static String[] stepModellen= {"Bumba", "Frozen", "K3", "GhostRockers", "PiratesOf The Caribien"};
	private static final int AANTAL_VOERTUIGEN = 80;
	private static final int AANTAL_GARAGES = 8;
	private static final int MAX_AANTAL_PLAATSEN_PER_GARAGE = 10;

	public static void main(String[] args) {

		List<Voertuig> voertuigen = genereerRandomVoertuigen();
		List<Garage> garages = genereerRandomGarages();

		Iterator<Voertuig> it= voertuigen.iterator();

		while(it.hasNext()){
			Voertuig huidigVoertuig= it.next();
			boolean plaatsGevonden= false;
			int i = 0;

			while(!plaatsGevonden && i < garages.size()){
				Garage g = garages.get(i);
				//System.out.println(g);

				try{
					g.garageInrijden(huidigVoertuig);
					plaatsGevonden= true;
				}catch(GeenPlaatsGevondenException e){
					plaatsGevonden= false;
				}
				//System.out.println(g);
				i++;
			}

			if(!plaatsGevonden) {
				System.out.println("Volgend voertuig is niet gestald kunnen worden: " + huidigVoertuig.toString());
			}else{
				it.remove();
			}
		}
		
		System.out.println("Aantal niet gestalde voertuigen: " + voertuigen.size());
		for(Garage g: garages){
			System.out.println(g.toString());
//			System.out.println(g.aantalPlaatsenVrij());
//			System.out.println(g.aantalPlaatsenVrij(Type.KLEIN));
//			System.out.println(g.aantalPlaatsenVrij(Type.GROOT));
		}
		
	}
	
	private static List<Garage> genereerRandomGarages() {
		List<Garage> garages = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < AANTAL_GARAGES; i++){
			garages.add(new Garage(1 + r.nextInt(MAX_AANTAL_PLAATSEN_PER_GARAGE)));
		}
		return garages;
	}
	
	private static List<Voertuig> genereerRandomVoertuigen() {
		
		List<Voertuig> voertuigen = new ArrayList<>();
		Random r = new Random();
		
		for(int i = 0; i < AANTAL_VOERTUIGEN; i++){
			//1. Bepaal type voertuig: 0 = auto, 1 = fiets, 2 = elektrische fiets, 3 = step
			int voertuigType= r.nextInt(4);
			Voertuig v = null;
			
			if(voertuigType== 0){
				//Random uitstoortussen 80 en 159
				double uitstoot = r.nextDouble() + (r.nextInt(80) + 80);
				//Willekeurige merk-en modelnaam uitkiezen
				String merknaam = autoMerknamen[r.nextInt(autoMerknamen.length)];
				String modelNaam= autoModelnamen[r.nextInt(autoModelnamen.length)];
				//Willekeurige inschrijvingsdatum, ligt tussen nu en 2500 dagen terug
				LocalDate inschrijvingDatum= LocalDate.now().minusDays(r.nextInt(2500));
				v = new Auto(merknaam, modelNaam, uitstoot, inschrijvingDatum);
			}
			else if(voertuigType== 1){
				byte versnellingen = (byte)(r.nextInt(24) + 1);
				String merknaam = fietsMerknamen[r.nextInt(fietsMerknamen.length)];
				String modelNaam= fietsModelnamen[r.nextInt(fietsModelnamen.length)];
				v = new Fiets(merknaam, modelNaam, versnellingen);
			}
			else if(voertuigType== 2){
				byte versnellingen = (byte)((r.nextInt(2) + 1) * 3); //ofwel 3, ofwel 6 versnellingen
				String merknaam = fietsMerknamen[r.nextInt(fietsMerknamen.length)];
				String modelNaam= fietsModelnamen[r.nextInt(fietsModelnamen.length)];
				int actieRadius= r.nextInt(70);
				v = new ElektrischeFiets(merknaam, modelNaam, versnellingen, actieRadius);
			}
			else{
				String merknaam = stepMerknamen[r.nextInt(stepMerknamen.length)];
				String modelNaam= stepModellen[r.nextInt(stepModellen.length)];
				v = new Step(merknaam, modelNaam);
			}
			voertuigen.add(v);
		}
		return voertuigen;
	}

}
