package no.hvl.dat102.adt;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class KoeADTTest {
	private KoeADT<Integer> koe;

	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	@BeforeEach
	public void setup() {
		koe = reset();
	}

	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test på innKoe and utKoe.
	 */
	@Test
	public void innKoeOgUtKoe() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på innKoe og utKoe med duplikate verdier.
	 */
	@Test
	public void innKoeOgUtKoeMedDuplikater() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing på foerste.
	 */
	@Test
	public void innKoeutKoeinnKoeinnKoeutKoefoerste() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);
			koe.utKoe();
			assertEquals(e4, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("utKoe eller foerste feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på at en koe med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test på at en koe med null elementer er tom.
	 */
	@Test
	public void innKoeutKoeErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("innKoe eller utKoe feilet uventet " + e.getMessage());
		}
	}


	/**
	 * Forsøk på utKoe av en tom koe skal gi "underflow excepton" *
	 *
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void utKoeFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 *
		 * @Override public void execute() throws Throwable { koe.utKoe(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}

}
