package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;

public class TabellSirkulaerKoeTest extends KoeADTTest {
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<>();
	}
}
