package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.Sjanger;

import java.util.Scanner;

import static no.hvl.dat102.Sjanger.*;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dette er en interaktiv metode for å legge inn en ny film.");
		System.out.print("Vær vennlig og skriv inn filmnr: ");
		int nr = Integer.parseInt(scanner.nextLine());
		System.out.print("Vær vennlig og skriv inn produsent: ");
		String produsent = scanner.nextLine();
		System.out.print("Vær vennlig og skriv inn tittel: ");
		String tittel = scanner.nextLine();
		System.out.print("Vær vennlig og skriv inn lanseringsår: ");
		int aar = Integer.parseInt(scanner.nextLine());
		System.out.println("Vær vennlig og skriv inn sjanger: ");
		System.out.print("Mulige sjangre: ");
		for (Sjanger s : Sjanger.referanseTab()) {
			System.out.print(s + ", ");
		}
		System.out.print("\nValgt sjanger: ");
		String sjangerString = scanner.nextLine().toUpperCase();
		Sjanger sjanger = Sjanger.valueOf(sjangerString);
		System.out.print("Vær vennlig og skriv inn filmselskap: ");
		String filmSelskap = scanner.nextLine();
		scanner.close();
		return new Film(nr, produsent, tittel, aar, sjanger, filmSelskap);
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println(film.toString());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmInneholder = filma.soekTittel(delstreng);
		for (Film film : filmInneholder) {
			visFilm(film);
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] filmInneholder = filma.soekProdusent(delstreng);
		for (Film film : filmInneholder) {
			visFilm(film);
		}	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		Sjanger[] sjangers = Sjanger.referanseTab();
		System.out.println("Det er " + filma.antall() + " filmer! WAOOOW");

		for (int i = 0; i < sjangers.length; i++) {
			System.out.println("Det er: " + filma.antall(sjangers[i]) + " " + sjangers[i].toString());
		}

	}
}
