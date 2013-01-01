package com.owtelse.util;

import java.net.URL;

import com.owtelse.util.UrlSigner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlSignerTest {

  public static final String WibbleWobble1_Encoded = "V2liYmxlV29iYmxlMQ==";

	UrlSigner s =null;
	
	@Before
	public void setUp() throws Exception {
		s = new UrlSigner(WibbleWobble1_Encoded);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUrlSigner() {
		assertNotNull(s);
	}

	@Test
	public void testSignRequest() throws Exception {

		String myURL = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=15+Banksia+St,Dee+Why,NSW&client=gme-allianz";
		URL url = new URL(myURL);
		String signed = s.signURL(url);
		assertNotNull(signed);
		assertTrue(signed.length() >= 0);
		
		 String expect = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=15+Banksia+St,Dee+Why,NSW&client=gme-allianz&signature=qK3iNY_EnV8ppgvlLa6u36hKKbQ=";
		 assertEquals(expect, signed);
	}

}
