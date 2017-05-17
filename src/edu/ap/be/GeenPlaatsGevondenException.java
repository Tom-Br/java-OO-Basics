package edu.ap.be;

public class GeenPlaatsGevondenException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6960953087922267249L;

	public GeenPlaatsGevondenException(){
		super("Voor het opgegeven voertuig hebben we geen plaats gevonden in de garage.");
	}

}
