package adn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MotifADNTest {
	
	private String motifStr = "ACGTGTACGTATGGCA"; 
	private MotifADN motif = new MotifADN(motifStr);
	private MotifADN motifVide = new MotifADN("");
	
	@Test
	public void testGetReverse() {
		assertEquals(motif.getReverse(), "ACGGTATGCATGTGCA");
		assertEquals(motifVide.getReverse(), "");
	}
	
	@Test
	public void testGetCompl() {
		assertEquals(motif.getCompl(), "TGCACATGCATACCGT");
		assertEquals(motifVide.getCompl(), "");
	}
	
	@Test
	public void testGetRevCompl() {
		assertEquals(motif.getRevCompl(), "TGCCATACGTACACGT");
		assertEquals(motifVide.getRevCompl(), "");
	}
	
}
