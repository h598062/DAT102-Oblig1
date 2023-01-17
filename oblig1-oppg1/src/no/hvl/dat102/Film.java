package no.hvl.dat102;

import java.util.Objects;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsaar;
	private Sjanger sjanger;
	private String filmselskap;

	public Film(int filmnr, String produsent, String tittel, int lanseringsaar, Sjanger sjanger,
			String filmselskap
	) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsaar = lanseringsaar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public Film() {
	}

	@Override
	public String toString() {
		return "Film{" +
		       "filmnr=" + filmnr +
		       ", produsent='" + produsent + '\'' +
		       ", tittel='" + tittel + '\'' +
		       ", lanseringsaar=" + lanseringsaar +
		       ", sjanger=" + sjanger +
		       ", filmselskap='" + filmselskap + '\'' +
		       '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Film film = (Film) o;
		return filmnr == film.filmnr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmnr);
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsaar() {
		return lanseringsaar;
	}

	public void setLanseringsaar(int lanseringsaar) {
		this.lanseringsaar = lanseringsaar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
}
