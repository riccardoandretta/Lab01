package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	private List<String> parole;
		
	public Parole() {
		this.parole = new ArrayList<>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.removeAll(parole);
	}
	
	public void cancella(String s) {
		parole.remove(s);
	}

}
