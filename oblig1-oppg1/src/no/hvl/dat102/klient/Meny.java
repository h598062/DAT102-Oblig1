package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		// legg inn en del forhåndsdefinerte filmer
		filmarkiv.leggTilFilm(new Film(1,
				"Bjørnar",
				"Bjørnar og sjølvaste Ole Brumm på eventyr, med en liten twist",
				2020,
				Sjanger.DRAMA,
				"Bjørnars Disipler"));
		filmarkiv.leggTilFilm(new Film(2, "Kristian", "Kristians og hans første julenøtt", 2096, Sjanger.SCIFI, "Bells CO"));
		filmarkiv.leggTilFilm(new Film(3, "Storm", "Store Sterke Storm", 1915, Sjanger.HISTORY, "Alle"));

		// filmarkiv.leggTilFilm(tekstgr.lesFilm());
		System.out.println("Vis film nummer 1: ");
		tekstgr.visFilm(filmarkiv.finnFilm(1));
		System.out.println("Skriv ut filmer der tittel inneholder og: ");
		tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "og");
		System.out.println("Skriv ut filmer der produsenten er Storm");
		tekstgr.skrivUtFilmProdusent(filmarkiv, "Storm");
		System.out.println("Skriv ut statistikk for antall filmer og filmer per sjanger");
		tekstgr.skrivUtStatistikk(filmarkiv);
	}
}

