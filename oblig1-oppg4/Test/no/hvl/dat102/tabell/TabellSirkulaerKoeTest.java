package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TabellSirkulaerKoeTest extends KoeADTTest {
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<>();
	}

	@Test
	void utviderSeg() {
		int SIZE = 10;
		int utvidSIZE = (2*SIZE) + 7;
		KoeADT<Integer> koe = new TabellSirkulaerKoe<>(SIZE);
		for (int i = 0; i < utvidSIZE; i++) {
			koe.innKoe(i);
		}
		int i = 0;
		while (!koe.erTom()) {
			koe.utKoe();
			i++;
		}
		assertEquals(utvidSIZE, i);
		assertTrue(koe.erTom());
	}
}
