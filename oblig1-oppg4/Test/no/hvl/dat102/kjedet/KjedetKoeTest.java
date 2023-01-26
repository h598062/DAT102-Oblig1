package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;

class KjedetKoeTest extends KoeADTTest {
	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<>();
	}
}
