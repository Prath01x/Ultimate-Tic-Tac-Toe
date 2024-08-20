package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

public class SimpleTest {

	SimulatorInterface simulator;

	@Before
	public void setUp() throws Exception {
		simulator = UTTTFactory.createSimulator();

	}

	@Test
	public void simpleSetPieceTest() {
		assertNotNull(simulator);
	}

}
