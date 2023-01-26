package no.hvl.dat102.klient;

import no.hvl.dat102.Filmarkiv2;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv2 {
	public static void main(String[] args) {
		FilmarkivADT filma = new Filmarkiv2();
		Meny meny = new Meny(filma);
		meny.start();
	}
}
