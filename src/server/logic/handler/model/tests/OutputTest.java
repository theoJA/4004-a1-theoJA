package server.logic.handler.model.tests;

import static org.junit.Assert.*;
import server.logic.handler.model.Output;

import org.junit.Test;

public class OutputTest {

	private Output testOutput = new Output("newOutput");
	
	@Test
	public void test_getOutput() {
		assertEquals("newOutput", testOutput.getOutput());
	}

}