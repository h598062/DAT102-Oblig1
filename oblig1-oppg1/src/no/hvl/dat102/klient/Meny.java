package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
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

		// tekstgr.lesFilm();
		tekstgr.visFilm(filmarkiv.finnFilm(1));
		tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "og");
		tekstgr.skrivUtFilmProdusent(filmarkiv, "Storm");
	}
}

