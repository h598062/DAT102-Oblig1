package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	// Ingen referanse til siste, kun start
	private LinearNode<Film> start;
	private int ant;

	public Filmarkiv2() {
		this.start = null;
		this.ant = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		if (start == null) return null;
		LinearNode<Film> node = start;
		Film resultat = null;
		while (node.getNeste() != null && resultat == null) {
			if (node.getElement().getFilmnr() == nr) {
				resultat = node.getElement();
			}
			node = node.getNeste();
		}
		return resultat;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (nyFilm == null) return;
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		if (start == null) {
			start = nyNode;
		} else {
			LinearNode<Film> node = start;
			while (node.getNeste() != null) {
				node = node.getNeste();
			}
			node.setNeste(nyNode);
		}
		ant++;
	}


	@Override
	public boolean slettFilm(int filmnr) {
		if (start == null) return false;
		if (start.getElement().getFilmnr() == filmnr) {
			start = start.getNeste();
			return true;
		}
		LinearNode<Film> node = start;
		LinearNode<Film> forrige = null;
		while (node.getNeste() != null) {
			forrige = node;
			node = node.getNeste();
			if (node.getElement().getFilmnr() == filmnr) {
				forrige.setNeste(node.getNeste());
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekProdusent(String produsent) {
		if (start == null) return new Film[0];
		Film[] nyTab = new Film[ant];
		int pos = 0;
		LinearNode<Film> node = start;
		do {
			if (node.getElement().getProdusent().equals(produsent)) {
				nyTab[pos] = node.getElement();
				pos++;
			}
			node = node.getNeste();
		} while (node != null);
		return trimTab(nyTab, pos);
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		if (start == null) return new Film[0];
		Film[] nyTab = new Film[ant];
		int pos = 0;
		LinearNode<Film> node = start;
		do {
			if (node.getElement().getTittel().contains(delstreng)) {
				nyTab[pos] = node.getElement();
				pos++;
			}
			node = node.getNeste();
		} while (node != null);
		return trimTab(nyTab, pos);
	}

	@Override
	public int antall() {
		return this.ant;
	}

	@Override
	public int antall(Sjanger sjanger) {
		if (start == null) return 0;
		int resultat = 0;
		LinearNode<Film> node = start;
		do {
			if (node.getElement().getSjanger().equals(sjanger)) {
				resultat++;
			}
			node = node.getNeste();
		} while (node != null);
		return resultat;
	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
}
