package ca.mcgill.mcb.pcingola.snpEffect.testCases.unity;

import org.junit.Test;

import ca.mcgill.mcb.pcingola.interval.SpliceSite;
import ca.mcgill.mcb.pcingola.interval.Variant;
import ca.mcgill.mcb.pcingola.snpEffect.EffectType;
import ca.mcgill.mcb.pcingola.util.Gpr;

/**
 * Test Splice sites variants
 *
 * @author pcingola
 */
public class TestCasesSpliceRegion extends TestCasesBase {

	public TestCasesSpliceRegion() {
		super();
	}

	@Override
	protected void init() {
		super.init();
		randSeed = 20141205;
		minExons = 2;
		spliceRegionExonSize = SpliceSite.SPLICE_REGION_EXON_SIZE;
		spliceRegionIntronMin = SpliceSite.SPLICE_REGION_INTRON_MIN;
		spliceRegionIntronMax = SpliceSite.SPLICE_REGION_INTRON_MAX;
	}

	@Test
	public void test_01() {
		Gpr.debug("Test");

		if (verbose) Gpr.debug("Transcript:" + transcript);

		// All these positions should have splice_region effects
		int spliceRegionPos[] = { 808, 809, 810 // Exon_1 end
				, 813, 814, 815, 816, 817, 818 // Intron start
				, 1005, 1006, 1007, 1008, 1009, 1010 // Intron end
				, 1013, 1014, 1015 // Exon_2 start
		};

		// Create a variant that hits splice_region
		int i = 1;
		for (int pos : spliceRegionPos) {
			Gpr.showMark(i, 1);
			Variant variant = new Variant(chromosome, pos, "A", "T");
			checkEffect(variant, EffectType.SPLICE_SITE_REGION);
		}
	}
}
