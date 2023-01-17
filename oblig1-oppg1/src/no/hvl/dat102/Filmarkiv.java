package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmtab;
	private int ant;

	public Filmarkiv(int storrelse) {
		this.filmtab = new Film[storrelse];
		this.ant = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (nyFilm != null) {
			if (this.ant == filmtab.length) {
				utvid();
			} else if (this.ant > filmtab.length) {
				System.out.println("Uhh, dette burde ikkje skje...\nfilmtab lengde: " + filmtab.length + "\nantall filmer: " + ant);
				return;
			}
			filmtab[ant] = nyFilm;
			ant++;
		}

	}

	private void utvid() {
		System.out.println("Utvider arkivtabell fra " + filmtab.length + " til " + filmtab.length * 2);
		Film[] nytab = new Film[filmtab.length * 2];
		System.arraycopy(filmtab, 0, nytab, 0, filmtab.length);
		filmtab = nytab;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		return new Film[0];
	}

	@Override
	public int antall(Sjanger sjanger) {
		return 0;
	}

	@Override
	public int antall() {
		return this.ant;
	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int    i     = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
}
