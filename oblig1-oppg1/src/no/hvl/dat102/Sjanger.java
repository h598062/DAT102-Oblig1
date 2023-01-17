package no.hvl.dat102;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI;

	public static int antall() {
		return Sjanger.values().length;
	}

	public static Sjanger[] referanseTab() {
		return Sjanger.values();
	}
}
