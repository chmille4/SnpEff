package ca.mcgill.mcb.pcingola.snpEffect.testCases.integration;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import ca.mcgill.mcb.pcingola.snpEffect.commandLine.SnpEffCmdProtein;
import ca.mcgill.mcb.pcingola.util.Gpr;

/**
 * Protein translation test case
 *
 * @author pcingola
 */
public class TestCasesProtein {

	@Test
	public void test_01() throws IOException {
		Gpr.debug("Test");
		String args[] = { "testHg3763ChrY", "./tests/proteins_testHg3763ChrY.txt" };

		SnpEffCmdProtein cmd = new SnpEffCmdProtein();
		cmd.parseArgs(args);
		cmd.run();

		// Check that it is OK
		Assert.assertEquals(0, cmd.getTotalErrors());
		Assert.assertEquals(true, cmd.getTotalOk() >= 167);
	}
}
